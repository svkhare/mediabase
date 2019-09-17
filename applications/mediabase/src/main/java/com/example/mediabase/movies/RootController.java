package com.example.mediabase.movies;

import com.example.mediabase.movies.movies.MoviesBean;
import com.example.mediabase.movies.movies.MoviesInitialList;
import com.example.mediabase.movies.podcast.PodcastInitialList;
import com.example.mediabase.movies.podcast.PodcastRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private MoviesBean moviesBean;
    private PodcastRepository podcastRepository;
    private MoviesInitialList moviesInitialList;
    private PodcastInitialList podcastInitialList;

    public RootController(MoviesBean moviesBean, PodcastRepository podcastRepository, MoviesInitialList moviesInitialList, PodcastInitialList podcastInitialList) {
        this.moviesBean = moviesBean;
        this.podcastRepository = podcastRepository;
        this.moviesInitialList=moviesInitialList;
        this.podcastInitialList=podcastInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        moviesInitialList.asList().forEach(moviesBean::addMovie);
        model.put("movies", moviesBean.getMovies());

        podcastInitialList.asList().forEach(podcastRepository::save);
        model.put("podcasts", podcastRepository.findAll());

        return "setup";
    }

}
