import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();

        int n;

        do {
            System.out.print("How many items (1-100)? ");
            n = input.nextInt();
        } while (n < 1 || n > 100);

        for (int i = 1; i <= n; i++) {
            String type;

            do {
                System.out.print("Type (B/D): ");
                type = input.next();
            } while (!type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("D"));

            input.nextLine(); // Nadiifinta Scanner buffer-ka

            System.out.print("Title: ");
            String title = input.nextLine();

            int days;

            do {
                System.out.print("Days late (0-365): ");
                days = input.nextInt();
            } while (days < 0 || days > 365);

            if (type.equalsIgnoreCase("B")) {
                items.add(new BookItem(title, days));
            } else {
                items.add(new DVDItem(title, days));
            }
        }

        long total = 0;

        System.out.println("\n--- LIBRARY FINE SUMMARY ---");

        for (LibraryItem item : items) {
            long fine = item.calculateFine();

            System.out.println(item.getTitle() + ": " + fine + " units");

            total = total + fine;
        }

        System.out.println("Total fines: " + total + " units");

        input.close();
    }
}
