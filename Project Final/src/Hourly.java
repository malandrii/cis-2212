// Andrii Malakhovtsev
// December 9, 2024
// The Company

public class Hourly extends Employee {
    private double hoursWorked;

    public Hourly(String name, String address, String phoneNumber, String socialSecurityNumber, double payRate) {
        super(name, address, phoneNumber, socialSecurityNumber, payRate);
        hoursWorked = 0;
    }

    public String toString() {
        return super.toString() + "\nCurrent Hours: " + hoursWorked;
    }

    public void addHours(double hours) {
        hoursWorked += hours;
    }

    @Override
    public double pay() {
        double finalPay = hoursWorked * super.getPayRate();
        hoursWorked = 0;
        return finalPay;
    }
}
