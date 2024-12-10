// Andrii Malakhovtsev
// December 9, 2024
// The Company

abstract public class StaffMember {
    private String name;
    private String address;
    private String phoneNumber;

    public StaffMember(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }

    public abstract double pay();
}
