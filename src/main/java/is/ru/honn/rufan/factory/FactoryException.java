package is.ru.honn.rufan.factory;

/**
 * Created by arnarkari on 22/09/15.
 * Exception class for factories if a error occurs in a factory a factory exception is thrown
 *
 * @author arnarkari
 */
public class FactoryException extends Exception {

    public FactoryException() {
        super();
    }

    public FactoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
