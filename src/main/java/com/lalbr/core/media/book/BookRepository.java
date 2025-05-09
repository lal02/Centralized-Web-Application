package com.lalbr.cwapp.media.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel,Long> {

    BookModel findByTitle(String title);

    Integer deleteAllByTitle(String title);
}
