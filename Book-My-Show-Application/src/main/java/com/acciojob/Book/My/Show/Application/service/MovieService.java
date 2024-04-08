package com.acciojob.Book.My.Show.Application.service;

import com.acciojob.Book.My.Show.Application.dto.request.UpdateMovieAttribute;
import com.acciojob.Book.My.Show.Application.entity.Movie;
import com.acciojob.Book.My.Show.Application.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    public String addMovie(Movie movie){
        movieRepo.save(movie);
        return "Movie add Successfully with movieId"+movie.getMovieId();
    }
    public String updateAttribute(@RequestBody UpdateMovieAttribute updateMovieAttribute){
        Movie movie=movieRepo.findById(updateMovieAttribute.getMovieId()).get();
                return "Movie attribute are modified";
    }
}
