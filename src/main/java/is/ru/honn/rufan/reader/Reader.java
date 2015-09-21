package is.ru.honn.rufan.reader;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public interface Reader {
    public Object read() throws ReaderException;
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
