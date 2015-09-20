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

    public Player Getplayer(int i) {
        for (Player player : players) {
            if (player.getPlayerId() == i) {
                return player;
            }
        }
        return null; // TODO: throw exception
    }

    public int addPlayer(Player newPlayer) throws IllegalArgumentException {

        if (newPlayer.getFirstName() == null ||
                newPlayer.getFirstName().equals("") ||
                newPlayer.getLastName() == null ||
                newPlayer.getLastName().equals("")) {
            throw new IllegalArgumentException();
        }

        newPlayer.setPlayerId(players.size());
        players.add(newPlayer);
        return players.size() - 1;
    }
}
