package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class PlayerServiceStub extends AbstractPlayerService {

    private List<Player> players = new ArrayList<Player>();
    private TeamServiceStub teamService = new TeamServiceStub();
    private List<Observer> observers = new ArrayList<Observer>();

    // region override methods
    /**
     * Returns the player with the provided id
     *
     * @param playerId the id of the player
     * @return the player
     */
    public Player getPlayer(int playerId) {
        for (Player player : players) {
            if (player.getPlayerId() == playerId) {
                return player; // Found the player
            }
        }
        return null; // return null because player was not found
    }

    /**
     * Get a list of players in a specific team
     *
     * @param teamId The id of the team
     * @return list of players in the team
     */
    public List<Player> getPlayers(int teamId) {
        List<Player> teamPlayers = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getTeamId() == teamId) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    /**
     * Gets all the players from a given team
     *
     * @param teamAbbreviation The abbrevation for the team
     * @return list of players in the team
     */
    public List<Player> getPlayersByTeam(String teamAbbreviation) {
        Team team = teamService.getTeamByAbbreviation(teamAbbreviation); // get the team

        List<Player> teamPlayers = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getTeamId() == team.getTeamId()) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    /**
     * Added a player to the list and returns the players id
     *
     * @param newPlayer the new player
     * @return the id for the new player
     * @throws ServiceException if the newPlayer is invalid an exception is thrown
     */
    public int addPlayer(Player newPlayer) throws ServiceException {

        // Validate player
        if (newPlayer.getFirstName() == null ||
                newPlayer.getFirstName().equals("") ||
                newPlayer.getLastName() == null ||
                newPlayer.getLastName().equals("") ||
                newPlayer.getTeamId() == 0) {
            throw new ServiceException();
        }

        if (players.isEmpty()) {
            newPlayer.setPlayerId(1);
        } else {
            newPlayer.setPlayerId(players.size() + 1);
        }
        players.add(newPlayer);
        notifyObservers(newPlayer);
        return players.size();
    }
    // endregion

}
