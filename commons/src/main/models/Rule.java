package commons.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Rule {
    public string format;
    public int games;

    public Rule ( string format, int games ) {
        this.format = format;
        this.games = games;
    }
}