package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.League;
import is.ru.honn.rufan.domain.Season;
import is.ru.honn.rufan.domain.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 * This class implements the functionality for
 * the TeamService interface.
 * @author arnarkari
 */
public class TeamServiceStub implements TeamService {

    private List<League> leagues = new ArrayList<League>();
    private List<Team> teams = new ArrayList<Team>();

    // region override methods
    /**
     * Adds a team to a given league
     *
     * @param leagueId the league id
     * @param team The team to be added
     * @return The index of the newly added team in a list of teams
     * @throws ServiceException if the team has a invalid property
     */
    public int addTeam(int leagueId, Team team) throws ServiceException {
        // Validate team
        if (team.getTeamId() == 0 ||
                team.getAbbreviation() == null ||
                team.getAbbreviation().isEmpty() ||
                team.getDisplayName() == null ||
                team.getDisplayName().isEmpty()) {
            throw new ServiceException();
        }

        // Check if the team exists
        for (Team t : teams) {
            if (t.getTeamId() != team.getTeamId() && t.getAbbreviation() != team.getAbbreviation()) {
                teams.add(t);
            }
        }


        // if the League does not exist we create a new league
        League league = getLeague(leagueId);
        if (league == null) {
            league = createLeague(leagueId);
        }

        // Check if the team is already in the league
        for (Team t : league.getSeason().getTeams()) {
            if (t.getTeamId() == team.getTeamId() || t.getAbbreviation() == team.getAbbreviation()) {
                throw new ServiceException();
            }
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

    // endregion

    // region helper functions

    /**
     * A helper function to get a League with a
     * give leagueID
     * @param leagueId The ID of the league
     * @return League or null if no league found.
     */
    private League getLeague(int leagueId) {
        for (League league : leagues) {
            if (league.getLeagueId() == leagueId) {
                return league;
            }
        }
        return null;
    }

    /**
     * A helper function that makes a new League
     * with temporary variable values.
     * @param leagueId The ID of the league
     * @return the new league
     */
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

    /**
     * Get team by the abbreviation
     *
     * @param teamAbbreviation the abbreviation for the team
     * @return a single team
     */
    public Team getTeamByAbbreviation(String teamAbbreviation) {
        for(Team team : teams) {
            if (team.getAbbreviation() == teamAbbreviation) {
                return team;
            }
        }
        return null;
    }

    // endregion
}
