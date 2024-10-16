// Name: Andrii Malakhovtsev
// Project: CFA Pay

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        String firstName = scnr.next(), lastName = scnr.next();
        int pay = scnr.nextInt();

        int[] denominations = { 10000, 5000, 1000, 500, 100, 50, 25, 10, 5 };
        int[] denominationsCounts = new int[denominations.length];

        int remainingPay = pay;
        for (int i = 0; i < denominations.length; i++) {
            denominationsCounts[i] = remainingPay / denominations[i];
            remainingPay %= denominations[i];
        }

        System.out.printf("Name            Pay   10k  5k  1k 500 100  50  25  10   5%n");
        System.out.printf("=============== ===== === === === === === === === === ===%n");
        System.out.printf("%-15s %5d", lastName + ", " + firstName, pay);
        for (int i = 0; i < denominations.length; i++) {
            System.out.printf("%3d ",denominationsCounts[i]);
        }

    }
}
