import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String inputName;
        int age;

        inputName = scnr.next();
        boolean exception = false;
        while (!inputName.equals("-1")) {
            try {
                age = scnr.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(inputName + " " + 0);
                inputName = scnr.next();
                exception = true;
                continue;
            }
            if (!exception) System.out.println(inputName + " " + (age + 1));
            exception = false;
            inputName = scnr.next();
        }
    }
}
