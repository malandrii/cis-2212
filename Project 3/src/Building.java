// Andrii Malakhovtsev
// Asset Management

public class Building extends Property {
    private String address;

    public Building(String name, double cost, int yearPurchased, double assessedValue, String address) {
        super(name, cost, yearPurchased, assessedValue);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAddress: " + address;
    }
}
