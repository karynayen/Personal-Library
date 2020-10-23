// TODO: Auto-generated Javadoc
/**
 * The Class VideoGame.
 *
 * @author Michael
 */

public class VideoGame extends Media {
	
	/**
	 * Instantiates a new video game.
	 *
	 * @param title  the title
	 * @param format  the format
	 * @param location  the location
	 * @param notes  the notes
	 */
	public VideoGame(String title, String format, String location, String notes) {
		super(title, format, location, notes);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "VIDEO GAME:\n  Title: " + super.getTitle() + "\n  Format: " + super.getFormat() + "\n  Location: " + super.getLocation() + "\n  Notes: " + super.getNotes();
	}

}
