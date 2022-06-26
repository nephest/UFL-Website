package server.api;

import commons.entities.Tournament;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.database.TournamentRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final Random random;
    private final TournamentRepository repo;

    /**
     * Constructs a new activity controller object
     * @param random the random generator of activities
     * @param repo the activity repository
     */
    public TournamentController(Random random, TournamentRepository repo) {
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
     * Retrieves all tournaments from the repository and sends them
     * to the client
     * @return a list of all tournaments in the repository
     */
    @GetMapping(path = { "", "/" })
    public List<Tournament> getAll() {
        return repo.findAll();
    }

    /**
     * Saves a tournament sent by the client to the tournament repository
     * @param tournament the tournament to save
     * @return the saved tournament entity
     */
    @PostMapping(path = { "", "/" })
    public ResponseEntity<Tournament> add(@RequestBody Tournament tournament) {
        if (isNullOrEmpty(tournament.title)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Tournament saved = repo.save(tournament);
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
    public ResponseEntity<Optional<Tournament>> getById(@PathVariable("id") long id) {
        if (id < 0 || !repo.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repo.findById(id));
    }

    /**
     * Deletes a tournament from the database if a tournament
     * with the given id exists. Otherwise, returns a bad request
     * @param id the id of the tournament to delete
     * @return the deleted tournament if it exists
     */
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Tournament> delete(@PathVariable("id") long id) {
        if (id < 0 || !repo.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
