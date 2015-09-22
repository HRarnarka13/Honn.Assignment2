package is.ru.honn.rufan.factory;

import is.ru.honn.rufan.reader.AbstractReader;
import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.reader.ReaderException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */


public class ReaderFactory {

    private static final String READER_CONTEXT = "reader.xml";

    public ReaderFactory() {
    }

    public static Reader getReader(String readerType) {
        ApplicationContext context = new ClassPathXmlApplicationContext(READER_CONTEXT);
        try {
            Reader reader = (Reader) context.getBean(readerType);
            return reader;
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException("No such bean found", e);
        }
    }
}
