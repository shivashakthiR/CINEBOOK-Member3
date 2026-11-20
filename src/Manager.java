
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    Scanner sc;
    DiscountManager discountManager;

    public Manager(Scanner sc) {
        this.sc = sc;
        discountManager = new DiscountManager(sc);
    }

    public void addSampleMovies() {
        movies.add(new Movie("Interstellar", "Sci-Fi", 169, 200));
        movies.add(new Movie("Inception", "Thriller", 148, 180));
        movies.add(new Movie("Avatar", "Action", 162, 220));
    }

    public void displayMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
            System.out.println(movie.getGenre());
            System.out.println(movie.getDuration());
            System.out.println("Price: Rs." + movie.getTicketPrice());
            System.out.println("------------------");
        }
    }

    public Movie findMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }

    public void bookTickets() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter movie name: ");
        String movieName = sc.nextLine();

        Movie movie = findMovie(movieName);

        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        sc.nextLine();

        if (tickets <= 0) {
            System.out.println("Invalid ticket quantity!");
            return;
        }

        Booking booking = new Booking(name, movie, tickets);

        double finalBill =
            discountManager.calculateFinalBill(booking.getTotalAmount());

        booking.setFinalAmount(finalBill);
        bookings.add(booking);

        System.out.println("Booking successful!");
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println("Customer: " + booking.getCustomerName());
            System.out.println("Movie: " + booking.getMovie().getName());
            System.out.println("Tickets: " + booking.getNumberOfTickets());
            System.out.println("Original Bill: Rs." + booking.getTotalAmount());
            System.out.println("Final Bill: Rs." + booking.getFinalAmount());
            System.out.println("------------------");
        }
    }

    public void cancelBooking() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getCustomerName().equalsIgnoreCase(name)) {
                bookings.remove(i);
                System.out.println("Booking cancelled!");
                return;
            }
        }

        System.out.println("Booking not found!");
    }

    public void calculateBill() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(name)) {
                System.out.println("Original Bill: Rs." + booking.getTotalAmount());
                System.out.println("Discount: Rs."
                    + (booking.getTotalAmount() - booking.getFinalAmount()));
                System.out.println("Final Bill: Rs." + booking.getFinalAmount());
                return;
            }
        }

        System.out.println("Booking not found!");
    }

    public void displayOffers() {
        discountManager.displayOffers();
    }

    public void applyDiscount() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(name)) {
                double finalBill =
                    discountManager.calculateFinalBill(booking.getTotalAmount());

                booking.setFinalAmount(finalBill);
                return;
            }
        }

        System.out.println("Booking not found!");
    }
}
