package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class PlayerServiceStub implements PlayerService {

    private List<Player> players = new ArrayList<Player>();

    /**
     * Get a list of players in a specific team
     * @param teamId The id of the team
     * @return list of players in the team
     */
    public List<Player> getPlayers(int teamId) {
        List<Player> teamPlayers = new ArrayList<Player>();
        for(Player player: players) {
            if (player.getTeamId() == teamId) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    public List<Player> getPlayersByAbbreviation(String abbreviation) {
        return null;
    }

    /**
     * Returns the player with the provided id
     * @param playerId the id of the player
     * @return the player
     */
    public Player getPlayer(int playerId) {
        for (Player player : players) {
            if (player.getPlayerId() == playerId) {
                return player;
            }
        }
        return null; // TODO: throw exception
    }


    /**
     * Added a player to the list and returns the players id
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
        return players.size();
    }
}
