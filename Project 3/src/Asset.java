// Andrii Malakhovtsev
// Asset Management

public class Asset {
    private String name;
    private double cost;
    private int yearPurchased;

    public Asset(String name, double cost, int yearPurchased) {
        this.name = name;
        this.cost = cost;
        this.yearPurchased = yearPurchased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(int yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public double amortizedCost(int currentYear) {
        return cost / (currentYear - yearPurchased);
    }

    public double computeValue() {
        return cost;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nCost: " + cost + "\nYear Purchased: " + yearPurchased;
    }
}
