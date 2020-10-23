/**
 * The Class Video.
 *
 * @author Jessica
 */
public class Video extends Media {

	/** The star. */
	private String star;
	
	/**
	 * Instantiates a new video.
	 */
	public Video(String title, String format, String location, String notes, String star) {
		super(title, format, location, notes);
		this.star = star;
	}

	/**
	 * Gets the star.
	 *
	 * @return the star
	 */
	public String getStar() {
		return star;
	}

	/**
	 * Sets the star.
	 *
	 * @param star the new star
	 */
	public void setStar(String star) {
		this.star = star;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String str = "VIDEO\nTitle: " + getTitle() + "\nFormat: " + getFormat() 
			+ "\nLocation: " + getLocation() + "\nStar: " + star + "\nNotes: " + getNotes();
		return str;
	}

}
