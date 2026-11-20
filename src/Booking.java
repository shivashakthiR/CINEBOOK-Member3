
public class Booking {

    private String customerName;
    private Movie movie;
    private int numberOfTickets;
    private double totalAmount;
    private double finalAmount;

    // Constructor
    public Booking(String customerName, Movie movie, int numberOfTickets) {

        this.customerName = customerName;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;

        this.totalAmount = movie.getTicketPrice() * numberOfTickets;
        this.finalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
