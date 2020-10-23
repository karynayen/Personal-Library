import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class PersonalLibraryControllerTest.
 */
class PersonalLibraryControllerTest {

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test adding all media types with a title.
	 * 
	 * @author Jessica Young
	 */
	@Test
	void test_AddWithTitleData() {
		//initializing variables
		PersonalLibraryController controller = new PersonalLibraryController();
		String addMessage;

		//checking to see if Song successfully added
		addMessage = controller.addSong("title", "", "", "", "", "");
		assertTrue(addMessage.isEmpty());
	
		//checking to see if Video successfully added
		addMessage = controller.addVideo("title", "", "", "", "");
		assertTrue(addMessage.isEmpty());
	
		//checking to see if Book successfully added
		addMessage = controller.addBook("title", "", "", "", "");
		assertTrue(addMessage.isEmpty());
	
		//checking to see if Video Game successfully added
		addMessage = controller.addVideoGame("title", "", "", "");
		assertTrue(addMessage.isEmpty());
	}

	/**
	 * Test adding all media types without a title.
	 * 
	 * @author Jessica Young
	 */
	@Test
	void test_AddWithEmptyData() {
		//initializing variables
		PersonalLibraryController controller = new PersonalLibraryController();
		String addMessage;
	
		//checking to see if Song not successfully added
		addMessage = controller.addSong("", "", "", "", "", "");
		assertTrue("The title field is required.".equals(addMessage));
	
		//checking to see if Video not successfully added
		addMessage = controller.addVideo("", "", "", "", "");
		assertTrue("The title field is required.".equals(addMessage));
	
		//checking to see if Book not successfully added
		addMessage = controller.addBook("", "", "", "", "");
		assertTrue("The title field is required.".equals(addMessage));
	
		//checking to see if Video Game not successfully added
		addMessage = controller.addVideoGame("", "", "", "");
		assertTrue("The title field is required.".equals(addMessage));
	}

	
	/**
	 * Test get model media library.
	 * 
	 * @author Michael Young
	 */
	@Test
	void test_getModelMediaLibrary() {
		PersonalLibraryController controller = new PersonalLibraryController();

		controller.addBook("book1", "", "", "", "");
		controller.addBook("book2", "", "", "", "");
		controller.addBook("book3", "", "", "", "");

		controller.addSong("song1", "", "", "", "", "");
		controller.addSong("song2", "", "", "", "", "");

		controller.addVideo("video1", "", "", "", "");

		String[] bookSearch = controller.getModelMediaLibrary("book");

		assertTrue(bookSearch.length == 3);

		assertTrue(bookSearch[0].contains("book1"));
		assertTrue(bookSearch[1].contains("book2"));
		assertTrue(bookSearch[2].contains("book3"));

		String[] videoSearch = controller.getModelMediaLibrary("video");

		assertTrue(videoSearch.length == 1);

		assertTrue(videoSearch[0].contains("video1"));

		String[] videogameSearch = controller.getModelMediaLibrary("videogame");

		assertTrue(videogameSearch.length == 0);

	}

	/**
	 * Test get model title library.
	 * 
	 * @author Michael Young
	 */
	@Test
	void test_getModelTitleLibrary() {
		PersonalLibraryController controller = new PersonalLibraryController();

		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("book1", "", "", "", "");

		controller.addSong("cat in the hat", "", "", "", "", "");
		controller.addSong("song1", "", "", "", "", "");
		controller.addSong("song2", "", "", "", "", "");

		controller.addVideo("video1", "", "", "", "");

		String[] titleSearch = controller.getModelTitleLibrary("cat in the hat");

		assertTrue(titleSearch.length == 4);

		assertTrue(titleSearch[0].contains("cat in the hat") && titleSearch[0].contains("BOOK"));
		assertTrue(titleSearch[1].contains("cat in the hat") && titleSearch[1].contains("BOOK"));
		assertTrue(titleSearch[2].contains("cat in the hat") && titleSearch[2].contains("BOOK"));
		assertTrue(titleSearch[3].contains("cat in the hat") && titleSearch[3].contains("SONG"));

		String[] song1Search = controller.getModelTitleLibrary("song1");

		assertTrue(song1Search.length == 1);

		assertTrue(song1Search[0].contains("song1"));

		String[] emptySearch = controller.getModelTitleLibrary("bat in the mat");

		assertTrue(emptySearch.length == 0);

	}

