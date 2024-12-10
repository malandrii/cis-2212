// Andrii Malakhovtsev
// December 9, 2024
// The Company

import java.io.*;
import java.util.*;

public class PayrollManager {
    private String fileName;
    private List<StaffMember> staffList;

    public PayrollManager(String fileName) {
        // necessary step on my machine, it does not see the file in the same directory without specification
        this.fileName = System.getProperty("user.dir") + File.separator + "Project Final" +
                 File.separator + "src" + File.separator + fileName;

        this.staffList = new ArrayList<>();
    }

    public boolean loadData() {
        System.out.println("Payroll Manager\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Loading data...\n");

            String line;
            while ((line = reader.readLine()) != null) {
                String recordType = line.trim();
                String name = reader.readLine().trim();
                String address = reader.readLine().trim();
                String phoneNumber = reader.readLine().trim();

                StaffMember staffMember;
                switch (recordType.toLowerCase()) {
                    case "volunteer":
                        staffMember = new Volunteer(name, address, phoneNumber);
                        break;
                    case "executive":
                        String ssnExec = reader.readLine().trim();
                        double payExec = Double.parseDouble(reader.readLine().trim());
                        Executive executive = new Executive(name, address, phoneNumber, ssnExec, payExec);

                        executive.awardBonus(getValidInput("Enter bonus for " + name + ": "));
                        staffMember = executive;
                        break;
                    case "hourly":
                        String ssnHourly = reader.readLine().trim();
                        double payHourly = Double.parseDouble(reader.readLine().trim());
                        Hourly hourly = new Hourly(name, address, phoneNumber, ssnHourly, payHourly);

                        hourly.addHours(getValidInput("Enter hours worked for " + name + ": "));
                        staffMember = hourly;
                        break;
                    default:
                        System.out.println("Error: Unknown record type: " + recordType);
                        continue;
                }

                staffList.add(staffMember);
            }
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            return false;
        }
        catch (IOException e) {
            System.out.println("Error: Problem reading the file");
            return false;
        }
    }

    private double getValidInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0) {
                    throw new IllegalArgumentException("Error: Value cannot be negative.");
                }
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid input. Please, enter a valid number.");
            }
        }
        return value;
    }

    public void runPayroll() {
        for (StaffMember staff : staffList) {

            System.out.println("\n--------------------");
            System.out.println(staff);

            double pay = staff.pay();

            if (pay == 0.0) {
                System.out.println("\nThanks!");
            }
            else {
                System.out.printf("\nPaid: $%.2f%n", pay);
            }
        }
    }
}