package com.example.mediabase.podcastui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class PodcastController {
    private PodcastClient podcastClient;

    public PodcastController(PodcastClient podcastClient) {
        this.podcastClient = podcastClient;
    }

    @GetMapping("/podcast")
    public String allPodcasts(Map<String, Object> model) {
        model.put("podcast", podcastClient.getAll() );
        return "podcast";
    }

}