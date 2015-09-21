package is.ru.honn.rufan.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */


public class ReaderFactory {

    private static final String READER_CONTEXT = "reader.xml";

    public static Object getReader(String readerType) {
        ApplicationContext context = new ClassPathXmlApplicationContext(READER_CONTEXT);
        AbstractReader reader = (AbstractReader) context.getBean(readerType);
        return reader;
    }
}
