package is.ru.honn.rufan.domain;

/**
 * Created by arnarkari on 20/09/15.
 * A class containing necessary information about a Country
 * @author arnarkari
 */
public class Country {
    private int countryId;
    private String name;
    private String Abbreviation;

    public Country() {
    }

    //region Getters and setters

    /**
     * Sets the id for a country
     * @param countryId The id of the country
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", Abbreviation='" + Abbreviation + '\'' +
                '}';
    }

    /**
     * Gets the id of the country
     * @return The ID of the country
     */

    public int getCountryId() {
        return countryId;
    }

    /**
     * Gets the name of the country
     * @return The name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a country
     * @param name The name of the country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the abbreviation of a country
     * @return The abbreviation of a country
     */
    public String getAbbreviation() {
        return Abbreviation;
    }

    /**
     * Sets the abbreviatoin of a country
     * @param abbreviation The abbreviation of the country
     */
    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }
    //endregion
}
