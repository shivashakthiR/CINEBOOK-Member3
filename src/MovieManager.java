
import java.util.ArrayList;

public class MovieManager {

    ArrayList<Movie> movies = new ArrayList<>();

    // Add sample movies
    public void addSampleMovies() {

        movies.add(new Movie("Interstellar", "Sci-Fi", 169, 200));
        movies.add(new Movie("Inception", "Thriller", 148, 180));
        movies.add(new Movie("Avatar", "Action", 162, 220));

    }

    // Display all movies
    public void displayMovies() {

        for (Movie movie : movies) {

            System.out.println(movie.getName());
            System.out.println(movie.getGenre());
            System.out.println(movie.getDuration() + " minutes");
            System.out.println("Price: Rs." + movie.getTicketPrice());

            System.out.println("--------------------");
        }
    }

    // Search for a movie
    public Movie findMovie(String name) {

        for (Movie movie : movies) {

            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }

        return null;
    }
}
