package is.ru.honn.rufan.factory;

import is.ru.honn.rufan.observer.Observer;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by arnarkari on 22/09/15.
 * A factory that gets and returns the observer provided in the observer.xml file
 *
 * @author arnarkari
 */
public class ObserverFactory {

    private static final String OBSERVER_CONTEXT = "observer.xml";

    /**
     * Gets the observer specified in hte observer.xml file
     * @param observerType the observer type, example: "playerObserver"
     * @return an instance of a observer
     * @throws FactoryException if there is no observer with the specified observerType in the file observer.xml
     */
    public static Observer getObserver(String observerType) throws FactoryException {
        ApplicationContext context = new ClassPathXmlApplicationContext(OBSERVER_CONTEXT);
        try {
            return (Observer) context.getBean(observerType);
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException();
        }
    }
}
