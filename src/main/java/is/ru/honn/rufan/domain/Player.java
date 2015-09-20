package is.ru.honn.rufan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class Player {

    protected int playerId;
    protected String firstName;
    protected String lastName;
    protected int height;
    protected int weight;
    protected Date birthDate;
    protected Country nationality;
    protected int teamId;
    protected List<Position> positions = new ArrayList<Position>();

    public Player() {
    }

    public Player(String firstName, String lastName, int teamId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
    }

    //region Getters and setters

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

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addPosition(Position position) {

    }
    //endregion
}
