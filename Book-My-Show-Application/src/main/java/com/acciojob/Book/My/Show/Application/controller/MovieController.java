package com.acciojob.Book.My.Show.Application.controller;

import com.acciojob.Book.My.Show.Application.dto.request.UpdateMovieAttribute;
import com.acciojob.Book.My.Show.Application.entity.Movie;
import com.acciojob.Book.My.Show.Application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
    @RequestMapping("/update")
    public String updateAttribute(@RequestBody UpdateMovieAttribute movieRequest){
        return movieService.updateAttribute(movieRequest);
    }

}
