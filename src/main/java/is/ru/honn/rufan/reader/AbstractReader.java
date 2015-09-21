package is.ru.honn.rufan.reader;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public class AbstractReader implements Reader {

    ReadHandler readHandler;
    String URI;

    public Object read() throws ReaderException {
        return new ClientRequest().getRequest(URI);
    }

    public Object parse(String content) {
        return null;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }
}
