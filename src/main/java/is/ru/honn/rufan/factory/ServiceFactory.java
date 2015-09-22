package is.ru.honn.rufan.factory;

import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.TeamService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
public class ServiceFactory {

    private static final String SERVICE_CONTEXT = "service.xml";

    public ServiceFactory() {
    }

    /**
     *
     * @param serviceType
     * @return
     */
    public static PlayerService getPlayerService(String serviceType) throws FactoryException {
        ApplicationContext context = new ClassPathXmlApplicationContext(SERVICE_CONTEXT);
        try {
            return (PlayerService) context.getBean(serviceType);
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException("No such bean found", e);
        }
    }

    /**
     *
     * @param serviceType
     * @return
     */
    public static TeamService getTeamService(String serviceType) throws FactoryException {
        ApplicationContext context = new ClassPathXmlApplicationContext(SERVICE_CONTEXT);
        try {
            return (TeamService) context.getBean(serviceType);
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException("No such bean found", e);
        }
    }
}

