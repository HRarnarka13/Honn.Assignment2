import is.ru.honn.rufan.domain.Season;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.domain.Venue;
import is.ru.honn.rufan.service.TeamService;
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
public class TestTeamService {

    Logger log = Logger.getLogger(TestTeamService.class.getName());

    @Autowired
    private TeamService teamService;
    Season season;
    Venue venue;

    
    @Before
    public void setup() {
        // Create season
        season = new Season();
        season.setName("Pepsi2016");
        season.setIsActive(true);
        season.setSeason(1);
        // Create venue
        venue = new Venue();
        venue.setCity("Liverpool");
        venue.setName("Anfield");
        venue.setVenueId(1);
    }


    @Test
    public void AddTeam_TeamIdRequired() throws Exception {
        Team team = new Team(0, "Liverpool", "LFC", "Liverpool FC", venue);

    }
}
