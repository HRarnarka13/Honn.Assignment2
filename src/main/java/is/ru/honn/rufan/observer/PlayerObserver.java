package is.ru.honn.rufan.observer;


import is.ru.honn.rufan.domain.Player;

import java.util.logging.Logger;

/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
public class PlayerObserver implements Observer {

    Logger log = Logger.getLogger(PlayerObserver.class.getName());

    /**
     * Print the received 
     * @param arg A player object
     */
    public void update(Object arg) {
        Player player = (Player) arg;
        log.info(player.toString());
    }
}
