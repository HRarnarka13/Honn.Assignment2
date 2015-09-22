package is.ru.honn.rufan.service;

/**
 * Created by arnarkari on 20/09/15.
 * An exception class that is thrown by the service classes in the project.
 * @author arnarkari
 */
public class ServiceException extends Exception {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
