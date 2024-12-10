// Andrii Malakhovtsev
// December 9, 2024
// The Company

public class Employee extends StaffMember {
    private String socialSecurityNumber;
    private double payRate;

    public Employee(String name, String address, String phoneNumber, String socialSecurityNumber, double payRate) {
        super(name, address, phoneNumber);
        this.socialSecurityNumber = socialSecurityNumber;
        this.payRate = payRate;
    }

    public String toString() {
        return super.toString() + "\nSocial Security Number: " + socialSecurityNumber;
    }

    public double getPayRate() {
        return payRate;
    }

    public double pay() {
        return payRate;
    }
}
