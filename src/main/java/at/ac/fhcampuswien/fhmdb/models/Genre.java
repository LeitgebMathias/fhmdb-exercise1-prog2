package at.ac.fhcampuswien.fhmdb.models;

//Genre Class: Erzeugung der lt. Angabe geforderten Genres, damit in der Klasse movie jeweils mind. 1 Genre pro Film
//zugeordnet werden kann:
public class Genre {
    //Genres haben genau einen String: name.
    private String name;

    private Genre(String name) {
        this.name = name;
    }
    //Die verschiedenen Genres lt. Angabe:
    public static final Genre ACTION = new Genre("ACTION");
    public static final Genre ADVENTURE = new Genre("ADVENTURE");
    public static final Genre ANIMATION = new Genre("ANIMAITON");
    public static final Genre BIOGRAPHY = new Genre("BIOGRAPHY");
    public static final Genre COMEDY = new Genre("COMEDY");
    public static final Genre CRIME = new Genre("CRIME");
    public static final Genre DOCUMENTARY = new Genre("DOCUMENTARY");
    public static final Genre FAMILY = new Genre("FAMILY");
    public static final Genre FANTASY = new Genre("FANTASY");
    public static final Genre HISTORY = new Genre("HISTORY");
    public static final Genre HORROR = new Genre("HORROR");
    public static final Genre MUSICAL = new Genre("MUSICAL");
    public static final Genre MYSTERY = new Genre("MYSTERY");
    public static final Genre ROMANCE = new Genre("ROMANCE");
    public static final Genre SCIENCE_FICTION = new Genre("SCIENCE_FICTION");
    public static final Genre SPORT = new Genre("SPORT");
    public static final Genre THRILLER = new Genre("THRILLER");
    public static final Genre WAR = new Genre("WAR");
    public static final Genre WESTERN = new Genre("WESTERN");


    public String getName() {
        return name;
    }
}
