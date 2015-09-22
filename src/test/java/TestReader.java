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
 *
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestReader extends TestCase {
    Logger log = Logger.getLogger(TestReader.class.getName());

    @Autowired
    private ReaderFactory readerFactory;

    // region Tests for ReaderFactory
    @Test
    public void ReaderFactory_ReadsXMLFileCorrectly_WithPlayerReader() throws FactoryException {
        // Arrange:
        final String readerType = "playerReader";
        // Act:
        Reader reader = readerFactory.getReader(readerType);
        // Assert:
        assertSame(PlayerReader.class, reader.getClass());
    }

    @Test
    public void ReaderFactory_ReadsXMLFileCorrectly_WithTeamReader() throws FactoryException {
        // Arrange:
        final String readerType = "teamReader";
        // Act:
        Reader reader = readerFactory.getReader(readerType);
        // Assert:
        assertSame(TeamReader.class, reader.getClass());
    }

    @Test(expected = FactoryException.class)
    public void ReaderFactory_ReadsXMLFileCorrectly_WithException() throws FactoryException {
        // Arrange:
        final String readerType = "prumpuReader";
        // Act:
        readerFactory.getReader(readerType);
        // Assert: Expect exception
    }
    // endregion

    // region Test for AbstractReader
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

    @Test
    public void AbstractReader_ReadsFileCorrectly() throws FactoryException {
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
        assertEquals(582, players.size());
    }
    // endregion

}