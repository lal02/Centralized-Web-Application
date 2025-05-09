package com.lalbr.cwapp.media.movie;

import com.lalbr.cwapp.media.general.Genre;
import com.lalbr.cwapp.media.general.Platform;
import com.lalbr.cwapp.media.general.SubGenre;
import jakarta.persistence.*;

@Entity
@Table(name = "media_movie")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name="movie_title")
    private String title;

    @Column(name="movie_platform")
    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Column(name="movie_type")
    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @Column(name="movie_genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name="movie_subgenre")
    @Enumerated(EnumType.STRING)
    private SubGenre subGenre;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public SubGenre getSubgenre() {
        return subGenre;
    }

    public void setSubgenre(SubGenre subgenre) {
        this.subGenre = subgenre;
    }

    public String toString(){
        return "MovieModel" + "id: " + id +
                " title: " + title +
                " platform: " + platform +
                " genre: " + genre +
                " subGenre: " + subGenre;
    }
}
