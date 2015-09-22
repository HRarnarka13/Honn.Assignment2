package is.ru.honn.rufan.observer;

/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
public interface Subject {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Object object);
}
