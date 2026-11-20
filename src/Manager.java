
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Add sample movies
    public void addSampleMovies() {

        movies.add(new Movie("Interstellar", "Sci-Fi", 169, 200));
        movies.add(new Movie("Inception", "Thriller", 148, 180));
        movies.add(new Movie("Avatar", "Action", 162, 220));

    }

    // Display movies
    public void displayMovies() {

        for (Movie movie : movies) {

            System.out.println("Movie: " + movie.getName());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Duration: " + movie.getDuration());
            System.out.println("Price: Rs." + movie.getTicketPrice());

            System.out.println("--------------------");
        }
    }

    // Search movie
    public Movie findMovie(String name) {

        for (Movie movie : movies) {

            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }

        return null;
    }

    // Book tickets
    public void bookTickets() {

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

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

        Booking booking = new Booking(customerName, movie, tickets);

        bookings.add(booking);

        System.out.println("Booking successful!");
        System.out.println("Total Amount: Rs." + booking.getTotalAmount());
    }

    // View bookings
    public void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        for (Booking booking : bookings) {

            System.out.println("Customer: " + booking.getCustomerName());
            System.out.println("Movie: " + booking.getMovie().getName());
            System.out.println("Tickets: " + booking.getNumberOfTickets());
            System.out.println("Amount: Rs." + booking.getTotalAmount());

            System.out.println("--------------------");
        }
    }
}
