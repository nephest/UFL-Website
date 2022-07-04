package server.api;

import commons.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.database.UserRepository;


import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Random random;
    private final UserRepository repo;

    /**
     * Constructs a new activity controller object
     * @param random the random generator of activities
     * @param repo the activity repository
     */
    public UserController(Random random, UserRepository repo) {
        this.random = random;
        this.repo = repo;
    }

    /**
     * Checks whether a String is null or empty
     * @param s the string to check
     * @return true if the string is null or empty
     */
    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    /**
     * Retrieves all user from the repository and sends them
     * to the client
     * @return a list of all tournaments in the repository
     */
    @GetMapping(path = { "", "/" })
    public List<User> getAll() {
        return repo.findAll();
    }

    /**
     * Saves a user sent by the client to the user repository
     * @param user the user to save
     * @return the saved user entity
     */
    @PostMapping(path = { "", "/" })
    public ResponseEntity<User> add(@RequestBody User user) {
        if (isNullOrEmpty(user.accountName)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        User saved = repo.save(user);
        return ResponseEntity.ok(saved);
    }

    /**
     * Retrieves a tournament by a given id and
     * returns a bad request if a tournament with that
     * id does not exist
     * @param id the id of the tournament to retrieve
     * @return the requested tournament
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable("id") long id) {
        if (id < 0 || !repo.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repo.findById(id));
    }

    /**
     * Deletes a user from the database if a tournament
     * with the given id exists. Otherwise, returns a bad request
     * @param id the id of the user to delete
     * @return the deleted user if it exists
     */
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<User> delete(@PathVariable("id") long id) {
        if (id < 0 || !repo.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
