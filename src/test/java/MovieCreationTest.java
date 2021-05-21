import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieCreationTest {

    @Test
    public void testAddMovie(){
        MovieStorage storage = new MovieStorage();
        storage.AddMovie("test", "test", "test", false);
        Movie movie = storage.SearchForReturnOrCheckout("test");
        Assert.assertEquals(movie.getMovieTitle(), "test");
    }

    @Test
    public void testSearchMovieNameExists(){
        MovieStorage storage = new MovieStorage();
        storage.AddMovie("test", "test", "test", false);
        Movie movie = storage.SearchForReturnOrCheckout("test");
        Assert.assertEquals(movie.getMovieTitle(), "test");
    }

    @Test
    public void testSearchMovieNameNotExist(){
        MovieStorage storage = new MovieStorage();
        Movie movie = storage.SearchForReturnOrCheckout("test");
        Assert.assertNull(movie);
    }

    @Test
    public void testReturnMovie(){
        MovieStorage storage = new MovieStorage();
        Movie movie = storage.AddMovie("test", "test", "test", true);
        storage.ReturnOrCheckOut(movie, "return");
        Assert.assertFalse(movie.getIsCheckedOut());
    }

    @Test
    public void testCheckOutMovie(){
        MovieStorage storage = new MovieStorage();
        Movie movie = storage.AddMovie("test", "test", "test", false);
        storage.ReturnOrCheckOut(movie, "checkOut");
        Assert.assertTrue(movie.getIsCheckedOut());
    }
}
