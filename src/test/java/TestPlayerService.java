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
    @Test
    public void AddPlayer_FirstNameRequired_FirstNameEmpty() {

        // Arrange:
        Player player = new Player("", "Milner", team.getTeamId());

        // Act:
        try {
            playerService.addPlayer(player);
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
            playerService.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
     public void AddPlayer_LastNameRequired_LastNameIsEmpty() {

        // Arrange:
        Player player = new Player("James", "", team.getTeamId());

        // Act:
        try {
            playerService.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void AddPlayer_LastNameRequired_LastNameIsNull() {

        // Arrange:
        Player player = new Player("James", null, team.getTeamId());

        // Act:
        try {
            playerService.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void AddPlayer_TeamIdRequired() {

        // Arrange:
        Player player = new Player("James", "Milner", 0);

        // Act:
        try {
            playerService.addPlayer(player);
        } catch (IllegalArgumentException e) {
            // Assert:
            assertSame(IllegalArgumentException.class, e.getClass());
        }
    }
    //endregion

    // region Test add player that is ok
    @Test
    public void AddPlayer_AddingValidPlayer(){

        // Arrange:
        Player player1 = new Player("James", "Milner", team.getTeamId());
        Player player2 = new Player("Danny", "Ings", team.getTeamId());

        // Act :
        playerService.addPlayer(player1);
        playerService.addPlayer(player2);

        // Assert:
        assertSame("Player1", player1, playerService.Getplayer(1));
        assertSame("Player2", player2, playerService.Getplayer(2));
    }
    // endregion

    // region Test get player that dose not exist
    @Test
    public void GetPlayer_GetNonExistingPlayer() throws Exception {

        // Arrange :
        int nonExistingPlayerId = 999;
        // Act :
        Player player = playerService.Getplayer(nonExistingPlayerId);
        // Assert :
        assertNull(player);
    }
    // endregion
}