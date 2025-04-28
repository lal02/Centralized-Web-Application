package com.lalbr.core.media.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel,Long> {

    BookModel findByTitle(String title);
}
