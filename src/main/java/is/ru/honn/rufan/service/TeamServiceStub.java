package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Season;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class TeamServiceStub implements TeamService {

    private List<League> leagues = new ArrayList<League>();

    private League getLeague(int leagueId) {
        for (League league : leagues) {
            if (league.getLeagueId() == leagueId) {
                return league;
            }
        }
        return null; // TODO : throw not found error
    }

    private League createLeague(int leagueId) {
        Season season = new Season();
        season.setIsActive(false);
        season.setName("Temp");
        season.setSeason(1);

        League league = new League();
        league.setLeagueId(leagueId);
        league.setDisplayName("Temp");
        league.setAbbreviation("T");
        league.setName("Temp");
        league.setSeason(season);
        leagues.add(league);
        return league;
    }


    public int addTeam(int leagueId, Team team) throws ServiceException {
        // Validate team
        if (team.getTeamId() == 0 ||
                team.getAbbreviation() == null ||
                team.getAbbreviation().isEmpty() ||
                team.getDisplayName() == null ||
                team.getDisplayName().isEmpty()) {
            throw new ServiceException();
        }

        League league = getLeague(leagueId);
        if (league == null) {
            league = createLeague(leagueId);
        }
        Season season = league.getSeason();
        season.addTeam(team);
        return season.getTeams().size();
    }


    /**
     * Returns the teams in a given league
     *
     * @param leagueId the league id
     * @return list of teams in the league
     */
    public List<Team> getTeams(int leagueId) {
        League league = getLeague(leagueId); // Get the league
        Season season = league.getSeason(); // Get the season
        return season.getTeams(); // Return teams
    }
}
