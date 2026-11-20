
public class Movie {

    private String name;
    private String genre;
    private int duration;
    private double ticketPrice;

    // Constructor
    public Movie(String name, String genre, int duration, double ticketPrice) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
