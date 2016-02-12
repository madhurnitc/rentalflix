package io.egen.rentalflix;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	//POJO IMPLEMENTATION GOES HERE
	int id;
	String title;
	String year;
	String language;
	boolean isRented;
	/**
	 * @param id
	 * @param title
	 * @param year
	 * @param language
	 */
	public Movie(int id, String title, String year, String language) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.language = language;
		this.isRented = false;
	}
	/**
	 * @return the isRented
	 */
	public boolean isRented() {
		return isRented;
	}
	/**
	 * @param isRented the isRented to set
	 */
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
