package com.lalbr.cwapp.media.general;

import com.lalbr.cwapp.media.book.BookModel;
import com.lalbr.cwapp.media.book.BookRepository;
import com.lalbr.cwapp.media.bookseries.BookSeriesModel;
import com.lalbr.cwapp.media.bookseries.BookSeriesRepository;
import com.lalbr.cwapp.media.game.GameModel;
import com.lalbr.cwapp.media.game.GameRepository;
import com.lalbr.cwapp.media.movie.MovieModel;
import com.lalbr.cwapp.media.movie.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookSeriesRepository bookSeriesRepository;

    private static final Logger logger = LoggerFactory.getLogger(MediaService.class);

    public List<BookModel> findAllBookModel(){
        List<BookModel> bookModels = bookRepository.findAll();

        logger.info("########## findAllBookModel() - Start ##########");
        bookModels.forEach(bookModel -> {logger.info(bookModel.toString());});
        logger.info("########## findAllBookModel() - End ##########");

        return bookModels;
    }

    public BookModel findBookModelByTitle(String name){
        BookModel bookModel = bookRepository.findByTitle(name);
        logger.info("########## findBookModelByTitle({} ) - Start ##########", name);
        logger.info(bookModel.toString());
        logger.info("########## findBookModelByTitle({} ) - End ##########", name);

        return bookModel;
    }

    public List<BookSeriesModel> findAllBookSeriesModel(){
        List<BookSeriesModel> bookSeriesModels = bookSeriesRepository.findAll();
        logger.info("########## findAllBookSeriesModel() - Start ##########");
        bookSeriesModels.forEach(bookModel -> {logger.info(bookModel.toString());});
        logger.info("########## findAllBookSeriesModel() - End ##########");

        return bookSeriesModels;
    }

    public BookSeriesModel findBookSeriesModelByTitle(String name){
    BookSeriesModel bookSeriesModel = bookSeriesRepository.findByTitle(name);
        logger.info("########## findBookSeriesModelByTitle({} ) - Start ##########", name);
        logger.info(bookSeriesModel.toString());
        logger.info("########## findBookSeriesModelByTitle({} ) - End ##########", name);
        return bookSeriesModel;
    }

    public List<MovieModel> findAllMovieModel(){
        List<MovieModel> movieModels = movieRepository.findAll();
        logger.info("########## findAllMovieModel() - Start ##########");
        movieModels.forEach(bookModel -> {logger.info(bookModel.toString());});
        logger.info("########## findAllMovieModel() - End ##########");

        return movieModels;
    }
    public MovieModel findMovieModelByTitle(String name){
        MovieModel movieModel = movieRepository.findByTitle(name);
        logger.info("########## findMovieModelByTitle({} ) - Start ##########", name);
        logger.info(movieModel.toString());
        logger.info("########## findMovieModelByTitle({} ) - End ##########", name);
        return movieModel;
    }

    public GameModel findGameModelByTitle(String name){
        GameModel gameModel = gameRepository.findByTitle(name);
        logger.info("########## findGameModelByTitle({} ) - Start ##########", name);
        logger.info(gameModel.toString());
        logger.info("########## findGameModelByTitle({} ) - End ##########", name);
        return gameModel;
    }
    public List<GameModel> findAllGameModel(){
        List<GameModel> gameModels = gameRepository.findAll();
        logger.info("########## findAllGameModel() - Start ##########");
        gameModels.forEach(game -> {logger.info(game.toString());});
        logger.info("########## findAllGameModel() - End ##########");
        return gameModels;
    }

    public BookSeriesModel findBookSeriesModelById(Long id){
        if (bookSeriesRepository.findById(id).isPresent()){
            BookSeriesModel bookSeriesModel = bookSeriesRepository.findById(id).get();
            logger.info("########## findBookSeriesModelById() - Start ##########");
            logger.info(bookSeriesModel.toString());
            logger.info("########## findBookSeriesModelById() - End ##########");
            return bookSeriesModel;
        }
        logger.info("########## findBookSeriesModelById() - No Model found ##########");
        return null;
    }


    public BookModel saveBookModel(BookModel bookModel){
        BookModel savedBookModel = bookRepository.save(bookModel);
        logger.info("########## saveBookModel() - Start ##########");
        logger.info(savedBookModel.toString());
        logger.info("########## saveBookModel() - End ##########");
        return savedBookModel;
    }

    public BookSeriesModel saveBookSeriesModel(BookSeriesModel bookSeriesModel){
        BookSeriesModel savedBookSeriesModel = bookSeriesRepository.save(bookSeriesModel);
        logger.info("########## saveBookSeriesModel() - Start ##########");
        logger.info(savedBookSeriesModel.toString());
        logger.info("########## saveBookSeriesModel() - End ##########");
        return savedBookSeriesModel;
    }

    public GameModel saveGameModel(GameModel gameModel){
        GameModel savedGameModel = gameRepository.save(gameModel);
        logger.info("########## saveGameModel() - Start ##########");
        logger.info(savedGameModel.toString());
        logger.info("########## saveGameModel() - End ##########");
        return savedGameModel;
    }

    public MovieModel saveMovieModel(MovieModel movieModel){
        MovieModel savedMovieModel = movieRepository.save(movieModel);
        logger.info("########## saveMovieModel() - Start ##########");
        logger.info(savedMovieModel.toString());
        logger.info("########## saveMovieModel() - End ##########");
        return savedMovieModel;
    }

    public int deleteMovieModelByTitle(String title){
        return movieRepository.deleteAllByTitle(title);
    }

    public int deleteGameModelByTitle(String title){
        return gameRepository.deleteAllByTitle(title);
    }

    public int deleteBookModelByTitle(String title){
        return bookRepository.deleteAllByTitle(title);
    }

    public void deleteBookseriesModelById(long id){
        bookSeriesRepository.deleteById(id);
    }

}
