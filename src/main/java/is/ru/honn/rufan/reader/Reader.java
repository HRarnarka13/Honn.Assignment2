package is.ru.honn.rufan.reader;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public interface Reader {
    /**
     *
     * @return
     * @throws ReaderException
     */
    public Object read() throws ReaderException;

    /**
     *
     * @param content
     * @return
     */
    public Object parse(String content);

    /**
     *
     * @param URI
     */
    public void setURI(String URI);

    /**
     *
     * @param readHandler
     */
    public void setReadHandler(ReadHandler readHandler);
}
