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
     * Parse a string to collect the information you need.
     * Implemented in reader classes that extend AbstractReader.
     * @param content
     * @return
     */
    public Object parse(String content);

    /**
     * Set the URI of the reader
     * @param URI
     */
    public void setURI(String URI);

    /**
     * Sets the readHandler for the reader
     * @param readHandler
     */
    public void setReadHandler(ReadHandler readHandler);
}
