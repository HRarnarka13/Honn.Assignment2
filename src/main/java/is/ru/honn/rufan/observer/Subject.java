package is.ru.honn.rufan.observer;

import java.util.Observer;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
