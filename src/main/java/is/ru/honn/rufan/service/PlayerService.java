package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Subject;

import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public interface PlayerService extends Subject {
    /**
     * Get a player with a give ID
     * @param playerId The ID of a player
     * @return The player with the given ID
     */
    Player getPlayer(int playerId);

    /**
     * Get a List of players with a give teamID
     * @param teamId The ID of the team
     * @return A list of players with the given teamID
     */

    List<Player> getPlayers(int teamId);

    /**
     * Get a list of players in a team with a give Abbreviation
     * @param teamAbbreviation the Abbreviation of a team
     * @return A list of players in the team
     */
    List<Player> getPlayersByTeam(String teamAbbreviation);

    /**
     * Adds a player to the list and returns the players id
     * @param player The player to add
     * @return The ID of the newly added player
     * @throws ServiceException
     */
    int addPlayer(Player player) throws ServiceException;
}
