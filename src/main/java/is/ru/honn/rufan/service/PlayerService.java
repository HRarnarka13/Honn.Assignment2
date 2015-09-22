package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;

import javax.security.auth.Subject;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public interface PlayerService extends is.ru.honn.rufan.observer.Subject {

    Player getPlayer(int playerId);

    List<Player> getPlayers(int teamId);

    List<Player> getPlayersByTeam(String teamAbbreviation);

    int addPlayer(Player player) throws ServiceException;


}
