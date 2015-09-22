package is.ru.honn.rufan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arnarkari on 20/09/15.
 * A class containing necessary information about a Player
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
    
    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                ", nationality=" + nationality +
                ", teamId=" + teamId +
                ", positions=" + positions +
                '}';
    }

    //region Getters and setters

    /**
     * Gets the first name of the player
     * @return The first name of the players
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the player
     * @param firstName The first name of the players
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the player
     * @return The last name of the player
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name for the player
     * @param lastName The last name for the player
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the ID of the team the player is in
     * @return The players teamID
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets the players teamID
     * @param teamId The players teamID
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Sets the players ID
     * @param playerId The players ID
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Get the player ID
     * @return The players ID
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets the nationality of the player
     * @param nationality The nationality of the player
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the nationality of the player
     * @return The nationality of the player
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets the height of the player
     * @param height The height of the player
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets the weight of the Player
     * @param weight The weight of the player
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Sets the players birtdate
     * @param birthDate The players birthdate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void addPosition(Position position) {
        this.positions.add(position);
    }
    //endregion
}
