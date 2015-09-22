package is.ru.honn.rufan.reader;

import javax.ws.rs.ProcessingException;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public abstract class AbstractReader implements Reader {

    ReadHandler readHandler;
    String URI;

    public Object read() throws ReaderException {
        if (readHandler == null) {
            throw new ReaderException();
        }

        try {
            String content = new ClientRequest().getRequest(URI);
            return parse(content);
        } catch (ProcessingException e) {
            throw new ReaderException();
        }
    }

    public abstract Object parse(String content);

    public void setURI(String URI) {
        this.URI = URI;
    }

    /**
     * Sets the readHandler for the reader
     * e.g.  playerReader or teamReader
     * @param readHandler
     */
    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }
}
