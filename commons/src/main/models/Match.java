package commons.models;

import commons.models.Player;
import commons.utils.Map;

import java.util.List;
import java.util.HashList;

public class Match {
    public List<Player> teamA;
    public List<Player> teamB;
    public List<Map> mapPool;
    public scoreA;
    public scoreB;

    public Match () {
        teamA = new HashList<Player>();
        teamB = new HashList<Player>();
        mapPool = new HashList<Map>();
        scoreA = scoreB = 0;
    }

    public List<Player> getTeamA() {
        return teamA;
    }

    public List<Player> getTeamB() {
        return teamB;
    }

    public List<Map> getMapPool() {
        return mapPool;
    }

    public void addPlayerToTeamA ( Player player ) {
        teamA.add ( player );
    }

    public void addPlayerToTeamB ( Player player ) {
        teamB.add ( player );
    }

    public void addMapToMapPool ( Map map ) {
        mapPool.add ( map );
    }
}