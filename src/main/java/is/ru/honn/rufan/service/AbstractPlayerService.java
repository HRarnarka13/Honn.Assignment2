package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
public abstract class AbstractPlayerService implements PlayerService {

    private List<Observer> observers = new ArrayList<Observer>();

    public abstract Player getPlayer(int playerId);
    public abstract List<Player> getPlayers(int teamId);
    public abstract List<Player> getPlayersByTeam(String teamAbbreviation);
    public abstract int addPlayer(Player player) throws ServiceException;

    /**
     * Add a new observer to the subscriber list (observers lists)
     * @param observer the new observers
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove a observer from hte subscriber list (observers list)
     * @param observer The observer to be removed
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * This functions goes through all the observers subscribed to this process and sends the
     * the new object (player) to observer by calling their update function.
     * @param object The object to passed to the observers e.g. a single player
     */
    public void notifyObservers(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }
}
