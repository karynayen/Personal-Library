
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalLibraryGUI.
 * 
 *  @author Karyna Yen
 *  
 
 */
public class PersonalLibraryGUI extends Application {
	
	/** The main. */
	private BorderPane main = new BorderPane();	
	
	/** The media heading. */
	private GridPane mediaHeading = new GridPane();
	
	/** The media bottom. */
	private GridPane mediaBottom = new GridPane();
	
	/** The media data. */ 
    private BorderPane mediaData = new BorderPane();
    
    /** The form. */
    private GridPane form = new GridPane(); 
    
    /** The tg. */
    private ToggleGroup tg; 
    
    /** The selected media. */
    private String selectedMedia; 
    
    /** The media type. */
    private String mediaType = "all"; //for db
    
    /** The search type. */
    private String searchType = ""; 
    
    /** The controller. */
    private PersonalLibraryController controller; 
    
    /** The tf title. */
    private TextField tfTitle = new TextField();
	
	/** The tf format. */
	private TextField tfFormat = new TextField();
	
	/** The tf location. */
	private TextField tfLocation = new TextField();
	
	/** The tf notes. */
	private TextField tfNotes = new TextField();
	
	/** The tf author. */
	private TextField tfAuthor = new TextField();
	
	/** The tf artist. */
	private TextField tfArtist = new TextField();
	
	/** The tf genre. */
	private TextField tfGenre = new TextField();
	
	/** The tf star. */
	private TextField tfStar = new TextField();
	
	/** The Constant DEFAULT_TEXT. */
	private static final String DEFAULT_TEXT = "search library by title or leave empty to search everything";

	/** The lv. */
	private ListView<String> lv;
	
	/** The delete. */
	private Button delete;
	
	/** The search. */
	private TextField search;
	
	/** The search results. */
	private Label searchResults = new Label("showing entire library"); 

	/**
	 * Instantiates a new personal library GUI.
	 */
	public PersonalLibraryGUI() {
		// TODO Auto-generated constructor stub
		controller = new PersonalLibraryController();
	}

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene entryScene = new Scene(main,400,500);
    	Scene libraryScene = new Scene(mediaData,400,500);
    	
    	main.setLeft(new Label("      ")); //padding left
    	main.setTop(mediaHeading);
    	main.setBottom(mediaBottom);
    	
    	//*** MEDIA HEADING SET UP
    	Label dataEntryTitle = new Label ("  Personal Library Data Entry"); 
    	
    	dataEntryTitle.setFont(new Font("Comic Sans MS", 20));
    	
    	mediaHeading.add(dataEntryTitle, 0, 0);
    	
    	//Radio Button Set Up
    	RadioButton book = new RadioButton("Book"); 
		RadioButton song = new RadioButton("Song"); 
		RadioButton video = new RadioButton("Video"); 
		RadioButton videoGame = new RadioButton("Video Game");
		
		VBox radioBox = new VBox(5); 
		radioBox.setPadding(new Insets(5));  
		radioBox.setAlignment(Pos.BASELINE_LEFT);
		
		mediaHeading.add(radioBox,0,1);
		radioBox.getChildren().addAll(book, song, video, videoGame); 
		
		mediaHeading.add(new Label(" "), 0,2); //extra space
		tg = new ToggleGroup(); 
		book.setToggleGroup(tg); 
		song.setToggleGroup(tg);
		video.setToggleGroup(tg);
		videoGame.setToggleGroup(tg);
		
		//default set center as the book Pane
		book.setSelected(true);
		
		///TESTING 
		setBasicForm();
		setBookForm();
		main.setCenter(form);
		
		book.setOnAction(e -> main.setCenter(setBookForm()));
		song.setOnAction(e -> main.setCenter(setSongForm()));
		video.setOnAction(e -> main.setCenter(setVideoForm()));
		videoGame.setOnAction(e -> main.setCenter(setVideoGameForm()));
		
		//SET UP BUTTONS AT THE BOTTOM OF THE SCREEN
		Button addMedia = new Button("Add Media");
		Button viewLibrary = new Button("View Library");
		
		mediaBottom.setHgap(5);
		mediaBottom.add(addMedia, 0,0);
		mediaBottom.add(viewLibrary, 1, 0);
		
		addMedia.setOnAction(e-> guiAddMedia());
		
		//LIBRARY SCENE SET UP
		
		
		GridPane libraryTop = new GridPane();
		GridPane libraryBottom = new GridPane(); 
		
		mediaData.setTop(libraryTop); 
		mediaData.setBottom(libraryBottom);
		
		//Back and delete buttons
		Button back = new Button ("Back");
		delete = new Button ("Delete"); //MAYBE BRAINSTORM ANOTHER WAY TO DELETE THINGS
		libraryBottom.add(back, 0,0); 
		libraryBottom.add(delete, 1,0); 
		
		back.setOnAction(e -> primaryStage.setScene(entryScene));
		delete.setOnAction(e -> guiDeleteMedia());
		
		// DB title
		Label libraryDataTitle = new Label ("  Personal Library Data");
		libraryTop.add(libraryDataTitle, 0, 0);
		libraryDataTitle.setFont(new Font("Comic Sans MS", 20));
		
