// Andrii Malakhovtsev
// December 9, 2024
// The Company

public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phoneNumber, String socialSecurityNumber, double payRate) {
        super(name, address, phoneNumber, socialSecurityNumber, payRate);
        bonus = 0;
    }

    public void awardBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override
    public double pay() {
        double finalPay = super.getPayRate() + bonus;
        bonus = 0;
        return finalPay;
    }
}
