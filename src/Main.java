
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager(sc);

        manager.addSampleMovies();

        int choice;

        do {

            System.out.println("\n===== CINEBOOK =====");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Calculate Bill");
            System.out.println("6. Display Offers");
            System.out.println("7. Apply Discount");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.displayMovies();
                    break;

                case 2:
                    manager.bookTickets();
                    break;

                case 3:
                    manager.viewBookings();
                    break;

                case 4:
                    manager.cancelBooking();
                    break;

                case 5:
                    manager.calculateBill();
                    break;

                case 6:
                    manager.displayOffers();
                    break;

                case 7:
                    manager.applyDiscount();
                    break;

                case 8:
                    System.out.println("Thank you for using CINEBOOK!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
