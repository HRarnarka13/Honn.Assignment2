package is.ru.honn.rufan.observer;


import is.ru.honn.rufan.domain.Player;

import java.util.logging.Logger;

/**
 * Created by arnarkari on 22/09/15.
 * A observer class for players that is subscribed to the PlayerImportProcess
 *
 * @author arnarkari
 */
public class PlayerObserver implements Observer {

    Logger log = Logger.getLogger(PlayerObserver.class.getName());

    /**
     * This function is called from the observable that this class is subscribed to when the observable notifies all
     * this observers. The functions logs out the object sent from the observable, a.k.a the new player.
     *
     * @param object the new object sent from the observable a.k.a the new player
     */
    public void update(Object object) {
        Player player = (Player) object;
        log.info(player.toString());
    }
}
