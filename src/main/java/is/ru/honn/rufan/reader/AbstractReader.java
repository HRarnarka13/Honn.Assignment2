package is.ru.honn.rufan.reader;

import javax.ws.rs.ProcessingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by arnarkari on 21/09/15.
 * A abstract reader class that implements the reader interface and all reader classes extend.
 *
 * @author arnarkari
 */
public abstract class AbstractReader implements Reader {

    ReadHandler readHandler;
    String URI;

    /**
     * Read the file (provided URI) and calls parse that parses the content of the file
     *
     * @return The objects that the parse() function returns
     * @throws ReaderException if the readerHandler is not set or if there is a exception processing the request for
     * the file
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


    /**
     * Format a date for correct display.
     * Format example 2015-08-21T16:19:30.6967613Z
     * @param strDate
     * @return The date correctly formatted.
     */
    public Date convertDate(String strDate) {
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm:ss", Locale.ENGLISH);
        Date date = null;

        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            System.out.println("FAIL");
        }
        return date;
    }

}
