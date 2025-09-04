
package tvseriesdetailstracking;


/**
 * Stores details of a TV Series.
 */
public class SeriesModel {
    private String id;
    private String name;
    private int ageRestriction;
    private int numEpisodes;

    public SeriesModel(String id, String name, int ageRestriction, int numEpisodes) {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.numEpisodes = numEpisodes;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(int numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    @Override
    public String toString() {
        return String.format(
            "Series ID: %s%nSeries Name: %s%nAge Restriction: %d%nNumber of Episodes: %d",
            id, name, ageRestriction, numEpisodes
        );
    }
}
