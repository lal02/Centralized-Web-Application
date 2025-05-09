package com.lalbr.cwapp.media.game;

import com.lalbr.cwapp.media.general.Genre;
import com.lalbr.cwapp.media.general.Platform;
import com.lalbr.cwapp.media.general.SubGenre;
import com.lalbr.cwapp.media.bookseries.BookSeriesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "media_game")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Column(name="game_title")
    private String title;

    @Column(name = "game_gamestudio")
    private String gamestudio;

    @Column(name ="game_platform")
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column(name ="game_genre")
    @Enumerated(EnumType.STRING)
    private Genre gameGenre;

    @Column(name ="game_subgenre")
    @Enumerated(EnumType.STRING)
    private SubGenre gameSubGenre;

    // part of bookseries universe
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_bookseries")
    private BookSeriesModel bookSeriesModel;

    @Column(name ="game_completed")
    private boolean completed;

    @Column(name="game_coop")
    private boolean coop;

    @Column(name ="game_pvp")
    private boolean pvp;

    @Column(name ="game_released")
    private boolean released;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getGamestudio() {
        return gamestudio;
    }

    public void setGamestudio(String gamestudio) {
        this.gamestudio = gamestudio;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Genre getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(Genre gameGenre) {
        this.gameGenre = gameGenre;
    }

    public SubGenre getGameSubGenre() {
        return gameSubGenre;
    }

    public void setGameSubGenre(SubGenre gameSubGenre) {
        this.gameSubGenre = gameSubGenre;
    }

    public BookSeriesModel getBookSeriesModel() {
        return bookSeriesModel;
    }

    public void setBookSeriesModel(BookSeriesModel bookSeriesModel) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBooleanAsString(boolean val){
        if(val){
            return "ja";
        }
        return "nein";
    }

    public String toString(){
        return "GameModel" + "id: " + id +
                "title: " + title +
                " gamestudio: " + gamestudio +
                " platform: " + platform +
                " gameGenre: " + gameGenre +
                " subgenre: " + gameSubGenre +
                " bookseries: " + bookSeriesModel +
                " completed: " + completed +
                " pvp: " + pvp +
                " released: " + released;
    }
}
