package com.example.mediabase.podcast;

        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/podcast")
public class PodcastController {

    private PodcastRepository podcastRepository;

    public PodcastController(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @GetMapping
    public Iterable<Podcast>  read(){
     return podcastRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Podcast> save(@RequestBody Podcast podcast) {
        podcastRepository.save(podcast);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
