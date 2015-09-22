package is.ru.honn.rufan.domain;


import java.util.ArrayList;

public class Season {
    private int season;
    private String name;
    private boolean isActive;
    private ArrayList<Team> teams = new ArrayList<Team>();

    /**
     * Get the season number
     * @return The number of the season
     */
    public int getSeason() {
        return season;
    }

    /**
     * Set the season number
     * @param season The season number
     */

    public void setSeason(int season) {
        this.season = season;
    }

    /**
     * Get the name of the season
     * @return The name of the season
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the season
     * @param name The name of the seasson
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the season is active
     * @return If season is active or inactive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Makes the season active or inactive
     * @param isActive True or false. Active or Inactive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Get all teams in the season
     * @return A list of teams in the season
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Adds a team to this season
     * @param team The team to add
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

}
