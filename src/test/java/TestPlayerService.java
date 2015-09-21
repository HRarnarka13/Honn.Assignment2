import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.domain.Venue;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.ServiceException;
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
 * nu er gaman
 * @author arnarkari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestPlayerService extends TestCase {

    Logger log = Logger.getLogger(TestPlayerService.class.getName());
    Venue venue;
    Team team;

    @Autowired
    private PlayerService playerService;

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
    @Test(expected = ServiceException.class)
    public void AddPlayer_FirstNameRequired_FirstNameEmpty() throws ServiceException {
        // Arrange:
        Player player = new Player("", "Milner", team.getTeamId());
        // Act:
        playerService.addPlayer(player);
    }

    @Test(expected = ServiceException.class)
    public void AddPlayer_FirstNameRequired_FirstNameIsNULL() throws ServiceException {

        // Arrange:
        Player player = new Player(null, "Milner", team.getTeamId());

        // Act:
        playerService.addPlayer(player);
    }

    @Test(expected = ServiceException.class)
    public void AddPlayer_LastNameRequired_LastNameIsEmpty() throws ServiceException {
        // Arrange:
        Player player = new Player("James", "", team.getTeamId());
        // Act:
        playerService.addPlayer(player);
    }

    @Test(expected = ServiceException.class)
    public void AddPlayer_LastNameRequired_LastNameIsNull() throws ServiceException {
        // Arrange:
        Player player = new Player("James", null, team.getTeamId());
        // Act:
        playerService.addPlayer(player);
    }

    @Test(expected = ServiceException.class)
    public void AddPlayer_TeamIdRequired() throws ServiceException {
        // Arrange:
        Player player = new Player("James", "Milner", 0);
        // Act:
        playerService.addPlayer(player);
    }
    //endregion

    // region Test add player that is ok
    public void AddPlayer_AddingValidPlayer() throws ServiceException {
        // Arrange:
        Player player1 = new Player("James", "Milner", team.getTeamId());
        Player player2 = new Player("Danny", "Ings", team.getTeamId());
        // Act :
        playerService.addPlayer(player1);
        playerService.addPlayer(player2);
        // Assert:
        assertSame("Player1", player1, playerService.getPlayer(1));
        assertSame("Player2", player2, playerService.getPlayer(2));
    }
    //comment
    // endregion

    // region Test get player that dose not exist
    public void GetPlayer_GetNonExistingPlayer() {
        // Arrange :
        int nonExistingPlayerId = 999;
        // Act :
        Player player = playerService.getPlayer(nonExistingPlayerId);
        // Assert :
        assertNull(player);
    }
    // endregion
}
