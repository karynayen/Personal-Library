import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Media.
 *
 * @author karynayen
 * 
 * The Class Media.
 * 
 * This is the Media super class. 
 * It contains the title, location, format, and notes variables, 
 * along with getter and setter methods for each
 * Book.java, Media.java, Song.java, Video.java,
 * and VideoGame.java extend this class. 
 * 
 */
public class Media implements Comparable<Media>, Comparator<Media> {
     
     /** The title. */
     private String title; 
     
     /** The location. */
     private String location; //check the data type of location
     
     /** The format. */
     private String format; 
     
     /** The notes. */
     private String notes;
    
     
     /**
      * Instantiates a new media.
      *
      * @param title the title
      */
     public Media(String title) {
         this.title = title;
         this.location = ""; 
         this.format = "";
         this.notes = "";
     }
     
     /**
      * Instantiates a new media.
      *
      * @param title the title
      * @param location the location
      * @param format the format
      * @param notes the notes
      */
     public Media(String title, String format, String location, String notes) {
         this.title = title; 
         this.location = location; 
         this.format = format; 
         this.notes = notes; 
     }
    
     
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format the new format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	// These may be helpful for use cases 3-5...
     /**
      * Compare.
      *
      * @param o1 the o 1
      * @param o2 the o 2
      * @return the int
      */
     // Ignore for use cases 1,2
     @Override
     public int compare(Media o1, Media o2) {
         // TODO Auto-generated method stub
         return  0;
     }

     /**
      * Compare to.
      *
      * @param o the o
      * @return the int
      */
     @Override
     public int compareTo(Media o) {
         // TODO Auto-generated method stub
         return  0;
     }

}