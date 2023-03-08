package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void dummyData_movies_will_be_added_to_a_list_if_true() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();

        // then
        assertFalse(listOfMovies.isEmpty());
    }

    @Test
    void dummyDataList_is_not_sorted_by_title() {
        // given
        List<Movie> listOfMovies;

        // when
        listOfMovies = Movie.initializeMovies();

        // then
        assertTrue(listOfMovies.get(0).getTitle() == "Der Pate");
    }
}