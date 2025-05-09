package com.lalbr.cwapp.media.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel,Long> {
    MovieModel findByTitle(String title);

    Integer deleteAllByTitle(String title);
}
