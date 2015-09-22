package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.factory.ObserverFactory;
import is.ru.honn.rufan.factory.ReaderFactory;
import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.reader.ReaderException;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import is.ru.honn.rufan.service.ServiceException;
import is.ruframework.process.*;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {

    Logger log = Logger.getLogger(PlayerImportProcess.class.getName());

    private MessageSource messageSource;
    private PlayerService service;
    private Reader reader;
    private List<Observer> observers;

    public PlayerImportProcess() {
    }

    @Override
    public void setProcessContext(RuProcessContext processContext) {
        super.setProcessContext(processContext);
    }

    @Override
    public void beforeProcess() {
        super.beforeProcess();
        service = new PlayerServiceStub();

        ReaderFactory readerFactory = new ReaderFactory();
        reader = (Reader) readerFactory.getReader("playerReader");
        reader.setReadHandler(this);
        reader.setURI(getProcessContext().getImportURL());

        observers = new ArrayList<Observer>();
        ObserverFactory observerFactory = new ObserverFactory();
        Observer observer = (Observer) observerFactory.getObserver("playerObserver");
        observers.add(observer);
    }

    @Override
    public void startProcess() {
        try {
            String content = (String) reader.read();
            reader.parse(content);
        } catch (ReaderException e) {
            log.info("Error reading: " + e.getMessage());
        }
    }

    @Override
    public void afterProcess() {
        super.afterProcess();
    }

    /**
     * Gets the content from the file and calls parse()
     *
     * @param count
     * @param object
     */
    public void read(int count, Object object) {
        try {
            Player newPlayer = (Player) object;
            service.addPlayer(newPlayer);
            notifyObservers(newPlayer);
        } catch (ServiceException e) {
            log.info("Error adding player: " + e.getMessage());
        }
    }

    private void notifyObservers(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }

}
