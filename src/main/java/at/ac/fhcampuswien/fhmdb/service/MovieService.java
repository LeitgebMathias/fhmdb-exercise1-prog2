package at.ac.fhcampuswien.fhmdb.service;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movieList = new ArrayList() {
    };

    //Hilfestellung zu folgenden Methoden: https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
    //abgerufen am 05.03.2023 um 00:53 Uhr.
    public static List<Movie> sortMovieListAscending(List<Movie> movies) {
        List<Movie> movieArrayList = new ArrayList<>(Movie.initializeMovies());

        List<Movie> sortedListAscending = movieArrayList.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());

        for (Movie movie : sortedListAscending) {
            System.out.println(movie.getTitle());
    }
    return sortedListAscending;
}

    public static List<Movie> sortMovieListDecending(List<Movie> movies) {
        List<Movie> movieArrayList = new ArrayList<>(Movie.initializeMovies());

        List<Movie> sortedListDecending = movieArrayList.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .collect(Collectors.toList());

        for (Movie movie : sortedListDecending) {
            System.out.println(movie.getTitle());
        }
        return sortedListDecending;
    }
}
