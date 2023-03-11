package at.ac.fhcampuswien.fhmdb.service;

import static org.junit.jupiter.api.Assertions.*;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Assert.assertNull(listOfMovies);
    }

    @Test
    void sortMovieListDescending_returns_null_if_the_passed_list_is_empty() {
        // given
        List<Movie> listOfMovies = new ArrayList<>();

        // when
        listOfMovies = MovieService.sortMovieListDescending(listOfMovies);

        // then
        Assert.assertNull(listOfMovies);
    }

    // TODO add Test for Search Term Title *and* Description

    // TODO add Test for Genre Filter

}