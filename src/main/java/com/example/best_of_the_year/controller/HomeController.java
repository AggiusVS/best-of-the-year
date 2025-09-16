package com.example.best_of_the_year.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.best_of_the_year.model.Movie;
import com.example.best_of_the_year.model.Song;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nome", "Stefano Aggius-Vella");
        return "index";
    }
    
    /* Medoti privati */

    private List<Movie> getBestMovies(){
        return List.of(
            new Movie(1, "Inception"),
            new Movie(2, "Interstellar"),
            new Movie(3, "Pulp Fiction")
          );
    }

    private List<Song> getBestSongs(){
        return List.of(
            new Song(1, "Imagine"),
            new Song(2, "In the end"),
            new Song(3, "Bohemian Rhapsody")
        );
    }

     @GetMapping("/movies")
    public String movies(Model model) {
        String movieTitles = getBestMovies().stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        model.addAttribute("movies", movieTitles);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieById(@PathVariable int id, Model model) {
        Movie movie = getBestMovies().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("movie", movie);
        return "movie-detail";
    }
    @GetMapping("/songs")
    public String songs(Model model) {
        String songTitles = getBestSongs().stream()
                .map(Song::getTitle)
                .collect(Collectors.joining(", "));
        model.addAttribute("songs", songTitles);
        return "songs";
    }
    @GetMapping("/songs/{id}")
    public String songById(@PathVariable int id, Model model) {
        Song song = getBestSongs().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("song", song);
        return "song-detail";
    }
}
