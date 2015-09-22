package is.ru.honn.rufan.factory;

import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.TeamService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arnarkari on 22/09/15.
 * A factory that gets and returns the server provided in the service.xml
 *
 * @author arnarkari
 */
public class ServiceFactory {

    private static final String SERVICE_CONTEXT = "service.xml";

    public ServiceFactory() {
    }

    /**
     * Gets the player service class specified in the service.xml file
     *
     * @param serviceType the service type, example: "playerService"
     * @return an instance of the player service class specified in the service.xml file
     * @throws FactoryException if there is no player service with the specified serviceType string
     */
    public static PlayerService getPlayerService(String serviceType) throws FactoryException {
        ApplicationContext context = new ClassPathXmlApplicationContext(SERVICE_CONTEXT);
        try {
            return (PlayerService) context.getBean(serviceType);
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException();
        }
    }

    /**
     * Gets the team service class specified in the service.xml file
     *
     * @param serviceType the service type, example: "teamService"
     * @return an instance of the team service class specified in the service.xml file
     * @throws FactoryException if ther is no team service with the specified serviceType string
     */
    public static TeamService getTeamService(String serviceType) throws FactoryException {
        ApplicationContext context = new ClassPathXmlApplicationContext(SERVICE_CONTEXT);
        try {
            return (TeamService) context.getBean(serviceType);
        } catch (NoSuchBeanDefinitionException e) {
            throw new FactoryException();
        }
    }
}

