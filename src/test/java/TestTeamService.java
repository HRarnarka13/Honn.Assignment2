import is.ru.honn.rufan.domain.*;
import is.ru.honn.rufan.service.ServiceException;
import is.ru.honn.rufan.service.TeamService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.ServerException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
public class TestTeamService extends TestCase {

    Logger log = Logger.getLogger(TestTeamService.class.getName());
    League league;
    Season season;
    Venue venue;

    @Autowired
    private TeamService teamService;

    
    @Before
    public void setup() {
        // Create season
        season = new Season();
        season.setName("Pepsi2016");
        season.setIsActive(true);
        season.setSeason(1);
        // Create venue
        venue = new Venue();
        venue.setVenueId(1);
        venue.setCity("Liverpool");
        venue.setName("Anfield");
        // Create league
        league = new League();
        league.setLeagueId(1);
        league.setName("English Premier League");
        league.setAbbreviation("EPL");
        league.setSeason(season);
        league.setDisplayName("English Premier League");
    }


    @Test
    public void AddTeam_ValidTeam() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "LFC", "Liverpool FC", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);
        // Assert :
        List<Team> t = teamService.getTeams(league.getLeagueId());
        assertTrue(t.contains(team));
    }

    //region Testing required fields
    @Test(expected = ServiceException.class)
    public void AddTeam_TeamNameRequired_TeamNameIsEmpty() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "LFC", "", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);
    }

    @Test(expected = ServiceException.class)
    public void AddTeam_TeamNameRequired_TeamNameIsNull() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "LFC", null, venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);
    }

    @Test(expected = ServiceException.class)
    public void AddTeam_AbbreviationRequired_AbbreviationIsEmpty() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "", "Liverpool FC", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);
    }

    @Test(expected = ServiceException.class)
    public void AddTeam_AbbreviationRequired_AbbreviationIsNull() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", null, "Liverpool FC", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);
    }
    //endregion

    //region Testing getting teams
    @Test
    public void GetValidTeam() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "LFC", "Liverpool FC", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);

        List<Team> teams = teamService.getTeams(league.getLeagueId());
        Team newTeam = teams.get(0);
        // Assert :
        assertSame(newTeam, team);
    }
   // @Test
    public void GetTeam_TeamDoesNotExist() throws ServiceException {
        // Arrange:
        Team team = new Team(1, "Liverpool", "LFC", "Liverpool FC", venue);
        // Act :
        teamService.addTeam(league.getLeagueId(), team);

        List<Team> teams = teamService.getTeams(league.getLeagueId());
        Team invalidTeam = teams.get(1);
        // Assert :
        assertFalse(teams.contains(invalidTeam));
    }
    //endregion

}
