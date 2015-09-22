package is.ru.honn.rufan.observer;

/**
 * Created by arnarkari on 22/09/15.
 * An interface that observers classes implements
 *
 * @author arnarkari
 */
public interface Observer {
    /**
     * This function is called from the observable that the observer is subscribed to, when the observable
     * is notifying all this observers about a change
     *
     * @param object the new object sent from the observable
     */
    public void update(Object object);
}
