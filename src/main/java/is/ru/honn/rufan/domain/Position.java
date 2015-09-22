package is.ru.honn.rufan.domain;

/**
 * Created by arnarkari on 20/09/15.
 * A class containing necessary information about a position
 * @author arnarkari
 */
public class Position {

    private int positionId;
    private String name;
    private String abbreviation;
    private int sequence;

    public Position() {
    }

    public Position(int positionId, String name, String abbreviation, int sequence) {
        this.positionId = positionId;
        this.name = name;
        this.abbreviation = abbreviation;
        this.sequence = sequence;
    }

    /**
     * Gets the ID of the position
     * @return The id of the position
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Sets the positions ID
     * @param positionId The positions ID
     */

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Get the name of the position
     * @return The name of the position
     */

    public String getName() {
        return name;
    }

    /**
     * Set the name of the position
     * @param name The name of the position
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the abbreviation of the position
     * @return The abbreviation of the position
     */

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the abbreviation of the position
     * @param abbreviation The abbreviation of the position
     */

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Get the sequence of the position
     * @return The sequence of the position
     */

    public int getSequence() {
        return sequence;
    }

    /**
     * Sets the sequence of the position
     * @param sequence The sequence of the position
     */

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
