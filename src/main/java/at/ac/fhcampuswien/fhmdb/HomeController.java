package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.service.MovieService;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    boolean filterHasChangedSinceLastSearch = true;
    boolean listIsCurrentlyFiltered = false;

    public List<Movie> allMovies = Movie.initializeMovies();

    // Zusätzliche Liste, in der alle Filme enthalten sind, die allen aktuellen Filterkriterien entsprechen.
    // Wenn keine Filter gesetzt sind, ist die Liste gleich "allMovies".
    // Hier wird explizit eine zusätzliche Liste erstellt
    public List<Movie> filteredMovies = new ArrayList<> (allMovies);

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values());

        // Ein Listener, welcher reagiert, wenn sich der Text im Text-field ändert.
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Diese Abfrage ist wichtig, da es nicht gewünscht ist, dass das ausgeführt wird,
            // wenn das Text-field gerade geleert wurde.
                filterHasChangedSinceLastSearch = true;
                searchBtn.setText("Filter");
        });

        // Ein Listener, welcher reagiert, wenn sich die Auswahl in der ComboBox ändert.
        genreComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Diese Abfrage ist wichtig, da es nicht gewünscht ist, dass das ausgeführt wird,
            // wenn der Filter gerade geleert wurde.
                filterHasChangedSinceLastSearch = true;
                searchBtn.setText("Filter");
        });

        // Passiert, sobald der Sort Button gedrückt wird.
        sortBtn.setOnAction(actionEvent -> {
            if (!filteredMovies.isEmpty()) {
                if (sortBtn.getText().equals("Sort (asc)")) {

                    observableMovies.clear();
                    filteredMovies = MovieService.sortMovieListAscending(filteredMovies);
                    observableMovies.addAll(filteredMovies);

                    sortBtn.setText("Sort (desc)");

                } else {

                    observableMovies.clear();
                    filteredMovies = MovieService.sortMovieListDescending(filteredMovies);
                    observableMovies.addAll(filteredMovies);

                    sortBtn.setText("Sort (asc)");
                }
            }
        });

        searchBtn.setOnAction(actionEvent -> {
            // Wenn keine Filterkriterien eingetragen sind, wird das Filtern übersprungen.
            if (!searchField.getText().equals("") || genreComboBox.getValue() != null){
                // Wenn die Filterkriterien seit der letzten Suche geändert wurden, dann soll neu gesucht werden.
                if (filterHasChangedSinceLastSearch) {
                    observableMovies.clear();
                    filteredMovies = new ArrayList<>(allMovies);

                    // This is filtering
                    if (!searchField.getText().equals("")) {
                        filteredMovies = MovieService.searchMovieList(filteredMovies, searchField.getText());
                    }
                    if (!filteredMovies.isEmpty()) {
                        if (genreComboBox.getValue() != null) {
                            filteredMovies = MovieService.filterMovieList(filteredMovies, (Genre) genreComboBox.getValue());
                        }
                    }
                    observableMovies.addAll(filteredMovies);

                    searchBtn.setText("Reset");
                    filterHasChangedSinceLastSearch = false;
                    listIsCurrentlyFiltered = true;

                } else {
                    // Wenn die Filterkriterien seit der letzten Suche NICHT geändert wurden,
                    // dann soll die Suche zurückgesetzt werden.
                    if (listIsCurrentlyFiltered){
                        searchField.setText("");
                        genreComboBox.setValue(null);
                        observableMovies.clear();
                        filteredMovies = new ArrayList<> (allMovies);
                        observableMovies.addAll(allMovies);
                        searchBtn.setText("Filter");
                        listIsCurrentlyFiltered = false;
                    }
                }
            } else {
                // Wenn keine Filterkriterien eingetragen sind, wird die Liste nur neu geladen,
                // wenn sie gerade gefiltert ist.
                // Wenn die Liste gerade sowieso ungefiltert ist, dann braucht sie nicht neu geladen werden.
                if (listIsCurrentlyFiltered) {
                    observableMovies.clear();
                    filteredMovies = new ArrayList<>(allMovies);
                    observableMovies.addAll(allMovies);
                    searchBtn.setText("Filter");
                    listIsCurrentlyFiltered = false;
                }
            }


        });
    }
}