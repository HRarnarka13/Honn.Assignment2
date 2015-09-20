import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.service.PlayerService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestPlayerService extends TestCase {
    Logger log = Logger.getLogger(TestPlayerService.class.getName());

    @Autowired
    private PlayerService service;

    @Before
    public void setup() {

    }

    @Test
    public void testPlayer(){
        Player player1 = new Player();
        Player player2 = new Player();

        service.addPlayer(player1);
        service.addPlayer(player2);

        Player playerNew = service.Getplayer(1);
        assertSame(player1, playerNew);
    }

}