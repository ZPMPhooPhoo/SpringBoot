package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieCustomQuery {
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	public void testCustomeQuery()
	{
		log.info("Test case testCustomQuery");
		
		int totalDrama = this.movieRepository.findTotalMovieByGenres("Action");
		System.err.println("Total number of drama " + totalDrama);
		
		List<Movie> movies = this.movieRepository.findAllMovie();
		movies.forEach(movie->System.err.println(movie));
		
//		List<String> genres = this.movieRepository.getAllGeneres();
//		genres.forEach(genre->System.err.println(genre));
		
		List<Object> genres = this.movieRepository.getAllGeneres();
		genres.forEach(genre->System.err.println(genre));
		
		List<GenreCountDto> genres_count = this.movieRepository.getAllGenresCount();
		genres_count.forEach(genre->System.err.println("Genre "+ genre.getGenre()+ " Count "+genre.getCount()
		+ " UpperCase " + genre.getGenreUpperCase()));
		
		try {
			List<GenreCountDtoTwo> genres_count_two = this.movieRepository.getAllGenresCountTwo();
			genres_count_two.forEach(genre->System.err.println("Genre "+ genre.getGenre()+ " Count "+genre.getCount()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
