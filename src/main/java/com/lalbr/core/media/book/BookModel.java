package com.lalbr.cwapp.media.book;

import com.lalbr.cwapp.media.bookseries.BookSeriesModel;
import com.lalbr.cwapp.media.general.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "media_book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "book_pages")
    private int pages;

    @Column(name = "book_read")
    private boolean read;

    @ManyToOne
    @JoinColumn(name = "book_bookseries")
    private BookSeriesModel bookSeriesModel;

    @Column(name = "book_format")
    @Enumerated(EnumType.STRING)
    private BookFormat format;

    @Column(name = "book_placeinseries")
    private Double placeInSeries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Double getPlaceInSeries() {
        return placeInSeries;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public BookSeriesModel getBookSeriesModel() {
        return bookSeriesModel;
    }

    public void setBookSeriesModel(BookSeriesModel bookSeriesModel) {
        this.bookSeriesModel = bookSeriesModel;
    }

    public void setPlaceInSeries(Double placeInSeries) {
        this.placeInSeries = placeInSeries;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public String getReadAsString(){
        if(isRead()){
            return "ja";
        }
        return "nein";
    }
    
    @Override
    public String toString(){

        return "BookModel "+"id: " + id +
                " title: " + title +
                " author: " + author +
                " language: " + language +
                " pages: " + pages +
                " read: " + read +
                " bookSeriesModel: " + bookSeriesModel +
                " format: " + format +
                " placeInSeries: " + placeInSeries;
    }
}
