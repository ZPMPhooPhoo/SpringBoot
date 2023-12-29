package com.turing.jpa.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.MovieDto;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository movieRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<MovieDto> getAllMovie() {
		List<Movie> movies = this.movieRepository.findAll();
		
		return movieListToMovieDto(movies);
	}

	private List<MovieDto> movieListToMovieDto(List<Movie> movies) {
		List<MovieDto> moviesDto = new ArrayList<MovieDto>();
		
		for(Movie movie: movies)
		{
			MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
			moviesDto.add(movieDto);
		}
		return moviesDto;
	}
	
	@Override
	public List<MovieDto> getAllMovieByYear(Integer year) {
		List<Movie> movies = this.movieRepository.findByYear(year);
		return movieListToMovieDto(movies);
	}
	
	@Override
	public List<MovieDto> getAllMovieByTitle(String title) {
		List<Movie> movies = this.movieRepository.findByTitle(title);
		return movieListToMovieDto(movies);
	}

	@Override
	public Optional<MovieDto> getMovieById(Long id) {
		Optional<Movie> result = this.movieRepository.findById(id);
		if(result.isPresent())
		{
			Movie movie = result.get();
			MovieDto dto = modelMapper.map(movie, MovieDto.class);
			return Optional.of(dto);
		}
		else
		{
			return Optional.empty();
		}
	}

	@Override
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		movie = this.movieRepository.save(movie);
		
		movieDto = modelMapper.map(movie, MovieDto.class);
		return movieDto;
	}

	@Override
	public MovieDto updateMovie(MovieDto movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		movie = this.movieRepository.save(movie);
		
		movieDto = modelMapper.map(movie, MovieDto.class);
		return movieDto;
	}

	@Override
	public void deleteMovieById(Long id) {
		this.movieRepository.deleteById(id);		
	}
}
