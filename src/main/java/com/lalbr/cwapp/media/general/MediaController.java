package com.lalbr.cwapp.media.general;

import com.lalbr.cwapp.media.bookseries.Status;
import com.lalbr.cwapp.media.book.*;
import com.lalbr.cwapp.media.bookseries.BookSeriesApiRequestModel;
import com.lalbr.cwapp.media.bookseries.BookSeriesModel;
import com.lalbr.cwapp.media.bookseries.BookSeriesRepository;
import com.lalbr.cwapp.media.game.GameApiRequestModel;
import com.lalbr.cwapp.media.game.GameModel;
import com.lalbr.cwapp.media.movie.MovieApiRequestModel;
import com.lalbr.cwapp.media.movie.MovieModel;
import com.lalbr.cwapp.media.movie.MovieType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MediaController {

    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);

    @Autowired
    MediaService mediaservice;

    /*
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
    ________________________GET MAPPING_____________________________________________________________
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
     */


    /*
        Overview Mappings
     */
    @GetMapping("/media/overview")
    public String overviewGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        model.addAttribute("bookserieslist",mediaservice.findAllBookSeriesModel());
        model.addAttribute("gameslist",mediaservice.findAllGameModel());
        model.addAttribute("movielist",mediaservice.findAllMovieModel());
        logger.info("########## media overview get request ##########");
        return "media/overview/mediaoverview";
    }

    @GetMapping("/books")
    public String bookGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        logger.info("########## media books get request ##########");
        return "media/overview/bookoverview";
    }

    @GetMapping("/bookseries")
    public String bookseriesGetMapping(Model model){
        model.addAttribute("bookserieslist", mediaservice.findAllBookSeriesModel());
        logger.info("########## media bookseries get request ##########");
        return "media/overview/bookseriesoverview";
    }

    @GetMapping("/games")
    public String gamesGetMapping(Model model){
        model.addAttribute("gameslist",mediaservice.findAllGameModel());
        logger.info("########## media games get request ##########");
        return "media/overview/gameoverview";
    }

    @GetMapping("/movies")
    public String moviesGetMapping(Model model){
        model.addAttribute("movielist",mediaservice.findAllMovieModel());
        logger.info("########## media movies get request ##########");
        return "media/overview/movieoverview";
    }



    /*
        Detail templates
     */

    @GetMapping(value = {"/book/{name}","/Book/{name}"})
    public String bookTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("book",mediaservice.findBookModelByTitle(name));
        logger.info("########## media book template get request ##########");
        return "/media/detailtemplates/booktemplate";
    }

    @GetMapping(value = {"/movie/{name}","/Movie/{name}"})
    public String movieTemplateGetMapping(@PathVariable String name, Model model) {
        model.addAttribute("movie", mediaservice.findMovieModelByTitle(name));
        logger.info("########## media movie template get request ##########");
        return "/media/detailtemplates/movietemplate";
    }

    @GetMapping(value = {"/game/{name}","/Game/{name}"})
    public String gamesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("game",mediaservice.findGameModelByTitle(name));
        logger.info("########## media games template get request ##########");
        return "/media/detailtemplates/gametemplate";
    }

    @GetMapping(value = {"/bookseries/{name}","/Bookseries/{name}"})
    public String bookSeriesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("bookseries",mediaservice.findBookSeriesModelByTitle(name));
        logger.info("########## media bookseries template get request ##########");
        return "/media/detailtemplates/bookseriestemplate";
    }

    /*
        Create templates
     */

    @GetMapping("/createbook")
    public String createBookTemplateGetMapping(){
        logger.info("########## media createbook get request ##########");
        return "/media/createtemplates/createbookview";
    }

    @GetMapping("/createbookseries")
    public String createBookSeriesTemplateGetMapping(){
        logger.info("########## media createbookseries get request ##########");
        return "/media/createtemplates/createbookseriesview";
    }

    @GetMapping("/creategame")
    public String createGameTemplateGetMapping(){
        logger.info("########## media creategame get request ##########");
        return "/media/createtemplates/creategameview";
    }

    @GetMapping("/createmovie")
    public String createMovieTemplateGetMapping(){
        logger.info("########## media createmovie get request ##########");
        return "/media/createtemplates/createmovieview";
    }


      /*
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
    ________________________POST MAPPING____________________________________________________________
    ________________________________________________________________________________________________
    ________________________________________________________________________________________________
     */

    @PostMapping("/book")
    public ResponseEntity<BookModel> createBookApiEndpoint(@RequestBody BookApiRequestModel myModel) {
        BookModel model = new BookModel();
        model.setTitle(myModel.getTitle());
        model.setAuthor(myModel.getAuthor());
        model.setLanguage(myModel.getLanguage());
        model.setFormat(myModel.getFormat());
        model.setPages(myModel.getPages());
        model.setPlaceInSeries(myModel.getPlaceInSeries());
        model.setRead(myModel.isRead());
        if(myModel.getBookSeriesModel() != null){
            model.setBookSeriesModel(mediaservice.findBookSeriesModelById(myModel.getBookSeriesModel()));
        }
        BookModel savedModel = mediaservice.saveBookModel(model);
        String debugMessage = " saved this book: " + " with id " + savedModel.getId() + " and title " + savedModel.getTitle()+ "\n"
                + " and author " + savedModel.getAuthor()+ "\n"
                + " and language " + savedModel.getLanguage()+ "\n"
                + " and pages amount " + savedModel.getPages()+ "\n"
                + " and read_status " + savedModel.getReadAsString()+ "\n"
                + " and bookseries as int " + (savedModel.getBookSeriesModel() == null ? " - " : savedModel.getBookSeriesModel().getId())+ "\n"
                + " which is bookseries " + (savedModel.getBookSeriesModel() == null ? " - " : savedModel.getBookSeriesModel().getTitle())+ "\n"
                + " with format " + savedModel.getFormat()+ "\n"
                + " with place in bookseries " + savedModel.getPlaceInSeries()+ "\n";
        System.out.println(debugMessage);
        return ResponseEntity.ok(savedModel);
    }


    @PostMapping("/bookseries")
    public ResponseEntity<BookSeriesModel> createBookseriesApiEndpoint(@RequestBody BookSeriesApiRequestModel myModel) {
        BookSeriesModel model = new BookSeriesModel();
        model.setTitle(myModel.getTitle());
        model.setAmountBooks(myModel.getAmountbooks());
        model.setGenre(Genre.valueOf(myModel.getGenre()));
        model.setSubgenre(SubGenre.valueOf(myModel.getSubgenre()));
        model.setStatus(Status.valueOf(myModel.getStatus()));
        BookSeriesModel savedModel = mediaservice.saveBookSeriesModel(model);
        String debugMessage = " saved this bookseries: " + " with id " + savedModel.getId() + " and title " + savedModel.getTitle()+ "\n"
                + " and amount of books in the series " + savedModel.getAmountBooks()+ "\n"
                + " and genre " + savedModel.getGenre()+ "\n"
                + " and subgenre " + savedModel.getSubgenre() + "\n"
                + " with status " + savedModel.getStatus() + "\n";
        System.out.println(debugMessage);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/game")
    public ResponseEntity<GameModel> createGameApiEndpoint(@RequestBody GameApiRequestModel myModel) {
        GameModel model = new GameModel();
        model.setTitle(myModel.getTitle());
        model.setGamestudio(myModel.getGamestudio());
        model.setPlatform(Platform.valueOf(myModel.getPlatform()));
        model.setGameGenre(Genre.valueOf(myModel.getGameGenre()));
        model.setGameSubGenre(SubGenre.valueOf(myModel.getSubGenre()));
        if(myModel.getBookSeriesModel() != null){
            model.setBookSeriesModel(mediaservice.findBookSeriesModelById(myModel.getBookSeriesModel()));
        }
        model.setCompleted(myModel.isCompleted());
        model.setCoop(myModel.isCoop());
        model.setPvp(myModel.isPvp());
        model.setReleased(myModel.isReleased());
        model = mediaservice.saveGameModel(model);
        String debugMessage = " saved this game: " + " with id " + model.getId() + " and title " + model.getTitle()
                + " and gamestudio" + model.getGamestudio() + "\n"
                + " and platform " + model.getPlatform() + "\n"
                + " and genre " + model.getGameGenre() + "\n"
                + " and subgenre " + model.getGameSubGenre() + "\n"
                + " with association to bookseries " + (model.getBookSeriesModel() == null ? " - " : model.getBookSeriesModel().getTitle()) + "\n"
                + " finish-status: " + model.isCompleted() +"\n"
                + " coop: " + model.isCoop() + "\n"
                + " pvp: " + model.isPvp() + "\n"
                + " released: " + model.isReleased() + "\n";
        System.out.println(debugMessage);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieModel> createMovieApiEndpoint(@RequestBody MovieApiRequestModel myModel) {
        MovieModel model = new MovieModel();
        model.setTitle(myModel.getTitle());
        model.setGenre(Genre.valueOf(myModel.getGenre()));
        model.setSubgenre(SubGenre.valueOf(myModel.getSubGenre()));
        model.setPlatform(Platform.valueOf(myModel.getPlatform()));
        model.setMovieType(MovieType.valueOf(myModel.getMovieType()));
        model = mediaservice.saveMovieModel(model);
        String debugMessage = " saved this movie: " + " with id " + model.getId() + " and title " + model.getTitle()
                + " and platform " + model.getPlatform() + "\n"
                + " and genre " + model.getGenre() + "\n"
                + " and subgenre " + model.getSubgenre() + "\n"
                + " and movietype: " + model.getMovieType() + "\n";
        System.out.println(debugMessage);
        return ResponseEntity.ok(model);
    }
}
