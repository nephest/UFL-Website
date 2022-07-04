package commons.models;

import commons.utils.Map;

import java.util.LinkedList;
import java.util.List;

public class Match {
    public List<Player> teamA;
    public List<Player> teamB;
    public List<Map> mapPool;
    public int scoreA;
    public int scoreB;

    public Match () {
        teamA = new LinkedList<Player>();
        teamB = new LinkedList<Player>();
        mapPool = new LinkedList<Map>();
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