package io.egen.rentalflix;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
    static MovieService  ms;
    
	@BeforeClass
	public static void createTestMovieDB() {
		ms = new MovieService();
		int i;
		for( i = 1; i <= 3; i++) {
			Movie movie = new Movie(i, "LOTR " + i, "200"+i, "ENG");			
			ms.create(movie);
		}
		for (int j = 1 ; j <= 6 ; j++) {
			Movie movie = new Movie(j+i, "STAR WARS "+ j, "200"+j, "ENG");
			ms.create(movie);
		}
	}
	
	@Test
	public void testCreateMovie() {
		int actualAllMovieCount = ms.findByName("LOTR").size();
		Assert.assertEquals(3, actualAllMovieCount);
	}
	
	@Test
	public void testFindAll() {
		int totalMoviesInDB = ms.findAll().size();
		Assert.assertEquals(9, totalMoviesInDB);
	}

	
	@Test 
	public void testFindByName(){
		int actualMovieCount = ms.findByName("LOTR").size();
		Assert.assertEquals(3, actualMovieCount);
	}
	
	@Test 
	public void negativeTestFindByName(){
		int actualMovieCount = ms.findByName("Dark").size();
		Assert.assertEquals(0, actualMovieCount);
	}
	
	@Test 
	public void testUpdate() {
		Movie actualMovie = new Movie(1, "LOTR", "2004", "ENG");
		Movie expectedMovie = ms.update(actualMovie);
		Assert.assertEquals(expectedMovie, actualMovie);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negativeTestUpdate() {
		Movie actualMovie = new Movie(1001, "God Father", "1999", "ENG");
		ms.update(actualMovie);
	}
	
	@Test
	public void testDelete() {
		int id = 1;
		Movie expectedMovie = ms.delete(id);
		Assert.assertEquals(expectedMovie.getId(), id);
	}
	
	@After
	public void addTheDeletedMovieBack(){
		Movie movie = new Movie(1, "LOTR" + 1, "2001", "ENG");
		ms.create(movie);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negativeTestDelete() {
		int id = 1;
		Movie expectedMovie = ms.delete(id);
		ms.delete(id);
	}
	
	@Test
	public void testRentMovie() {
		int id = 1;
		String user = "Madhur";
		boolean actual = ms.rentMovie(id, user);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negativeTestRentMovie() {
		int id = 101;
		String user = "Madhur";
		boolean actual = ms.rentMovie(id, user);
	}
}
