package is.ru.honn.rufan.service;

import is.ru.honn.rufan.domain.Team;

import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public interface TeamService {

    int addTeam(int leagueId, Team team) throws ServiceException;
    List<Team> getTeams(int leagueId);
}
