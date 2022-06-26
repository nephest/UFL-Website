package commons.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Format {
    private int numberOfGames;
    private int gamesPerPlayer;

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getGamesPerPlayer() {
        return gamesPerPlayer;
    }

    public void setGamesPerPlayer(int gamesPerPlayer) {
        this.gamesPerPlayer = gamesPerPlayer;
    }

    public Format (int numberOfGames, int gamesPerPlayer ) {
        this.numberOfGames = numberOfGames;
        this.gamesPerPlayer = gamesPerPlayer;
    }

}