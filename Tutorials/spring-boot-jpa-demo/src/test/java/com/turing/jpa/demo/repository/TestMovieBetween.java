package com.turing.jpa.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestMovieBetween {
	@Autowired
	MovieRepository movieRepository;
	
	int add(int a, int b)
	{
		return a+b;
	}
	
	@Test
	public void testBetween()
	{
		log.info("Test case 1");
		/*
		int result = add(1,2);
		assertEquals(3, result);
		*/
		List<Movie> movies = this.movieRepository.findByYearBetween(1990,2010);
		
		for (Movie movie : movies)
		{
			log.info("movie " + movie);
		}
		
		List<Movie> moviess = this.movieRepository.findByYearLessThan(2010);
		
		for (Movie movie : moviess)
		{
			log.info("movie " + movie);
		}
	}
}
