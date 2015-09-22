package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.factory.FactoryException;
import is.ru.honn.rufan.factory.ObserverFactory;
import is.ru.honn.rufan.factory.ReaderFactory;
import is.ru.honn.rufan.factory.ServiceFactory;
import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.reader.ReaderException;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import is.ru.honn.rufan.service.ServiceException;
import is.ruframework.process.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {

    Logger log = Logger.getLogger(PlayerImportProcess.class.getName());

    private PlayerService service;
    private Reader reader;
    private List<Observer> observers = new ArrayList<Observer>();
    private MessageSource messageSource;
    private Locale locale;

    public PlayerImportProcess() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:message.xml");
        messageSource = (MessageSource) ctx.getBean("messageSource");
        String languageTag = (String) ctx.getBean("islLocal");
        this.locale = Locale.forLanguageTag(languageTag);
    }

    @Override
    public void beforeProcess() {
        super.beforeProcess();
        log.info(messageSource.getMessage("processbefore", new Object[]{ this.getClass().getName() }, this.locale));

        ServiceFactory serviceFactory = new ServiceFactory();

        try {
            setService(serviceFactory.getPlayerService("playerService"));
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerserviceexception", new Object[]{ e.getClass().getName() }, this.locale));
        }

        ReaderFactory readerFactory = new ReaderFactory();

        try {
            reader = readerFactory.getReader("playerReader");
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerreaderexception", new Object[]{ e.getClass().getName() }, this.locale));
        }
        reader.setReadHandler(this);
        reader.setURI(getProcessContext().getImportURL());

        ObserverFactory observerFactory = new ObserverFactory();
        Observer observer = null;
        try {
            observer = (Observer) observerFactory.getObserver("playerObserver");
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerobserverexception", new Object[]{ e.getClass().getName() }, this.locale));
        }
        addObserver(observer);
    }

    @Override
    public void startProcess() {
        log.info(messageSource.getMessage("processstart", new Object[]{this.getClass().getName()}, this.locale));
        try {
            reader.read();
        } catch (ReaderException e) {
            log.info(messageSource.getMessage("processreaderror", new Object[]{getProcessContext().getImportURL()}, this.locale));
        }
    }

    @Override
    public void afterProcess() {
        super.afterProcess();
        log.info(messageSource.getMessage("processstartdone", new Object[]{ this.getClass().getName() }, this.locale));
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
            log.info(messageSource.getMessage("addingplayererror", new Object[]{ e.getClass().getName() }, this.locale));
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }

    public void setService(PlayerService playerService) {
        this.service = playerService;
    }

}
