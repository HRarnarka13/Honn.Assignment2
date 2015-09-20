package is.ru.honn.rufan.domain;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class Player {

    private int playerId;
    private String firstName;
    private String lastName;
    private int teamId;

    public Player() {
    }

    public Player(int playerId, String firstName, String lastName, int teamId) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
}
