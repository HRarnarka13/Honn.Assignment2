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
import is.ruframework.process.RuAbstractProcess;
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
 * This class controls the process when the players are read from the file provided in the process.xml file
 * and send to the service provided in the service.xml file and notifies all the observers that are subscribed
 * to the process.
 *
 * @author arnarkari
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {

    Logger log = Logger.getLogger(PlayerImportProcess.class.getName());

    private PlayerService service;
    private Reader reader;
    private MessageSource messageSource;
    private Locale locale;


    /**
     * The constructor
     */
    public PlayerImportProcess() {
        // region Get the local settings
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:message.xml");
        messageSource = (MessageSource) ctx.getBean("messageSource");
        String languageTag = (String) ctx.getBean("islLocal");
        this.locale = Locale.forLanguageTag(languageTag);
        // endregion
    }

    /**
     * This function is called before the process starts
     */
    @Override
    public void beforeProcess() {
        super.beforeProcess();
        log.info(messageSource.getMessage("processbefore", new Object[]{this.getClass().getName()}, this.locale));

        // region Get the Service
        ServiceFactory serviceFactory = new ServiceFactory();

        try {
            setService(serviceFactory.getPlayerService("playerService"));
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerserviceexception", new Object[]{ e.getClass().getName() }, this.locale));
        }
        // endregion

        // region Get the reader
        ReaderFactory readerFactory = new ReaderFactory();

        try {
            reader = readerFactory.getReader("playerReader");
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerreaderexception", new Object[]{e.getClass().getName()}, this.locale));
        }
        // endregion

        reader.setReadHandler(this);
        reader.setURI(getProcessContext().getImportURL());

        // region Get the observer
        ObserverFactory observerFactory = new ObserverFactory();
        Observer observer = null;
        try {
            observer = (Observer) observerFactory.getObserver("playerObserver");
        } catch (FactoryException e) {
            log.info(messageSource.getMessage("playerobserverexception", new Object[]{ e.getClass().getName() }, this.locale));
        }
        // endregion

        service.addObserver(observer);
    }


    /**
     * This function is called when the process starts.
     */
    @Override
    public void startProcess() {
        log.info(messageSource.getMessage("processstart", new Object[]{this.getClass().getName()}, this.locale));
        try {
            reader.read(); // Start reading and parsing the file
        } catch (ReaderException e) {
            log.info(messageSource.getMessage("processreaderror", new Object[]{getProcessContext().getImportURL()}, this.locale));
        }
    }

    /**
     * This function is called after the process
     */
    @Override
    public void afterProcess() {
        super.afterProcess();
        log.info(messageSource.getMessage("processstartdone", new Object[]{this.getClass().getName()}, this.locale));
    }

    /**
     * This function is called from the provided reader in the reader.xml inside the parse() function after
     * reading one block (player).
     *
     * @param count The number of the block (player)
     * @param object The object that the reader gets from the file, e.g. a single player
     */
    public void read(int count, Object object) {
        try {
            Player newPlayer = (Player) object;
            service.addPlayer(newPlayer); // add the player to the service
        } catch (ServiceException e) {
            log.info(messageSource.getMessage("addingplayererror", new Object[]{ e.getClass().getName() }, this.locale));
        }
    }

    /**
     * Set the service used by this class
     * @param playerService a type of PlayerService
     */
    public void setService(PlayerService playerService) {
        this.service = playerService;
    }

}
