// Andrii Malakhovtsev
// Asset Management

public class Art extends Property {
    private String artistName;
    private int yearCreated;

    public Art(String name, double cost, int yearPurchased, double assessedValue, String artistName, int yearCreated) {
        super(name, cost, yearPurchased, assessedValue);
        this.artistName = artistName;
        this.yearCreated = yearCreated;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArtist: " + artistName + "\nYear Created: " + yearCreated;
    }
}
