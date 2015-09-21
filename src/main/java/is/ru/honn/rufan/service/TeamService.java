package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;

import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public interface TeamService {

    /**
     * Returns the teams in a given league
     *
     * @param leagueId the league id
     * @return list of teams in the league
     */
    int addTeam(int leagueId, Team team) throws ServiceException;

    /**
     * Gets all the teams in the given league
     *
     * @param leagueId the id of the league
     * @return a list of teams in the league
     */
    List<Team> getTeams(int leagueId);
}
