package com.lalbr.cwapp.media.bookseries;

import com.lalbr.cwapp.media.general.Genre;
import com.lalbr.cwapp.media.general.SubGenre;
import jakarta.persistence.*;

@Entity
@Table(name = "media_bookseries")
public class BookSeriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookseries_id")
    private long id;

    @Column(name = "bookseries_title")
    private String title;

    @Column(name ="bookseries_amountbooks")
    private int amountBooks;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookseries_genre")
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookseries_subgenre")
    private SubGenre subgenre;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookseries_status")
    private Status status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmountBooks() {
        return amountBooks;
    }

    public void setAmountBooks(int amountBooks) {
        this.amountBooks = amountBooks;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public SubGenre getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(SubGenre subgenre) {
        this.subgenre = subgenre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String toString(){
        return "BookSeriesModel " + "id: " + id +
                " title: " + title +
                " amountBooks: " + amountBooks +
                " genre: " + genre +
                " subgenre: " + subgenre +
                " status: " + status;
    }
}
