
public class Booking {

    private String customerName;
    private Movie movie;
    private int numberOfTickets;
    private double totalAmount;

    // Constructor
    public Booking(String customerName, Movie movie, int numberOfTickets) {
        this.customerName = customerName;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
        this.totalAmount = movie.getTicketPrice() * numberOfTickets;
    }

}
