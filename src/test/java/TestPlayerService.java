import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.domain.Venue;
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
    Venue venue;
    Team team;

    @Autowired
    private PlayerService service;

    @Before
    public void setup() {

        // Create venue
        venue = new Venue();
        venue.setVenueId(1);
        venue.setName("Anfield");
        venue.setCity("Liverpool");

        // Create team
        team = new Team();
        team.setTeamId(1);
        team.setDisplayName("Liverpool");
        team.setVenue(venue);
    }

    @Test
    public void AddPlayer_FirstNameRequired() {

        // Arrange:
        Player player1 = new Player("", "Milner", team.getTeamId());

        // Act:
        service.addPlayer(player1);

        // Assert:
        Player playerNew = service.Getplayer(1);
        assertSame(player1, playerNew);
    }

}