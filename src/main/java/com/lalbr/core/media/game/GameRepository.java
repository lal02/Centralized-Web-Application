package com.lalbr.cwapp.media.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {

    GameModel findByTitle(String title);

    Integer deleteAllByTitle(String title);
}
