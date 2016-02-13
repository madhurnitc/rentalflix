package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {

	private ConcurrentHashMap<Integer, Movie> moviesDatabase;
	
	public  MovieService() {
		// TODO Auto-generated constructor stub
		
		moviesDatabase = new ConcurrentHashMap<Integer,Movie>();
	}
	
	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		
		List<Movie> allMovieList = new ArrayList<Movie>();
		Iterator<Entry<Integer, Movie>> itr = moviesDatabase.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<Integer, Movie> entry = itr.next();
			Movie movie = entry.getValue();
			allMovieList.add(movie);
		}
		return allMovieList;
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<Movie> movieList = new ArrayList<Movie>();
		Iterator<Entry<Integer, Movie>> itr = moviesDatabase.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Movie> entry = itr.next();
			Movie movie = entry.getValue();
			if (movie.getTitle().contains(name)) movieList.add(movie);
		}
		return movieList;
	}

	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		
		int id = movie.getId();
		moviesDatabase.put(id, movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		
		int id = movie.getId();
		Movie movieToUpdate = moviesDatabase.get(id);
		
		if ( movieToUpdate == null ) throw new IllegalArgumentException("Movie doesn't exist in Database");
		else moviesDatabase.put(id, movie);
		
		return moviesDatabase.get(id);
	}

	@Override
	public Movie delete(int id) {
		// TODO Auto-generated method stub
		
		Movie movieToDelete = moviesDatabase.get(id);
		
		if ( movieToDelete == null ) throw new IllegalArgumentException("Movie doesn't exist in Database");
		else moviesDatabase.remove(id);
		
		return movieToDelete;
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		// TODO Auto-generated method stub
		
		Movie movieToRent = moviesDatabase.get(movieId);
		if ( movieToRent == null || movieToRent.isRented() ) throw new IllegalArgumentException("Movie doesn't exist in Database or is already rented"); 
		
		movieToRent.setRented(true);
		return true;
	}

}
