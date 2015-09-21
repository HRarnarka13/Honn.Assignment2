package is.ru.honn.rufan.reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by arnarkari on 21/09/15.
 *
 * @author arnarkari
 */
public class AbstractReader implements Reader {

    ReadHandler readHandler;
    String URI;

    public Object read() throws ReaderException {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(URI));
            JSONObject jsonObject = (JSONObject) obj;
            return this.parse(jsonObject.toJSONString());
        } catch (ParseException e) {
            throw new ReaderException();
        } catch (FileNotFoundException e) {
            throw new ReaderException();
        } catch (IOException e) {
            throw new ReaderException();
        }
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
