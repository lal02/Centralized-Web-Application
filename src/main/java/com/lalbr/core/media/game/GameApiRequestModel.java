package com.lalbr.cwapp.media.game;

public class GameApiRequestModel {

    public String title;
    public String gamestudio;
    public String platform;
    public String gameGenre;
    public String subGenre;
    public Long bookSeriesModel;
    public boolean completed;
    public boolean coop;
    public boolean pvp;
    public boolean released;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGamestudio() {
        return gamestudio;
    }

    public void setGamestudio(String gamestudio) {
        this.gamestudio = gamestudio;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public Long getBookSeriesModel() {
        return bookSeriesModel;
    }

    public void setBookSeriesModel(Long bookSeriesModel) {
        this.bookSeriesModel = bookSeriesModel;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCoop() {
        return coop;
    }

    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    public boolean isPvp() {
        return pvp;
    }

    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public String toString(){
        return "GameApiRequestModel" + "title: " + title +
                " gamestudio: " + gamestudio +
                " platform: " + platform +
                " gameGenre: " + gameGenre +
                " subgenre: " + subGenre +
                " bookseries: " + bookSeriesModel +
                " completed: " + completed +
                " pvp: " + pvp +
                " released: " + released;
    }

}
