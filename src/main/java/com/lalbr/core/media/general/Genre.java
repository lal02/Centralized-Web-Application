package com.lalbr.core.media.general;

public enum Genre {
    // Aufteilen auf Game Movie Book Genres => mit funktionen zum retrieven

    // book genres
    Fantasy,
    SciFi,
    Krimi,
    Thriller,
    Horror,
    Romantik,
    Biografie,
    Sachbuch,
    Historischer_Roman,


    // game genre
    FPS,
    Platformer,
    OpenWorld,
    RPG,
    Survival,
    Simulation,
    Strategy,
    //Horror,
    Sandbox,
    MMO,
    PartyGame,


    //movie genre
    Comedy,
    Action,
    Abenteuer,
    //Horror,
    //Thriller,
    //SciFi,
    //Fantasy,
    //Krimi,
    Dokumentation,
    Drama;




    public Genre[] getBookGenres(){
        return new Genre[]{
                Fantasy,
                SciFi,
                Krimi,
                Thriller,
                Horror,
                Romantik,
                Abenteuer,
                Biografie,
                Sachbuch,
                Historischer_Roman
        };
    }

    public Genre[] getGameGenres(){
        return new Genre[]{
                FPS,
                Platformer,
                OpenWorld,
                RPG,
                Survival,
                Simulation,
                Strategy,
                Horror,
                Sandbox,
                MMO,
                PartyGame,
        };
    }

    public Genre[] getMovieGenres(){
        return new Genre[]{
                Comedy,
                Action,
                Abenteuer,
                Horror,
                Thriller,
                SciFi,
                Fantasy,
                Krimi,
                Dokumentation,
                Drama
        };
    }
    
    public static String toString(Genre genre){
        return switch (genre) {
            case Fantasy -> "Fantasy";
            case SciFi -> "SciFi";
            case Krimi -> "Krimi";
            case Thriller -> "Thriller";
            case Horror -> "Horror";
            case Romantik -> "Romantik";
            case Biografie -> "Biografie";
            case Sachbuch -> "Sachbuch";
            case Historischer_Roman -> "Historischer Roman";
            case FPS -> "FPS";
            case Platformer -> "Platformer";
            case OpenWorld -> "Open World";
            case RPG -> "RPG";
            case Survival -> "Survival";
            case Simulation -> "Simulation";
            case Strategy -> "Strategy";
            case Sandbox -> "Sandbox";
            case MMO -> "MMO";
            case PartyGame -> "Party Game";
            case Comedy -> "Comedy";
            case Action -> "Action";
            case Abenteuer -> "Abenteuer";
            case Dokumentation -> "Dokumentation";
            case Drama -> "Drama";
        };
    }
}
