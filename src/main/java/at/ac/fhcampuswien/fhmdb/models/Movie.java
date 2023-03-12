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

    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();

        //Adding Dummy-Data - Filmklassiker (Auszüge davon) übernommen von:
        //https://www.moviepilot.de/filme/beste/schlagwort-klassiker abgerufen am 04.03.2023 um 22:15 Uhr

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

        // added dummy data so all genres are used at least once
        // https://www.moviepilot.de/filme/beste abgerufen am 11.3. um 12:02
        // https://de.wikipedia.org/wiki/Ant-Man_(Film) abgerufen am 11.3. um 12:51
        // https://de.wikipedia.org/wiki/Guardians_of_the_Galaxy abgerufen am 11.3. um 12:52

        Movie chihiroZauberland = new Movie("Chihiros Reise ins Zauberland", "Anime von Hayao Miyazaki mit Lauren Holly und David Ogden Stiers. ", Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.FANTASY));
        movies.add(chihiroZauberland);
        Movie koenigLoewen = new Movie("Der König der Löwen", "Animationsfilm von Roger Allers und Rob Minkoff mit Jonathan Taylor Thomas und Matthew Broderick.", Arrays.asList(Genre.ANIMATION, Genre.FAMILY));
        movies.add(koenigLoewen);
        Movie prinzessinMononoke = new Movie("Prinzessin Mononoke", "Anime von Hayao Miyazaki mit Yuriko Ishida und Yôji Matsuda. ", Arrays.asList(Genre.ADVENTURE, Genre.ANIMATION, Genre.FANTASY));
        movies.add(prinzessinMononoke);
        Movie schumacher = new Movie("Schumacher", "Biographischer Dokumentarfilm von Hans-Bruno Kammertöns und Michael Wech mit Michael Schumacher.", Arrays.asList(Genre.BIOGRAPHY, Genre.DOCUMENTARY));
        movies.add(schumacher);
        Movie steveJobs = new Movie("Steve Jobs", "Biographischer Dokumentarfilm von Alex Gibney mit Steve Jobs. ", Arrays.asList(Genre.BIOGRAPHY, Genre.DOCUMENTARY));
        movies.add(steveJobs);
        Movie rocky = new Movie("Rocky", "Sozialdrama von John G. Avildsen mit Sylvester Stallone und Talia Shire. ", Arrays.asList(Genre.SPORT));
        movies.add(rocky);
        Movie tonya = new Movie("I, Tonya", "Sportfilm von Craig Gillespie mit Margot Robbie und Sebastian Stan. ", Arrays.asList(Genre.BIOGRAPHY, Genre.SPORT));
        movies.add(tonya);
        Movie voegel = new Movie("Die Vögel", "Tierhorrorfilm von Alfred Hitchcock mit Tippi Hedren und Rod Taylor.", Arrays.asList(Genre.HORROR));
        movies.add(voegel);
        Movie liedTod = new Movie("Spiel mir das Lied vom Tod", "Italowestern von Sergio Leone mit Charles Bronson und Henry Fonda.", Arrays.asList(Genre.WESTERN));
        movies.add(liedTod);
        Movie harrySally = new Movie("Harry und Sally", "Romantische Komödie von Rob Reiner mit Meg Ryan und Bruno Kirby. ", Arrays.asList(Genre.COMEDY, Genre.ROMANCE));
        movies.add(harrySally);
        Movie rockyHorror = new Movie("The Rocky Horror Picture Show", "Horrorfilm von Jim Sharman mit Susan Sarandon und Barry Bostwick. ", Arrays.asList(Genre.HORROR, Genre.MUSICAL));
        movies.add(rockyHorror);
        Movie antMan = new Movie("Ant-Man", "US-amerikanischer Science-Fiction-Actionfilm rund um die Marvel-Figur Ant-Man.", Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION));
        movies.add(antMan);
        Movie guardians = new Movie("Guardians of the Galaxy", "US-amerikanischer Science-Fiction-Actionfilm. Verfilmung eines gleichnamigen Comics des Verlages Marvel.", Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION));
        movies.add(guardians);
        Movie westen = new Movie("Im Westen nichts Neues", "Anti-Kriegsfilm von Lewis Milestone mit Louis Wolheim und Lew Ayres. ", Arrays.asList(Genre.WAR, Genre.HISTORY));
        movies.add(westen);
        Movie megamind = new Movie("Megamind", "CGI-Animationsfilm von DreamWorks Animation.", Arrays.asList(Genre.ANIMATION, Genre.FAMILY));
        movies.add(megamind);

        return movies;
    }
}