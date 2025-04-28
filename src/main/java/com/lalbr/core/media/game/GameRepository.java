package com.lalbr.core.media.game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {

    GameModel findByTitle(String title);
}
