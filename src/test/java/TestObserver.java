import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.observer.Observer;
import is.ru.honn.rufan.process.PlayerImportProcess;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.PlayerServiceStub;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by arnarkari on 22/09/15.
 *
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestObserver extends TestCase {

    @Autowired
    private PlayerService playerService;

    @Test
    public void TestObserver_ObservsersGetNotified() throws Exception {
        final Player player = new Player("Messi", "Lionel", 1);

        Observer observer = new Observer() {
            public void update(Object object) {
                assertEquals(player, object);
            }
        };
        playerService.addObserver(observer);

        // Act :
        playerService.addPlayer(player);
    }
}
