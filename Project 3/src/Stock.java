// Andrii Malakhovtsev
// Asset Management

public class Stock extends Asset {
    private String tickerSymbol;
    private int sharesOwned;
    private double price;

    public Stock(String name, double cost, int yearPurchased, String tickerSymbol, int sharesOwned, double price) {
        super(name, cost, yearPurchased); // Call parent constructor
        this.tickerSymbol = tickerSymbol;
        this.sharesOwned = sharesOwned;
        this.price = price;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public void setSharesOwned(int sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double computeValue() {
        return price * sharesOwned;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSymbol: " + tickerSymbol + "\nShares: " + sharesOwned + "\nPrice: " + price;
    }
}
