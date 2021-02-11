package com.hay.movieinfoservice.resources;

import com.hay.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{id}")
    public Movie getMovieInfo(@PathVariable("id") String id) {

        return new Movie(id, "Test name");

    }
}
