package is.ru.honn.rufan.process;

import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.reader.Reader;
import is.ruframework.process.*;
import org.springframework.context.MessageSource;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {

    private MessageSource messageSource;


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
        String fileContent = (String) object;


    }
}
