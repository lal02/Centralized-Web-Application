package com.lalbr.core.media.bookseries;

public class BookSeriesApiRequestModel {

    private String title;
    private int amountBooks;
    private String genre;
    private String subgenre;
    private String status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmountbooks() {
        return amountBooks;
    }

    public void setAmountBooks(int amountbooks) {
        this.amountBooks = amountbooks;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return  "BookSeriesApiRequestModel " + "title: " + title +
                " amount of books: " + amountBooks +
                " genre: " + genre +
                " subgenre: " + subgenre +
                " status: " + status;
    }
}
