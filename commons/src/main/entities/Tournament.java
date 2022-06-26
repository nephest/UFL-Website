package commons.entities;

import commons.models.Format;
import commons.entities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "title")
    public string title;

    @Column(name = "description")
    public string description;

    public Format format;

    public Tournament ( Format format ) {
        this.format = format;
        this.admins = new HashList<User>();
    }

    private List<User> admins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public string getDescription() {
        return description;
    }

    public void setDescription(string description) {
        this.description = description;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void addAdmin ( User user ) {
        admins.add ( user );
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Tournament that = (Tournament) object;
        return id == that.id && java.util.Objects.equals(title, that.title) &&
                java.util.Objects.equals(description, that.description) && rule.equals(that.rule);
    }

    public string getTitle() {
        return title;
    }

    public void setTitle(string title) {
        this.title = title;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title, description, rule);
    }
}

