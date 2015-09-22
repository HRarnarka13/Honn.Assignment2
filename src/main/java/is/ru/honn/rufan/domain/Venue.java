package is.ru.honn.rufan.domain;


public class Venue {
    private int venueId;
    private String name;
    private String city;

    /**
     * Get the venues ID
     * @return The ID of the venue
     */
    public int getVenueId() {
        return venueId;
    }

    /**
     * Set the venues ID
     * @param venueId The ID of the venue
     */
    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    /**
     * Get the name of the venue
     * @return The name of the venue
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the venue
     * @param name The name of the venue
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the city where the venue is located
     * @return The city where the venue is located
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city where the venue is located
     * @param city The city where the venue is located
     */
    public void setCity(String city) {
        this.city = city;
    }
}
