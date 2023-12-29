package com.turing.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import com.turing.jpa.demo.model.dto.MovieDto;

public interface MovieService {
	List<MovieDto> getAllMovie();
	List<MovieDto> getAllMovieByYear(Integer year);
	List<MovieDto> getAllMovieByTitle(String title);
	Optional<MovieDto> getMovieById(Long id);
	MovieDto saveMovie(MovieDto movieDto);
	MovieDto updateMovie(MovieDto movieDto);
	void deleteMovieById(Long id);
}
