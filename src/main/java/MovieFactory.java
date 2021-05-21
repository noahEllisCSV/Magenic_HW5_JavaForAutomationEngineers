import java.util.ArrayList;

/**
 * Creates movie for checkout
 *
 *
 */

public class MovieFactory {
    public Movie createMovie(String title, String director, String genre, boolean available, ArrayList<Movie> movies){
        Movie movie = new Movie(title, director, genre, available);
        movies.add(movie);
        return movie;
    }
    public Movie createMovie(String title, String director, String genre, ArrayList<Movie> movies){
        Movie movie = new Movie(title, director, genre, false);
        movies.add(movie);
        return movie;
    }
}
