package is.ru.honn.rufan.reader;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public interface Reader {
    /**
     * Read the file (provided URI) and calls parse that parses the content of the file
     *
     * @return The objects that the parse() function returns
     * @throws ReaderException if the readerHandler is not set or if there is a exception processing the request for
     * the file
     */
    public Object read() throws ReaderException;

    /**
     * Parse a string to collect the information you need.
     * Implemented in reader classes that extend this class.
     * @param content A string to parse
     * @return An object containing the information wanted.
     */
    public Object parse(String content);

    /**
     * Set the URI of the reader
     * @param URI the given URI
     */
    public void setURI(String URI);

    /**
     * Sets the readHandler for the reader
     * @param readHandler
     */
    public void setReadHandler(ReadHandler readHandler);
}
