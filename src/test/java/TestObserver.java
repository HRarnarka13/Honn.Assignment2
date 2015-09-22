import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.process.PlayerImportProcess;
import is.ru.honn.rufan.service.PlayerServiceStub;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestObserver extends TestCase {

    @Test
    public void Test() throws Exception {
        // Arrange :
        PlayerImportProcess playerImportProcess =  new PlayerImportProcess();
        playerImportProcess.setService(new PlayerServiceStub());
        final Player player = new Player("Messi", "Lionel", 1);

        playerImportProcess.addObserver(new Observer() {
            public void update(Object object) {
                assertEquals(player, object);
            }
        });
        // Act :
        playerImportProcess.read(1, player);
    }
}
