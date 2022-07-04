package commons.models;

import java.util.Objects;

public class Player {
    public String name;
    public String bnet;
    public String race; /* maybe we can use the race attributes from sc2pulse?*/

    public Player ( String name, String bnet, String race ) {
        this.name = name;
        this.bnet = bnet;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBnet() {
        return bnet;
    }

    public void setBnet(String bnet) {
        this.bnet = bnet;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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
        Player player = (Player) object;
        return java.util.Objects.equals(name, player.name) && java.util.Objects.equals(bnet, player.bnet) &&
                java.util.Objects.equals(race, player.race);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), name, bnet, race);
    }
}