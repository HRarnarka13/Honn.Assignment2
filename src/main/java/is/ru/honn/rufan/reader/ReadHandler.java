package is.ru.honn.rufan.reader;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public interface ReadHandler {
    /**
     *
     * @param count The current number of objects read.
     * @param object An object to be read.
     */
    public void read(int count, Object object);
}
