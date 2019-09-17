package com.example.mediabase.movies.podcast;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PodcastInitialList {

    public List<Podcast> asList() {
        return Arrays.asList(new Podcast("Wedding Crashers", "David Dobkin", "Comedy"),
                new Podcast("Starsky & Hutch", "Todd Phillips", "Action"),
                new Podcast("Shanghai Knights", "David Dobkin", "Action"),
                new Podcast("I-Spy", "Betty Thomas", "Adventure"),
                new Podcast("The Royal Tenenbaums", "Wes Anderson", "Comedy"),
                new Podcast("Zoolander", "Ben Stiller", "Comedy"),
                new Podcast("Shanghai Noon", "Tom Dey", "Comedy")

        );
    }
}