	/**
	 * Test get model media and title library.
	 * 
	 * @author Michael Young
	 */
	@Test
	void test_getModelMediaAndTitleLibrary() {
		PersonalLibraryController controller = new PersonalLibraryController();

		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("cat in the hat", "", "", "", "");
		controller.addBook("book1", "", "", "", "");

		controller.addSong("cat in the hat", "", "", "", "", "");
		controller.addSong("song1", "", "", "", "", "");
		controller.addSong("song2", "", "", "", "", "");

		controller.addVideo("video1", "", "", "", "");
		
		String[] search1 = controller.getModelMediaAndTitleLibrary("book", "cat in the hat");
		
		assertTrue(search1.length == 3);

		assertTrue(search1[0].contains("cat in the hat") && search1[0].contains("BOOK"));
		assertTrue(search1[1].contains("cat in the hat") && search1[1].contains("BOOK"));
		assertTrue(search1[2].contains("cat in the hat") && search1[2].contains("BOOK"));
		
		String[] search2 = controller.getModelMediaAndTitleLibrary("song", "cat in the hat");
		
		assertTrue(search2.length == 1);

		assertTrue(search2[0].contains("cat in the hat") && search2[0].contains("SONG"));
		
		String[] search3 = controller.getModelMediaAndTitleLibrary("video", "video1");
		
		assertTrue(search3.length == 1);

		assertTrue(search3[0].contains("video1") && search3[0].contains("VIDEO"));
		
		String[] search4 = controller.getModelMediaAndTitleLibrary("video", "video2");
		
		assertTrue(search4.length == 0);
		
		String[] search5 = controller.getModelMediaAndTitleLibrary("videogame", "videogame1");
		
		assertTrue(search5.length == 0);
	}

	
	/**
	 * Test delete item from library and search results.
	 *
	 * @author Karyna Yen
	 */
	@Test
	void test_deleteItemFromLibraryAndSearchResults() {
		PersonalLibraryController controller = new PersonalLibraryController();
		//add media type book 
		controller.addBook("book1", "", "", "", "");
		
		//to store the array in search
		controller.getModelMediaLibrary("book");
		
		//delete book, given type book, no title
		controller.removeModelMedia(0);
		
		//assert that search by media is empty 
		assertTrue(controller.getModelMediaLibrary("book").length == 0);
		
		//assert that search by entire library is empty
		assertTrue(controller.getModelLibrary().length == 0);
		
		//*** next, search by title and check if correct
		
		//add media type book 
		controller.addBook("book1", "", "", "", "");
		
		//stores current array in search my media and title
		controller.getModelMediaAndTitleLibrary("book", "book1");
		
		//delete book, given type book, no title
		controller.removeModelMedia(0);
		
		//assert that search by media is empty 
		assertTrue(controller.getModelMediaAndTitleLibrary("book", "book1").length == 0);
				
		//assert that search by entire library is empty (redundant check)
		assertTrue(controller.getModelLibrary().length == 0);
		
	}
	
	/**
	 * Test delete selected item.
	 *
	 * @author Karyna Yen
	 */
	@Test
	void test_deleteSelectedItem() {
		PersonalLibraryController controller = new PersonalLibraryController();
		controller.addSong("song1", "", "", "", "", "");
		controller.addSong("song2", "", "", "", "", "");
		controller.addSong("song3", "", "", "", "", "");
		controller.addBook("book1", "", "", "", "");
		
		//to store the array in search
		controller.getModelMediaLibrary("song");
		
		//delete selected index, which is 1
		controller.removeModelMedia(1);
		
		//assert that other songs are in search list
		assertTrue(controller.getModelMediaLibrary("song")[0].contains("song1"));
		assertTrue(controller.getModelMediaLibrary("song")[1].contains("song3"));
		
		//assert that other media item is in library too
		assertTrue(controller.getModelLibrary()[0].contains("book1"));	
		assertTrue(controller.getModelLibrary()[1].contains("song1"));
		assertTrue(controller.getModelLibrary()[2].contains("song3"));
		
		
		//now do the same thing but from a search
		controller.addSong("song4", "", "", "", "", "");
		controller.getModelMediaAndTitleLibrary("song", "song3");
		controller.removeModelMedia(0);
		//check that removed from search
		assertTrue(controller.getModelMediaAndTitleLibrary("song", "song3").length == 0);
		
		//check that removed from all songs are still there in song media search
		assertTrue(controller.getModelMediaLibrary("song")[0].contains("song1"));	
		assertTrue(controller.getModelMediaLibrary("song")[1].contains("song4"));	
		
		//check that removed from all songs are still there in media library
		assertTrue(controller.getModelLibrary()[0].contains("book1"));	
		assertTrue(controller.getModelLibrary()[1].contains("song1"));	
		assertTrue(controller.getModelLibrary()[2].contains("song4"));
	}
	
	/**
	 * Test flag when nothing to delete.
	 *
	 * @author Karyna Yen
	 */
	//Flags when there is nothing to delete.
	void test_flagWhenNothingToDelete() {
		//no need to test because this case is never reached
	}
	
}
