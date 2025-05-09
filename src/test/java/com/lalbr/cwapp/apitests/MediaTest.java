package com.lalbr.cwapp.apitests;

import com.lalbr.cwapp.media.general.MediaService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MediaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MediaService mediaService;

    @Test
    public void testOverviews() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/bookseries")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/games")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/movies")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/The Alloy of Law")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/The Witcher")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/game/The Witcher 3")).andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/bookseries/Mistborn")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPost() throws Exception {
        //create test bookseries
        String bookseriesJson = "{\"title\":\"Testbuchserie\",\"amountBooks\":\"1\",\"genre\":\"Fantasy\",\"subgenre\":\"DarkFantasy\",\"status\":\"ongoing\"}";
        mockMvc.perform(post("/bookseries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookseriesJson))
                .andExpect(status().isOk());
        long id = mediaService.findBookSeriesModelByTitle("Testbuchserie").getId();

        //create test book
        String bookJson = "{\"title\":\"Testbuch\",\"author\":\"Testauthor\",\"language\":\"Deutsch\",\"pages\":\"12\",\"read\":true,\"bookSeriesModel\":\"" + id + "\",\"format\":\"Taschenbuch\",\"placeInSeries\":\"1\"}";
        mockMvc.perform(post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk());

        //create test movie
        String movieJson = "{\"title\":\"Testmovie\",\"platform\":\"Steam\",\"genre\":\"Fantasy\",\"subGenre\":\"DarkFantasy\",\"movieType\":\"Film\"}";
        mockMvc.perform(post("/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(movieJson))
                .andExpect(status().isOk());

        //create test game
        String gameJson = "{\"title\":\"Testspiel\",\"gamestudio\":\"Testgamestudio\",\"platform\":\"Steam\",\"gameGenre\":\"Fantasy\",\"subGenre\":\"DarkFantasy\",\"bookSeriesModel\":\""+ id + "\",\"completed\":true,\"coop\":true,\"pvp\":true,\"released\":true}";
        mockMvc.perform(post("/game")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson))
                .andExpect(status().isOk());
        //cleanup
        mediaService.deleteBookModelByTitle("Testbuch");
        mediaService.deleteMovieModelByTitle("Testmovie");
        mediaService.deleteGameModelByTitle("Testspiel");
        mediaService.deleteBookseriesModelById(id);
    }
}
