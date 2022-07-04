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
    public String accountName;

    @Column(name = "displayName")
    public String displayName;

    @Column(name = "bnet" )
    public String bnetId;

    public User ( String accountName ) {
        this.accountName = accountName;
        this.displayName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBnetId() {
        return bnetId;
    }

    public void setBnetId(String bnetId) {
        this.bnetId = bnetId;
    }

    public User (String accountName, String bnetId ) {
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
