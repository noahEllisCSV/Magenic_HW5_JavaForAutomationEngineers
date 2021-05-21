import java.util.ArrayList;

public class Movie {

    //Title of movie
    private String movieTitle;
    //Movie's Director
    private String director;
    //Movie's Genre
    private String genre;
    //Boolean to see if movie is checked out.  True if checked out, False if not.
    private boolean checkedOut;

    /**
     * creates a movie, defaults to not checked out.
     * @param movieTitle
     * @param director
     * @param genre
     * @param checkedOut
     */
    Movie(String movieTitle, String director, String genre, boolean checkedOut) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    //gets director
    public String getDirector() {
        return director;
    }

    //get genre
    public String getGenre() {
        return genre;
    }

    //gets movie title
    public String getMovieTitle(){
        return  movieTitle;
    }

    //gets checked out status
    public boolean getIsCheckedOut() {
        return checkedOut;
    }

    //set checked out status
    public void setIsCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    //set director
    public void setDirector(String director) {
        this.director = director;
    }

    //set genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //set movie title
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
