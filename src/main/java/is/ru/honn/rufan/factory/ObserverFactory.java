package is.ru.honn.rufan.factory;

import is.ru.honn.rufan.observer.Observer;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
public class ObserverFactory {

    private static final String OBSERVER_CONTEXT = "observer.xml";

    /**
     *
     * @param observerType
     * @return
     */
    public static Object getObserver(String observerType) {
        ApplicationContext context = new ClassPathXmlApplicationContext(OBSERVER_CONTEXT);
        try {
            Observer observer = (Observer) context.getBean(observerType);
            return observer;
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException("No such bean found", e);
        }
    }
}
