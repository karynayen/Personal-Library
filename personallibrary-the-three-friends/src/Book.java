// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 *
 * @author Michael
 */

public class Book extends Media {

	/** The author. */
	private String author;
	
	/**
	 * Instantiates a new book.
	 *
	 * @param title  the title
	 * @param format  the format
	 * @param location  the location
	 * @param notes  the notes
	 * @param author  the author
	 */
	public Book(String title, String format, String location, String notes, String author) {
		super(title, format, location, notes);
		this.author = author;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BOOK:\n  Title: " + super.getTitle() + "\n  Format: " + super.getFormat() + "\n  Location: " + super.getLocation() + "\n  Author: " + this.getAuthor() + "\n  Notes: " + super.getNotes();
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author  the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


}
