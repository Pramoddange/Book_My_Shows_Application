package com.acciojob.Book.My.Show.Application.repository;

import com.acciojob.Book.My.Show.Application.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
   // Movie findMovieByMovieName(String movieName);
   @Query(value = "Select * from Movie where movie_name=:movieName",nativeQuery = true)
    Movie findMovieName(String movieName);
}
