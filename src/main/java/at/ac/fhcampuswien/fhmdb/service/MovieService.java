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
    public static void sortMovieListAscending(List<Movie> movies) {
        List<Movie> sortedListAscending = new ArrayList<>(Movie.initializeMovies());

        sortedListAscending.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());

        sortedListAscending.forEach(System.out::println);

        //sortedListAscending.stream().sorted().collect(Collectors.toList());

        //sortedListAscending.stream().sorted(Comparator.comparing(Movie::getGenre));

        //sortedListAscending.forEach(System.out::println);

        //List<Movie> sortedListAscending = movies.stream()
        //.sorted(Comparator.comparing(Movie::getTitle))
        //.collect(Collectors.toList());

        //sortedListAscending.forEach(System.out::println);
    }

    public static void sortMovieListDecending(List<Movie> movies) {
        List<Movie> sortedListDecending = new ArrayList<>(Movie.initializeMovies());

        sortedListDecending.stream()
                .sorted(Comparator.comparing(Movie::getTitle)
                        .reversed())
                .collect(Collectors.toList());

        sortedListDecending.forEach(System.out::println);
    }
}
