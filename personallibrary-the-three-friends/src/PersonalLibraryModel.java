/**
 * @author Michael
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalLibraryModel.
 */
public class PersonalLibraryModel {

	/** The personal library. */
	private ArrayList<Media> personalLibrary;

	/** The search results library. */
	private ArrayList<Media> searchResultsLibrary;

	/** The book index. */
	private int bookIndex = 0;

	/** The song index. */
	private int songIndex = 0;

	/** The video index. */
	private int videoIndex = 0;

	/** The videogame index. */
	private int videogameIndex = 0;

	/**
	 * Instantiates a new personal library model.
	 */
	public PersonalLibraryModel() {
		personalLibrary = new ArrayList<Media>();
	}

	/**
	 * Sorts Personal Library by Name and Type.
	 */
	public void sort() {
		Collections.sort(personalLibrary, new ByName());
	}

	/**
	 * The Class ByName.
	 */
	private class ByName implements Comparator<Media> {

		/**
		 * Compare.
		 *
		 * @param o1  the first media
		 * @param o2  the second media
		 * @return the comparison
		 */
		//comparator
		public int compare(Media o1, Media o2) {
			if (o1.getClass().getName().compareTo(o2.getClass().getName()) == 0) {
				return o1.getTitle().compareTo(o2.getTitle());
			} else {
				return o1.getClass().getName().compareTo(o2.getClass().getName());
			}
		}

	}

	/**
	 * Gets the media library.
	 *
	 * @param mediaType  the media type
	 * @return the media library
	 */
	public ArrayList<Media> getMediaLibrary(String mediaType){
		int i = 0;
		int k = this.personalLibrary.size();
		ArrayList<Media> mediaTypeLibrary = new ArrayList<Media>();

		if (mediaType.equalsIgnoreCase("Book")) {
			i = this.bookIndex;
			k = this.songIndex;
		} else if (mediaType.equalsIgnoreCase("Song")) {
			i = this.songIndex;
			k = this.videoIndex;
		} else if (mediaType.equalsIgnoreCase("Video")) {
			i = this.videoIndex;
			k = this.videogameIndex;
		} else if (mediaType.equalsIgnoreCase("VideoGame")) {
			i = this.videogameIndex;
			k = this.personalLibrary.size();
		} 

		for (i = i + 0; i < k; i++) {
			mediaTypeLibrary.add(this.personalLibrary.get(i));
		}

		searchResultsLibrary = mediaTypeLibrary;
		return mediaTypeLibrary;
	}

	/**
	 * Gets the title library.
	 *
	 * @param mediaTitle  the media title
	 * @return the title library
	 */
	public ArrayList<Media> getTitleLibrary(String mediaTitle){
		ArrayList<Media> TitleLibrary = new ArrayList<Media>();

		for (int i = 0; i < personalLibrary.size(); i++) {
			if (personalLibrary.get(i).getTitle().equalsIgnoreCase(mediaTitle)) {
				TitleLibrary.add(personalLibrary.get(i));
			}
		}

		searchResultsLibrary = TitleLibrary;
		return TitleLibrary;
	}

	/**
	 * Gets the media and title library.
	 *
	 * @param mediaType  the media type
	 * @param mediaTitle  the media title
	 * @return the media and title library
	 */
	public ArrayList<Media> getMediaAndTitleLibrary(String mediaType, String mediaTitle){
		ArrayList<Media> MediaAndTitleLibrary = new ArrayList<Media>();
		int i = 0;
		int k = this.personalLibrary.size();

		if (mediaType.equalsIgnoreCase("Book")) {
			i = this.bookIndex;
			k = this.songIndex;
		} else if (mediaType.equalsIgnoreCase("Song")) {
			i = this.songIndex;
			k = this.videoIndex;
		} else if (mediaType.equalsIgnoreCase("Video")) {
			i = this.videoIndex;
			k = this.videogameIndex;
		} else if (mediaType.equalsIgnoreCase("VideoGame")) {
			i = this.videogameIndex;
			k = this.personalLibrary.size();
		}

		for (i = 0; i < k; i++) {
			if (personalLibrary.get(i).getTitle().equalsIgnoreCase(mediaTitle) && personalLibrary.get(i).getClass().getName().equalsIgnoreCase(mediaType)) {
				MediaAndTitleLibrary.add(personalLibrary.get(i));
			}
		}

		searchResultsLibrary = MediaAndTitleLibrary;
		return MediaAndTitleLibrary;

	}

	/**
	 * Removes the media.
	 *
	 * @param indexToBeDeleted  the index to be deleted
	 * @return the updated searchResultsLibrary;
	 */
	public ArrayList<Media> removeMedia(int indexToBeDeleted){
		Media mediaToBeDeleted = searchResultsLibrary.get(indexToBeDeleted);

		if (mediaToBeDeleted.getClass().getName().equalsIgnoreCase("Book")) {
			this.songIndex--;
			this.videoIndex--;
			this.videogameIndex--;
		} else if (mediaToBeDeleted.getClass().getName().equalsIgnoreCase("Song")) {
			this.videoIndex--;
			this.videogameIndex--;
		} else if (mediaToBeDeleted.getClass().getName().equalsIgnoreCase("Video")) {
			this.videogameIndex--;
		} 

		for (int i = 0; i < personalLibrary.size(); i++) {
			if (personalLibrary.get(i).equals(mediaToBeDeleted)) {
				personalLibrary.remove(i);
				searchResultsLibrary.remove(indexToBeDeleted);
				break;
			}
		}

		return searchResultsLibrary;

	}


	/**
	 * Gets the sorted library.
	 *
	 * @return the library
	 */
	//method: get library method
	public ArrayList<Media> getLibrary(){
		return personalLibrary;
	}

	/**
	 * Adds the media and sorts.
	 *
	 * @param media  the media to be added
	 */
	//method: adding new media method
	public void addMedia(Media media) {

		if(media.getClass().getName().equalsIgnoreCase("Book")) {
			this.songIndex++;
			this.videoIndex++;
			this.videogameIndex++;
		} else if (media.getClass().getName().equalsIgnoreCase("Song")) {
			this.videoIndex++;
			this.videogameIndex++;
		} else if (media.getClass().getName().equalsIgnoreCase("Video")) {
			this.videogameIndex++;
		}

		personalLibrary.add(media);
		Collections.sort(personalLibrary, new ByName());
	}


}
