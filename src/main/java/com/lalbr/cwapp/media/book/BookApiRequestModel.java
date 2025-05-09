package com.lalbr.cwapp.media.book;

import com.lalbr.cwapp.media.general.Language;

public class BookApiRequestModel {

    private String title;

    private String author;

    private Language language;

    private int pages;

    private boolean read;

    private Long bookSeriesModel;

    private BookFormat format;

    private double placeInSeries;

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Long getBookSeriesModel() {
        return bookSeriesModel;
    }

    public void setBookSeriesModel(Long bookSeriesModel) {
        this.bookSeriesModel = bookSeriesModel;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public double getPlaceInSeries() {
        return placeInSeries;
    }

    public void setPlaceInSeries(double placeInSeries) {
        this.placeInSeries = placeInSeries;
    }

    public String toString(){
        return "BookApiRequestModel " + "Title: " + title +
                " Author: " + author +
                " Language: " + language +
                " Pages: " + pages +
                " Read: " + read +
                " Book Series Model: " + bookSeriesModel +
                " Format: " + format  +
                " Place In Series: " + placeInSeries;
    }
}
