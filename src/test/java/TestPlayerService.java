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

    //region Test add player required properties
    @Test
    public void AddPlayer_FirstNameRequired_FirstNameEmpty() {

        // Arrange:
        Player player = new Player("", "Milner", team.getTeamId());

        // Act:
        try {
            service.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }
    @Test
    public void AddPlayer_FirstNameRequired_FirstNameIsNULL() {

        // Arrange:
        Player player = new Player(null, "Milner", team.getTeamId());

        // Act:
        try {
            service.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void AddPlayer_LastNameRequired() {

        // Arrange:
        Player player = new Player("James", "", team.getTeamId());

        // Act:
        try {
            service.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void AddPlayer_TeamIdRequired() {

        // Arrange:
        Player player = new Player("James", "Milner", null);

        // Act:
        try {
            service.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }
    //endregion
}