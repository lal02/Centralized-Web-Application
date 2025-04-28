package com.lalbr.core.media.movie;

public class MovieApiRequestModel {

    private String title;
    private String platform;
    private String movieType;
    private String genre;
    private String subGenre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public String toString(){
        return "MovieApiRequestModel" + "title: " + title +
                " platform: " + platform +
                " genre: " + genre +
                " subGenre: " + subGenre;
    }
}
