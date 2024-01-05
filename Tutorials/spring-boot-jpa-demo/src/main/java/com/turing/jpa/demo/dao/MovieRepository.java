package com.turing.jpa.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByYear(Integer year);
	List<Movie> findByTitle(String title);
	List<Movie> findByGenreAndYear(String genre, Integer year);
	List<Movie> findByGenreOrYear(String genre, Integer year);
	List<Movie>	findDistinctByGenre(String genre);
	List<Movie>	findByYearBetween(Integer startYear, Integer endYear);
	List<Movie>	findByYearLessThan(Integer year);
	List<Movie>	findByCreatedAtIsNull();
	List<Movie> findByTitleLike(String title);
	List<Movie>	findAllByOrderByYear();
	List<Movie>	findAllByYearIn(Collection<Integer> years);
	
	Movie findTopByOrderByYearDesc();
	
	//This is SQL Query
	@Query(value="SELECT * FROM movie;", nativeQuery=true)
	List<Movie> findAllMovie();
	
	//This is JPQL Query
	//Movie is Entity
	@Query("SELECT count(m) FROM Movie m WHERE m.genre = genre")
	int findTotalMovieByGenres(@Param("genre") String genere);
	
	@Query("SELECT distinct(m.genre) FROM Movie m")
	List<Object> getAllGeneres();	
	
	@Query(value="SELECT genre,count(*)As count FROM movie GROUP BY genre;",nativeQuery = true)
	List<GenreCountDto> getAllGenresCount();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
