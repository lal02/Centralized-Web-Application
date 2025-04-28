package com.lalbr.core.media.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel,Long> {
    MovieModel findByTitle(String title);
}
