package is.ru.honn.rufan.domain;

/**
 * A class containing necessary information about a Team
 */
public class Team {

    private int teamId;
    private String location;
    private String abbreviation;
    private String displayName;
    protected Venue venue;

    public Team() {
    }

    public Team(int teamId, String location, String abbreviation, String displayName, Venue venue) {
        this.teamId = teamId;
        this.location = location;
        this.abbreviation = abbreviation;
        this.displayName = displayName;
        this.venue = venue;
    }

    //region Getter setter

    /**
     * Get the teams ID
     * @return The teams ID
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets the team ID
     * @param teamId The teams ID
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Get the teams location
     * @return The teams location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the teams location
     * @param location The teams location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the teams abbreviation
     * @return The teams abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the team abbreviation
     * @param abbreviation The team abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Get the teams display name
     * @return The teams display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the teams display name
     * @param displayName The teams display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the teams venue
     * @return The teams venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Sets the teams venue
     * @param venue The teams venue
     */

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    //endregion
}
