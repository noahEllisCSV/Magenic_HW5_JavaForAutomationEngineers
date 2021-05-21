import java.util.*;

public class UserInputs {
    private Scanner scanner;
    private MovieStorage movieStorage;

    public UserInputs(){
        scanner = new Scanner(System.in);
        firstStep();
    }

    public void firstStep(){
        System.out.println("\n\nWould you like to populate the movie Storage with a pre-made movie list?\nEnter yes (or y) to do so, any other input will skip this step.  You will have to add movies manually if you do not auto populate");
        String answer = scanner.nextLine().toLowerCase(Locale.ROOT);
        if (answer.equals("yes") || (answer.equals("y"))){
            prePopulateMovies();
        }
        else{
            this.movieStorage = new MovieStorage();
        }
    }
    //menu selection
    private int Menu(){
        try{
            System.out.println("Choose 1 to check out a movie.");
            System.out.println("Choose 2 to add a movie.");
            System.out.println("Choose 3 to return a movie.");
            System.out.println("Choose 4 to search for a movie.");
            System.out.println("Choose 5 to see all movies.");
            System.out.println("Choose 6 to quit program");
            int selection = scanner.nextInt();
            scanner.nextLine(); //needed to add this because nextInt was not allowing input after selection
            return selection;
        }
        catch (InputMismatchException e){
            System.out.println("****************Invalid input, please try again*******************");
            scanner.nextLine();//scanner is weird, got into a looping situation without this
            Menu();
        }
        return 0;
    }

    //switch case based on decisions
    public boolean MenuFunctionality(){
        int selection = Menu();
        switch (selection){
            case 1:
                System.out.println("Which movie would you like to check out? (Name of Movie must be exact, but case insensitive)");
                String movieName = scanner.nextLine();
                Movie movie = movieStorage.SearchForReturnOrCheckout(movieName);
                if (movie != null){
                    movieStorage.ReturnOrCheckOut(movie, "checkOut");
                }
                else{
                    System.out.println("Movie not found!!! Try again");
                }
                return false;
            case 2:
                System.out.println("Enter movie Name");
                String workingTitle = scanner.nextLine();
                System.out.println("Enter movie Director");
                String workingDirector = scanner.nextLine();
                System.out.println("Enter movie Genre");
                String workingGenre = scanner.nextLine();
                movieStorage.AddMovie(workingTitle, workingDirector, workingGenre, false);
                System.out.println("Movie successfully added");
                return false;
            case 3:
                System.out.println("Which movie would you like to return? (Name of Movie must be exact, but case insensitive)");
                String returnMovieName = scanner.nextLine();
                Movie returnMovie = movieStorage.SearchForReturnOrCheckout(returnMovieName);
                if (returnMovie != null){
                    movieStorage.ReturnOrCheckOut(returnMovie, "return");
                }
                return false;
            case 4:
                movieStorage.SearchMovie(scanner);
                return false;
            case 5:
                movieStorage.GetAllMovies();
                return false;
            case 6:
                return true;
            default:
                System.out.println("Invalid selection, please try again");
                return MenuFunctionality();
        }
    }

    private void prePopulateMovies(){
        this.movieStorage = new MovieStorage();
        this.movieStorage.AddMovie("GoodFellas", "Martin Scorsese", "Crime",false);
        this.movieStorage.AddMovie("Silence of the Lambs", "Jonathan Demme", "Thriller", false);
        this.movieStorage.AddMovie("The Green Mile", "Frank Darabont", "Drama", false);
        this.movieStorage.AddMovie("Fight Club", "David Fincher", "Action", false);
        this.movieStorage.AddMovie("One Flew Over The Cuckoo's Nest", "Milos Forman", "Drama", false);
    }
}
