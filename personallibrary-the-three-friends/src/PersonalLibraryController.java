import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalLibraryController.
 * 
 * @author Jessica
 */

public class PersonalLibraryController {

	/** The model. */
	private PersonalLibraryModel model = new PersonalLibraryModel();
	
	/**
	 * Instantiates a new personal library controller.
	 */
	public PersonalLibraryController() {}
	
	
	/**
	 * Adds the model media.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @param artist the artist
	 * @param genre the genre
	 * @return the string
	 */
	/**
	 * Adds the Song media.
	 *
	 * @param String the media type (Song)
	 */
	public String addSong(String title, String format, String location, String notes, String artist, String genre) {
		if (title.isEmpty()) {
			return "The title field is required.";
		} else {
			Song song = new Song(title, format, location, notes, artist, genre);
			model.addMedia(song);
			return "";
		}
	}

	/**
	 * Adds the Video media.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @param star the star
	 * @return the string
	 */
	public String addVideo(String title, String format, String location, String notes, String star) {
		if (title.isEmpty()) {
			return "The title field is required.";
		} else {
			Video video = new Video(title, format, location, notes, star);
			model.addMedia(video);
			return "";
		}
	}

	/**
	 * Adds the Book media.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @param author the author
	 * @return the string
	 */
	public String addBook(String title, String format, String location, String notes, String author) {
		if (title.isEmpty()) {
			return "The title field is required.";
		} else {
			Book book = new Book(title, format, location, notes, author);
			model.addMedia(book);
			return "";
		}
	}

	/**
	 * Adds the VideoGame media.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @return the string
	 */
	public String addVideoGame(String title, String format, String location, String notes) {
		if (title.isEmpty()) {
			return "The title field is required.";
		} else {
			VideoGame videoGame = new VideoGame(title, format, location, notes);
			model.addMedia(videoGame);
			return "";
		}
	}


	
	/**
	 * Gets the model library. Converts to viewable String.
	 *
	 * @return the viewable String library
	 */
	public String[] getModelLibrary() {
		ArrayList<Media> library = model.getLibrary();
		String[] list = new String[library.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = library.get(i).toString();
		}
		return list;
	}
	
	/**
	 * Gets the media library stored in model.
	 *
	 * @param media the media
	 * @return the string array of a specific media library
	 */
	public String[] getModelMediaLibrary(String media) {
		ArrayList<Media> arrayList = model.getMediaLibrary(media);
		String[] strList = new String[arrayList.size()];
		for (int i = 0; i < strList.length; i++) {
			strList[i] = arrayList.get(i).toString();
		}
		return strList;
	}

	/**
	 * Gets the title library stored in model.
	 *
	 * @param title the title
	 * @return the string array of a specific title library
	 */
	//use case 4: calls method from model (get specific title) and returns ArrayList to view
	public String[] getModelTitleLibrary(String title) {
		ArrayList<Media> arrayList = model.getTitleLibrary(title);
		String[] strList = new String[arrayList.size()];
		for (int i = 0; i < strList.length; i++) {
			strList[i] = arrayList.get(i).toString();
		}
		return strList;
	}

	/**
	 * Gets the media and title from the library stored in model.
	 *
	 * @param media the media
	 * @param title the title
	 * @return the string array of a specific media and title library
	 */
	public String[] getModelMediaAndTitleLibrary(String media, String title) {
		ArrayList<Media> arrayList = model.getMediaAndTitleLibrary(media, title);
		String[] strList = new String[arrayList.size()];
		for (int i = 0; i < strList.length; i++) {
			strList[i] = arrayList.get(i).toString();
		}
		return strList;
	}

	/**
	 * Removes the media stored in model.
	 *
	 * @param index the index
	 */
	public void removeModelMedia(int index) {
		model.removeMedia(index);
	}


}
