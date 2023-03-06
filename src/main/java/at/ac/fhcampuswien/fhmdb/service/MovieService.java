package at.ac.fhcampuswien.fhmdb.service;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    //Hilfestellung zu folgenden Methoden: https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
    //abgerufen am 05.03.2023 um 00:53 Uhr.
    public static List<Movie> sortMovieListAscending(List<Movie> movies) {

        List<Movie> sortedListAscending = movies.stream()
            .sorted(Comparator.comparing(Movie::getTitle))
            .collect(Collectors.toList());

        return sortedListAscending;
    }

    public static List<Movie> sortMovieListDescending(List<Movie> movies) {

        List<Movie> sortedListDescending = movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .collect(Collectors.toList());

        return sortedListDescending;
    }
}
