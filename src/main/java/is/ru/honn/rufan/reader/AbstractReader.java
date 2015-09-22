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

    /**
     *
     * @return
     * @throws ReaderException
     */
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

    /**
     * Parse a string to collect the information you need.
     * Implemented in reader classes that extend this class.
     * @param content A string to parse
     * @return An object containing the information wanted.
     */
    public abstract Object parse(String content);

    /**
     * Set the URI of the reader
     * @param URI the given URI
     */
    public void setURI(String URI) {
        this.URI = URI;
    }

    /**
     * Sets the readHandler for the reader
     * @param readHandler
     */
    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }
}