		libraryTop.add(new Label(" "), 0,1); //extra space
    	
		HBox searchBar = new HBox(3); 
		libraryTop.add(searchBar, 0, 2);
		
		search = new TextField();
		search.setPrefWidth(345); 
		
		searchBar.getChildren().addAll(new Label("  Search"), search);
		
		search.setOnMouseClicked(e -> search.selectAll());
	
		search.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
		    if (isNowFocused && DEFAULT_TEXT.equals(search.getText())) {
		        search.selectAll();
		    }
		});
		
		search.setPromptText(DEFAULT_TEXT);
		
		libraryTop.add(new Label(" "), 0,3); //extra space
		
		RadioButton allData = new RadioButton("All"); 
	  	RadioButton bookData = new RadioButton("Book"); 
		RadioButton songData = new RadioButton("Song"); 
		RadioButton videoData = new RadioButton("Video"); 
		RadioButton videoGameData = new RadioButton("Video Game");
			
		HBox radioBox2 = new HBox(5); 
		radioBox2.setPadding(new Insets(5));  
		radioBox2.setAlignment(Pos.BASELINE_LEFT);
		
		libraryTop.add(radioBox2,0,4);
		radioBox2.getChildren().addAll(new Label ("Filter   "), allData, bookData, songData, videoData, videoGameData); 
		
		ToggleGroup tg2 = new ToggleGroup();
		allData.setToggleGroup(tg2); 
		bookData.setToggleGroup(tg2); 
		songData.setToggleGroup(tg2);
		videoData.setToggleGroup(tg2);
		videoGameData.setToggleGroup(tg2);
	
		allData.setOnAction(e -> {
			mediaType  = "all";
			delete.setVisible(false); 
		});
		bookData.setOnAction(e -> {
			mediaType  = "book";
		});
		songData.setOnAction(e -> {
			mediaType  = "song";
		});
		videoData.setOnAction(e -> {
			mediaType  = "video";
		});
		videoGameData.setOnAction(e -> {
			mediaType  = "videoGame";
		});
		
		
		Button go = new Button("     Go     ");
		Button reset = new Button("  Reset  ");
		
		go.setStyle("-fx-background-color: #0364fc; -fx-text-fill: #ffffff;");
		go.setOnAction(e -> {
			searchType = search.getText(); 
			searchResults.setText("   Results for " + searchType + " type " + mediaType);
			viewLibrary();
		}); 
		
		reset.setOnAction(e -> {
			mediaType = "all";
			allData.setSelected(true);
			search.clear();
		}); 
		
		HBox goBar = new HBox(3); 
		goBar.setAlignment(Pos.BASELINE_RIGHT);
		goBar.getChildren().addAll(reset, go);
		libraryTop.add(goBar, 0, 5);
		
		libraryTop.add(new Label(" "), 0,6); //extra space
		
		//previous searchResults
		searchResults.setTextFill(Color.GREY);
		libraryTop.add(searchResults, 0,7);
		
		//VIEW LIBRARY BTN SET UP: 
		viewLibrary.setOnAction(e -> {
			allData.setSelected(true);
			mediaType = "all";
			search.setText("");
			viewLibrary();
			
			delete.setVisible(false); 
			primaryStage.setScene(libraryScene);
			searchResults.setText("   showing entire library");
		});
		
		
    	primaryStage.setTitle("Personal Library"); // Set the stage title
        primaryStage.setScene(entryScene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

	}
	
	/**
	 * Gui add media.
	 */
	public void guiAddMedia() {
		String message = ""; 
		if(selectedMedia.equals("book")) {
			message = controller.addBook(
					 tfTitle.getText(),
					 tfFormat.getText(),
					 tfLocation.getText(),
					 tfNotes.getText(),
					 tfAuthor.getText());
		}
		else if(selectedMedia.equals("song")) {
			message = controller.addSong(
					 tfTitle.getText(),
					 tfFormat.getText(),
					 tfLocation.getText(),
					 tfNotes.getText(),
					 tfArtist.getText(),
					 tfGenre.getText());
		}
		else if(selectedMedia.equals("video")) {
			message = controller.addVideo(
					tfTitle.getText(),
					tfFormat.getText(),
					tfLocation.getText(),
					tfNotes.getText(),
					tfStar.getText());
		}else if(selectedMedia.equals("videoGame")) {
			message = controller.addVideoGame(
					tfTitle.getText(),
					tfFormat.getText(),
					tfLocation.getText(),
					tfNotes.getText());
		}
		if (! message.isEmpty()) {
    		// something is blank
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setHeaderText("Add Media Failed!");
    		alert.setContentText(message);
    		alert.showAndWait();
    	} else {
    		clearTextFields();
    	}
	}
	
	/**
	 * Clear text fields.
	 */
	public void clearTextFields() {
		tfTitle.clear();
		tfFormat.clear();
		tfLocation.clear();
		tfNotes.clear();
		tfAuthor.clear();
		tfArtist.clear();
		tfGenre.clear();
		tfStar.clear();
	}
	
	/**
	 * Gui delete media.
	 */
	//Future use case
	private void guiDeleteMedia() {
		
		if(lv.getSelectionModel().getSelectedItems().size() > 0) { // the button only works if you have sele
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("You are about to delete something");
			alert.setContentText("Are you sure about this? You information will be permanently deleted");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				controller.removeModelMedia(lv.getSelectionModel().getSelectedIndex());
			
			} else {
				alert.close();
			}
			viewLibrary(); 
			//reset
		}
		
	}
	/**
	 * View library.
	 */
	private void viewLibrary() {
		String[] arr = new String[0]; 
		String str; 
		if (search.getText().trim().isEmpty()) {
			if(mediaType.equals("all")){
				arr = controller.getModelLibrary();	
				if(arr.length <= 0) {
					arr = new String[] {"nothing to see here, add more data or search for something else!"};
					lv = new ListView<>(FXCollections.observableArrayList(arr));
					delete.setVisible(false);
					lv.setPrefWidth(380); 
			    	mediaData.setCenter(new ScrollPane(lv));
					return;
				}else {
					arr = controller.getModelLibrary();
					lv = new ListView<>(FXCollections.observableArrayList(arr));
					delete.setVisible(false);
					lv.setPrefWidth(380); 
			    	mediaData.setCenter(new ScrollPane(lv));
					return;
				}
				
			}else { 
				arr = controller.getModelMediaLibrary(mediaType);
			}
		}
		else {
			str = search.getText();
			if(mediaType.equals("all")){
				arr = controller.getModelTitleLibrary(str);	
			}else {
				arr = controller.getModelMediaAndTitleLibrary(mediaType, str);
			} 
		}
		
		if(arr.length <= 0) {
			arr = new String[] {"nothing to see here, add more data or search for something else!"};
			lv = new ListView<>(FXCollections.observableArrayList(arr));
			delete.setVisible(false);
		}else if (!mediaType.equals("all")) {
			lv = new ListView<>(FXCollections.observableArrayList(arr));
			lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			delete.setVisible(true);
		}else {
			lv = new ListView<>(FXCollections.observableArrayList(arr));
			delete.setVisible(true); 
		}

    	lv.setPrefWidth(380); 
    	mediaData.setCenter(new ScrollPane(lv));
	}
	
	/**
	 * Sets the basic form.
	 *
	 * @return the grid pane
	 */
	public GridPane setBasicForm() {
		form = new GridPane(); 
	
		form.setHgap(5);
		form.setVgap(5);
		
		Label lblTitle= new Label("Title: ");
    	Label lblFormat = new Label("Format: ");
    	Label lblLocation = new Label("Location: ");
    	Label lblNotes = new Label("Notes: ");
    	
    	tfTitle = new TextField();
		tfFormat = new TextField();
		tfLocation = new TextField();
		tfNotes = new TextField();

		form.add(lblTitle,0, 0);
    	form.add(lblFormat,0,1);
        form.add(lblLocation,0, 2);
        form.add(lblNotes,0, 3);
        
        form.add(tfTitle,1, 0);
    	form.add(tfFormat,1,1);
        form.add(tfLocation,1, 2);
        form.add(tfNotes,1, 3);
        
        return form; 
	}

	/**
	 * Sets the book form.
	 *
	 * @return the grid pane
	 */
	public GridPane setBookForm() { 
		while(form.getChildren().size() > 8) {
			form.getChildren().remove(form.getChildren().size()-1);
		}
		
		selectedMedia = "book";
    	Label lblAuthor = new Label("Author: ");
		tfAuthor = new TextField();
		form.add(lblAuthor,0, 4);
        form.add(tfAuthor,1, 4);
        return form;
  	}
	
	/**
	 * Sets the song form.
	 *
	 * @return the grid pane
	 */
	public GridPane setSongForm() {
		while(form.getChildren().size() > 8) {
			form.getChildren().remove(form.getChildren().size()-1);
		}
		selectedMedia = "song";
    	Label lblArtist = new Label("Artist: ");
    	Label lblGenre = new Label("Genre: ");
 
		tfArtist = new TextField();
		tfGenre = new TextField();

        form.add(lblArtist,0, 4);
        form.add(lblGenre,0, 5);
 
        form.add(tfArtist,1, 4);
        form.add(tfGenre,1, 5);
        
		return form; 
	}
	
	/**
	 * Sets the video form.
	 *
	 * @return the grid pane
	 */
	public GridPane setVideoForm() {
		while(form.getChildren().size() > 8) {
			form.getChildren().remove(form.getChildren().size()-1);
		}
		selectedMedia = "video";
    	Label lblStar = new Label("Star: ");
		tfStar = new TextField();
        form.add(lblStar,0, 4);
        form.add(tfStar,1, 4);

        return form; 
	}
	
	/**
	 * Sets the video game form.
	 *
	 * @return the grid pane
	 */
	public GridPane setVideoGameForm() {
		while(form.getChildren().size() > 8) {
			form.getChildren().remove(form.getChildren().size()-1);
		}
		selectedMedia = "videoGame";
        return form; 
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
