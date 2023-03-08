package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String title;
    private final String description;
    private final List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public List<Genre> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        //Adding Dummy-Data - Filmklassiker (Auszüge davon) übernommen von:
        //https://www.moviepilot.de/filme/beste/schlagwort-klassiker abgerufen am 04.03.2023 um 22:15 Uhr

        //Guys: feel free to add / lmk if you want more movies :)
        //Genres sind free-style da nicht immer 100% passend mit Angabe.

        Movie pate = new Movie("Der Pate", "Mafiafilm von Francis Ford Coppola mit Marlon Brando und Al Pacino.", Arrays.asList(Genre.CRIME, Genre.ACTION));
        movies.add(pate);
        Movie verurteilten = new Movie("Die Verurteilten", "Gerechtigkeitsdrama von Frank Darabont mit Tim Robbins und Morgan Freeman.", Arrays.asList(Genre.ACTION));
        movies.add(verurteilten);
        Movie geschworenen = new Movie("Die zwölf Geschworenen", "Gerichtsdrama von Sidney Lumet mit Henry Fonda und Joseph Sweeney.", Arrays.asList(Genre.DOCUMENTARY));
        movies.add(geschworenen);
        Movie sieben = new Movie("Sieben", "Serienkiller-Film von David Fincher mit Brad Pitt und Morgan Freeman.", Arrays.asList(Genre.CRIME, Genre.ACTION, Genre.THRILLER));
        movies.add(sieben);
        Movie psycho = new Movie("Psycho", "Psychothriller von Alfred Hitchcock mit Anthony Perkins und Janet Leigh", Arrays.asList(Genre.THRILLER, Genre.CRIME));
        movies.add(psycho);
        Movie ringe = new Movie("Der Herr der Ringe: Die Rückkehr des Königs", "Fantasyfilm von Peter Jackson mit Elijah Wood und Viggo Mortensen.", Arrays.asList(Genre.FANTASY));
        movies.add(ringe);
        Movie leon = new Movie("Léon - der Profi", "Drama von Luc Besson mit Jean Reno und Natalie Portman.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE));
        movies.add(leon);
        Movie ringe2 = new Movie("Der Herr der Ringe: Die zwei Türme", "Fantasyfilm von Peter Jackson mit Elijah Wood und Ian McKellen.", Arrays.asList(Genre.FANTASY));
        movies.add(ringe2);
        Movie stirb = new Movie("Stirb langsam", "Actionfilm von John McTiernan mit Bruce Willis und Alan Rickman.", Arrays.asList(Genre.ACTION));
        movies.add(stirb);
        Movie halunken = new Movie("Zwei glorreiche Halunken", "Italowestern von Sergio Leone mit Clint Eastwood und Eli Wallach.", Arrays.asList(Genre.WESTERN, Genre.WAR));
        movies.add(halunken);

        return movies;
    }
}