package is.ru.honn.rufan.process;

import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.ServiceException;
import is.ruframework.process.*;
import org.springframework.context.MessageSource;

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

    public PlayerImportProcess() {
    }

    @Override
    public void setProcessContext(RuProcessContext processContext) {
        super.setProcessContext(processContext);
    }

    @Override
    public void beforeProcess() {
        super.beforeProcess();
    }

    @Override
    public void startProcess() {

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
            service.addPlayer((Player) object);
        } catch (ServiceException e) {
            log.info("Error adding player: " + e.getMessage());
        }
    }
}
