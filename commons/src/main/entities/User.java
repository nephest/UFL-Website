package commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

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
        User user = (User) object;
        return id == user.id && accountName.equals(user.accountName) && displayName.equals(user.displayName) &&
                bnetId.equals(user.bnetId);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, accountName, displayName, bnetId);
    }

    @Column(name = "accountName")
    public string accountName;

    @Column(name = "displayName")
    public string displayName;

    @Column(name = "bnet" )
    public string bnetId;

    public User ( string accountName ) {
        this.accountName = accountName;
        this.displayName = accountName;
    }

    public string getAccountName() {
        return accountName;
    }

    public void setAccountName(string accountName) {
        this.accountName = accountName;
    }

    public string getDisplayName() {
        return displayName;
    }

    public void setDisplayName(string displayName) {
        this.displayName = displayName;
    }

    public string getBnetId() {
        return bnetId;
    }

    public void setBnetId(string bnetId) {
        this.bnetId = bnetId;
    }

    public User (string accountName, string bnetId ) {
        this.accountName = accountName;
        this.displayName = accountName;
        this.bnetId = bnetId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
