// Andrii Malakhovtsev
// Asset Management

public class Property extends Asset {
    private double assessedValue;

    public Property(String name, double cost, int yearPurchased, double assessedValue) {
        super(name, cost, yearPurchased);
        this.assessedValue = assessedValue;
    }

    public double getAssessedValue() {
        return assessedValue;
    }

    public void setAssessedValue(double assessedValue) {
        this.assessedValue = assessedValue;
    }

    @Override
    public double computeValue() {
        return assessedValue;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAssessed Value: " + assessedValue;
    }
}
