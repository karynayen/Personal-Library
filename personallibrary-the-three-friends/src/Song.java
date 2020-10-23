/**
 * The Class Song.
 *
 * @author Jessica
 */
public class Song extends Media {
	/** The artist. */
	private String artist;
	
	/** The genre. */
	private String genre;
	
	/**
	 * Instantiates a new song.
	 */
	public Song(String title, String format, String location, String notes, String artist, String genre) {
		super(title, format, location, notes);
		this.artist = artist;
		this.genre = genre;
	}

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre.
	 *
	 * @param genre the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		String str = "SONG\nTitle: " + getTitle() + "\nFormat: " + getFormat() 
			+ "\nLocation: " + getLocation() + "\nArtist: " + artist 
			+ "\nGenre: " + genre + "\nNotes: " + getNotes();
		return str;
	}

}
