package com.hay.movieinfoservice.resources;

import com.hay.movieinfoservice.models.Movie;
import com.hay.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public Movie getMovieInfo(@PathVariable("id") String id) {

        MovieSummary movieSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + id + "?api_key=" +  apiKey,
                MovieSummary.class);

        return new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());
//        https://api.themoviedb.org/3/movie/100?api_key=44ae30c370a1ad86d7b0ed77198749c8

    }
}
