package com.turing.jpa.demo.repository.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestUpdateMovie {
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	public void testUpdate()
	{
		log.info("Test Update Movie");
		int row = this.movieRepository.updateYearByMovieId(11L, 2011);
		System.out.println("Row "+row);
		
		int row_delete = this.movieRepository.deleteMovieById(11L);
		System.out.println("Row "+row_delete);
		
		Movie movie = new Movie();
		movie.setTitle("Testing");
		this.movieRepository.save(movie);
	}
}
