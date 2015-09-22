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
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }

    //endregion
}
