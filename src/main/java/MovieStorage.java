import java.util.*;

public class MovieStorage {
    //holds data about movies
    private ArrayList<Movie> movieStorage;

    //new "database" of movies
    public MovieStorage(){
        movieStorage = new ArrayList<Movie>();
    }

    //getters and setters for movieStorage
    public ArrayList<Movie> getMovieStorage() {
        return movieStorage;
    }

    public void setMovieStorage(ArrayList<Movie> movieStorage) {
        this.movieStorage = movieStorage;
    }

    //used to return or check out a movie
    public void ReturnOrCheckOut(Movie movie, String action){
        if (action.equals("return")){
            if (movie.getIsCheckedOut()){
                movie.setIsCheckedOut(false);
                System.out.println("Movie Returned!");
            }
        }
        if (action.equals("checkOut")){
            if (!movie.getIsCheckedOut()){
                movie.setIsCheckedOut(true);
                System.out.println("Movie Checked Out!");
            }
        }
    }

    /**
     * Pass a scanner from  the user input class. Lets the user search by title, genre or director
     * @param scanner
     * @return
     */
    public void SearchMovie(Scanner scanner){
        List<Movie> searchedMovies = new ArrayList<Movie>();
        int field = 0;
        try{
            System.out.println("Enter the field you would like to search by.\n 1 = Title, 2 = Genre, 3 = Director)");
            field = scanner.nextInt();
            scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("******************** Invalid entry please try again ********************");
            scanner.nextLine();
            SearchMovie(scanner);
        }
        System.out.println("Enter search criteria (ie a movie name, a genre, director name");
        String searchCriteria = scanner.nextLine();
        switch (field){
            case 1:
                for (Movie movie : movieStorage){
                    if (movie.getMovieTitle().toLowerCase(Locale.ROOT).equals(searchCriteria.toLowerCase(Locale.ROOT))){
                        searchedMovies.add(movie);
                    }
                }
                PrintMovies(searchedMovies);
                break;
            case 2:
                for (Movie movie : movieStorage) {
                    if (movie.getGenre().toLowerCase(Locale.ROOT).contains(searchCriteria.toLowerCase(Locale.ROOT))){
                        searchedMovies.add(movie);
                    }
                }
                PrintMovies(searchedMovies);
                break;
            case 3:
                for (Movie movie : movieStorage) {
                    if (movie.getDirector().toLowerCase(Locale.ROOT).equals(searchCriteria.toLowerCase(Locale.ROOT))){
                        searchedMovies.add(movie);
                    }
                }
                PrintMovies(searchedMovies);
                break;
            default:
                System.out.println("Not a valid selection, please try again");
                SearchMovie(scanner);
        }
    }


    //searches for movie, used by UserInputs.MenuFunctionality()
    public Movie SearchForReturnOrCheckout(String movieName){
        for (Movie movie : movieStorage){
            if (movie.getMovieTitle().toLowerCase(Locale.ROOT).equals(movieName.toLowerCase(Locale.ROOT))){
                return movie;
            }
        }
        return null;
    }
    //checks if movie is available, but just can check the boolean instead
//    public void CheckIfAvailable(Movie movie){
//        if(!movie.getIsCheckedOut()){
//            System.out.println("Movie is available");
//        }
//        else{
//            System.out.println("Movie is checked out. Too bad so sad");
//        }
//    }

    //add a movie, takes a movie object.  If you don't have checked out, defaults to not checked out
    public Movie AddMovie(String movieTitle, String director, String genre, boolean checkedOut){
        Movie checkExists = SearchForReturnOrCheckout(movieTitle);
        MovieFactory moviefactory = new MovieFactory();
        if (checkExists != null){
            System.out.println("This movie is already in the system");
            return null;
        }
        else{
            return moviefactory.createMovie(movieTitle, director, genre, movieStorage);
        }
    }

    private void PrintMovies(List<Movie> movies){
        for (Movie movie : movies){
            System.out.println("----------------------------");
            System.out.println("Title: " + movie.getMovieTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Genre: " + movie.getGenre());
            if(!movie.getIsCheckedOut()){
                System.out.println(movie.getMovieTitle() + " is available");
            }
            else{
                System.out.println(movie.getMovieTitle() + " is not available");
            }
            System.out.println("----------------------------");
        }
    }

    public void GetAllMovies(){
        PrintMovies(movieStorage);
    }
}
