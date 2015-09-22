package is.ru.honn.rufan.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */
public class ClientRequest {
    public ClientRequest() {}
    /**
     * Builds a string from information from an online source
     * @param url link to website containing text
     * @return the content of the URL as a string
     */
    public String getRequest(String url) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request().get();

        String result = response.readEntity(String.class);
        client.close();

        return result;
    }

    /**
     * Reads the content of a file into a string object
     * @param fileName the name of the file to read
     * @return A string object
     * @throws ReaderException
     */
    public String getFileContent(String fileName) throws ReaderException {
        StringBuilder content = new StringBuilder();
        try {
            java.io.FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            String msg = "Unable to open file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        } catch (IOException ex) {
            String msg = "Error reading file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        return content.toString();
    }

}
