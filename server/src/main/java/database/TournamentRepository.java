package server.database;

import commons.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query(value = "SELECT * FROM Tournament", nativeQuery = true)
    List<Activity> getList();
}
