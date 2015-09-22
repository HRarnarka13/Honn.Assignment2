package is.ru.honn.rufan.domain;

/**
 * A class containing necessary information about a League
 */
public class League
{
  private int leagueId;
  private String name;
  private String abbreviation;
  private String displayName;
  protected Season season;

    /**
     * Gets the ID of the league
     * @return The ID of the league
     */
    public int getLeagueId()
    {
    return leagueId;
    }

    /**
     * Sets the ID for a leauge
     * @param leagueId The ID of the league
     */

    public void setLeagueId(int leagueId)
    {
    this.leagueId = leagueId;
    }

    /**
     * Gets the name of the league
     * @return The name of the league
     */

    public String getName()
    {
    return name;
    }

    /**
     * Sets the name of the league
     * @param name The name of the league
     */
    public void setName(String name)
    {
    this.name = name;
    }

    /**
     * Gets the abbreviation of the league
     * @return The abbreviation of the league
     */

    public String getAbbreviation()
    {
    return abbreviation;
    }

    /**
     * Sets the abbreviation of the league
     * @param abbreviation The abbreviation of the league
     */

    public void setAbbreviation(String abbreviation)
    {
    this.abbreviation = abbreviation;
    }

    /**
     * Get the display name for the league
     * @return The display name for the league
     */

    public String getDisplayName()
    {
    return displayName;
    }

    /**
     * Sets the display name for the league
     * @param displayName The display name of the league
     */

    public void setDisplayName(String displayName)
    {
    this.displayName = displayName;
    }

    /**
     * Gets the season of the league
     * @return the season of the league
     */

    public Season getSeason()
    {
    return season;
    }

    /**
     * Sets the season of the league
     * @param season The season of the league
     */

    public void setSeason(Season season)
    {
    this.season = season;
    }
}
