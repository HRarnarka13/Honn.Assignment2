import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.factory.FactoryException;
import is.ru.honn.rufan.factory.ReaderFactory;
import is.ru.honn.rufan.process.PlayerImportProcess;
import is.ru.honn.rufan.reader.PlayerReader;
import is.ru.honn.rufan.reader.Reader;
import is.ru.honn.rufan.reader.ReaderException;
import is.ru.honn.rufan.reader.TeamReader;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by arnarkari on 20/09/15.
 * This class contains unit tests for the Readers
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestReader extends TestCase {
    Logger log = Logger.getLogger(TestReader.class.getName());

    @Autowired
    private ReaderFactory readerFactory;

    // region Tests for ReaderFactory

    /**
     * Assert that the readerFactory returns
     * a reader of the playerReader class when
     * the string used for the GET method is "playerReader"
     */
    @Test
    public void ReaderFactory_ReadsXMLFileCorrectly_WithPlayerReader() {
        // Arrange:
        final String readerType = "playerReader";
        // Act:
        Reader reader = readerFactory.getReader(readerType);
        // Assert:
        assertSame(PlayerReader.class, reader.getClass());
    }

    /**
     * Assert that the readerFactory returns
     * a reader of the teamReader class when
     * the string used for the GET method is "teamReader"
     */
    @Test
    public void ReaderFactory_ReadsXMLFileCorrectly_WithTeamReader() {
        // Arrange:
        final String readerType = "teamReader";
        // Act:
        Reader reader = readerFactory.getReader(readerType);

        // Assert:
        assertSame(TeamReader.class, reader.getClass());
    }

    /**
     * Assert that an exception is thrown
     * when readerType is invalid
     */
    @Test(expected = FactoryException.class)
    public void ReaderFactory_ReadsXMLFileCorrectly_WithException() {
        // Arrange:
        final String readerType = "invalidReader";
        // Act:
        readerFactory.getReader(readerType);
        // Assert: Expect exception
    }
    // endregion

    // region Test for AbstractReader

    /**
     * Assert that an exception is thrown
     * when the URI received by the reader
     * is invalid.
     * @throws Exception
     */
    @Test(expected = ReaderException.class)
     public void AbstractReader_WrongURI() throws Exception {
        // Arrange:
        String readerType = "playerReader";
        Reader reader = readerFactory.getReader(readerType);
        reader.setURI("WRONG_URI");
        // Act:
        reader.read();
        // Assert: Expect exception
    }

    /**
     * Assert that an exception is thrown
     * when the URI received by the reader
     * is null.
     * @throws Exception
     */
    @Test(expected = ReaderException.class)
    public void AbstractReader_URIIsNull() throws Exception {
        // Arrange:
        String readerType = "playerReader";
        Reader reader = readerFactory.getReader(readerType);
        reader.setURI(null);
        // Act:
        reader.read();
        // Assert: Expect exception
    }

    /**
     * Assert that an error is thrown
     * when the handler for the reader is not set
     * @throws Exception
     */
    @Test(expected = ReaderException.class)
    public void AbstractReader_HandlerNotSet() throws Exception {
        // Arrange:
        String readerType = "playerReader";
        Reader reader = readerFactory.getReader(readerType);
        reader.setURI("http://olafurandri.com/honn/players.json");

        // Act:
        reader.read();
        // Assert: Expect exception
    }

    /**
     * Assert that the reader reads the correct
     * amount of players from the given URI
     */
    @Test
    public void AbstractReader_ReadsFileCorrectly() {
        // Arrange:
        String readerType = "playerReader";
        Reader reader = readerFactory.getReader(readerType);
        reader.setURI("http://olafurandri.com/honn/players.json");
        PlayerImportProcess playerImportProcess =  new PlayerImportProcess();
        reader.setReadHandler(playerImportProcess);
        playerImportProcess.setService(new PlayerServiceStub());

        // Act:
        List<Player> players = new ArrayList<Player>();
        try {
            players = (List<Player>) reader.read();
        } catch (ReaderException e) {
            assertTrue(false);
        }

        // Assert:
        // 582 is the correct amount of players from the URI "http://olafurandri.com/honn/players.json"
        assertEquals(582, players.size());
    }
    // endregion

}