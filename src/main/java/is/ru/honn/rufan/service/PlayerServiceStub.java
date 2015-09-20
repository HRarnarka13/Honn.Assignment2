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


    public List<Player> getPlayers(int teamId) {
        return players;
    }

    public List<Player> getPlayersByAbbreviation(String abbreviation) {
        return null;
    }

    public Player getPlayer(int playerId) {
        for (Player player : players) {
            if (player.getPlayerId() == playerId) {
                return player;
            }
        }
        return null; // TODO: throw exception
    }

    public int addPlayer(Player newPlayer) throws ServiceException {

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
