package at.ac.fhcampuswien.fhmdb.service;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    //Test-case prüft, ob die Liste nach Anwenden der Funktion sortMovieListAscending aufsteigend (nachTitel) sortiert ist:
    @Test
    void sortMovieListAscending_is_true_if_first_title_is_ant_man() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.sortMovieListAscending(listOfMovies);

        // then
        assertSame("Ant-Man", listOfMovies.get(0).getTitle());
    }

    //Test-case prüft, ob die Liste nach Anwenden der Funktion sortMovieListDescending absteigend (nach Titel) sortiert ist:
    @Test
    void sortMovieListDescending_is_true_if_last_title_is_zwei_glorreiche_halunken() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.sortMovieListDescending(listOfMovies);

        // then
        assertSame("Zwei glorreiche Halunken", listOfMovies.get(0).getTitle());
    }


    @Test
    void sortMovieListAscending_is_true_if_each_title_is_alphabetically_smaller_the_following_one() {
        // given
        List<Movie> listOfMovies;
        boolean eachMovieTitleIsSmallerThanTheFollowingOne = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.sortMovieListAscending(listOfMovies);

        // then
        for (int i = 1; i < listOfMovies.size(); i++){
            if (listOfMovies.get(i).getTitle().compareTo(listOfMovies.get(i-1).getTitle()) < 0 )
                eachMovieTitleIsSmallerThanTheFollowingOne = false;
        }
        assertTrue(eachMovieTitleIsSmallerThanTheFollowingOne);
    }

    @Test
    void sortMovieListDescending_is_true_if_each_title_is_alphabetically_larger_the_following_one() {
        // given
        List<Movie> listOfMovies;
        boolean eachMovieTitleIsLargerThanTheFollowingOne = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.sortMovieListDescending(listOfMovies);

        // then
        for (int i = 1; i < listOfMovies.size(); i++){
            if (listOfMovies.get(i).getTitle().compareTo(listOfMovies.get(i-1).getTitle()) > 0 )
                eachMovieTitleIsLargerThanTheFollowingOne = false;
        }
        assertTrue(eachMovieTitleIsLargerThanTheFollowingOne);
    }


    //Hilfestellung zum Testen von Funktionen, wenn diese "null" zurückgeben:
    //https://stackoverflow.com/questions/49514479/how-to-test-in-j-unit-when-a-method-returns-null
    //abgerufen am 10.03.2023 um 23:10 Uhr
    @Test
    void sortMovieListAscending_returns_null_if_the_passed_list_is_empty() {
        // given
        List<Movie> listOfMovies = new ArrayList<>();

        // when
        listOfMovies = MovieService.sortMovieListAscending(listOfMovies);

        // then
        assertNull(listOfMovies);
    }

    @Test
    void sortMovieListDescending_returns_null_if_the_passed_list_is_empty() {
        // given
        List<Movie> listOfMovies = new ArrayList<>();

        // when
        listOfMovies = MovieService.sortMovieListDescending(listOfMovies);

        // then
        assertNull(listOfMovies);
    }


    @Test
    void searchMovieList_returns_movies_containing_searchterm_in_title_or_description() {
        // search term "meg" was chosen because it is included in a title of one movie and a description of another movie

        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies, "meg");

        // then
        // description contains "meg"
        assertSame("Harry und Sally", listOfMovies.get(0).getTitle());
        // title contains "meg"
        assertSame("Megamind", listOfMovies.get(1).getTitle());
    }

    @Test
    void searchMovieList_searched_list_can_be_sorted() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies, "meg");
        listOfMovies = MovieService.sortMovieListDescending(listOfMovies);

        // then
        assertSame("Megamind", listOfMovies.get(0).getTitle());
        assertSame("Harry und Sally", listOfMovies.get(1).getTitle());
    }

    @Test
    void searchMovieList_search_is_not_case_sensitive() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies, "sieBEN");

        // then
        assertSame("Sieben", listOfMovies.get(0).getTitle());
    }

    @Test
    void filterMovieList_only_shows_films_of_chosen_genre_history() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.HISTORY);

        // then
        assertSame("Im Westen nichts Neues", listOfMovies.get(0).getTitle());
    }

    @Test
    void filterMovieList_only_shows_films_of_chosen_genre_war() {
        // given
        List<Movie> listOfMovies;
        boolean eachFilteredMovieIncludesGenreWar = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.WAR);

        // then
        for (Movie movie : listOfMovies) {
            if(!movie.getGenres().contains(Genre.WAR))
                eachFilteredMovieIncludesGenreWar = false;
        }
        assertTrue(eachFilteredMovieIncludesGenreWar);
    }

    @Test
    void filterMovieList_and_searchMovieList_can_be_used_at_the_same_time() {
        // given
        List<Movie> listOfMovies = new ArrayList<>();

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies, "rocky");
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.SPORT);

        // then
        assertSame("Rocky", listOfMovies.get(0).getTitle());
    }

    @Test
    void filterMovieList_and_searchMovieList_does_not_return_wrong_entries() {
        // given
        List<Movie> listOfMovies;
        boolean eachFilteredMovieMeetsFilterCriteria = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies,"Marvel");
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.SCIENCE_FICTION);

        // then
        for (Movie movie : listOfMovies) {
            if(!movie.getGenres().contains(Genre.SCIENCE_FICTION))
                eachFilteredMovieMeetsFilterCriteria = false;
            if (!movie.getTitle().contains("Marvel") && !movie.getDescription().contains("Marvel"))
                eachFilteredMovieMeetsFilterCriteria = false;
        }
        assertTrue(eachFilteredMovieMeetsFilterCriteria);
    }

    @Test
    void filterMovieList_and_searchMovieList_can_be_used_at_the_same_time_dummy_data_independent () {
        // Test independent from Dummy Data

        // given
        List<Movie> listOfMovies = new ArrayList<>();
        boolean filmContainsGenreAndSearchTerm = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.searchMovieList(listOfMovies, "rocky");
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.SPORT);

        // then
        for (Movie movie : listOfMovies) {
            if (!movie.getGenres().contains(Genre.SPORT))
                filmContainsGenreAndSearchTerm = false;
            if (!movie.getTitle().contains("Rocky") && !movie.getDescription().contains("Rocky"))
                filmContainsGenreAndSearchTerm = false;
        }

        assertTrue(filmContainsGenreAndSearchTerm);
    }

    @Test
    void filterMovieList_only_shows_films_of_chosen_genre_history_dummy_data_independent () {
        // Test independent from Dummy Data

        // given
        List<Movie> listOfMovies = new ArrayList<>();
        boolean filmContainsGenre = true;

        // when
        listOfMovies = Movie.initializeMovies();
        listOfMovies = MovieService.filterMovieList(listOfMovies, Genre.HISTORY);

        // then
        for (Movie movie : listOfMovies) {
            if (!movie.getGenres().contains(Genre.HISTORY))
                filmContainsGenre = false;
        }

        assertTrue(filmContainsGenre);
    }

}