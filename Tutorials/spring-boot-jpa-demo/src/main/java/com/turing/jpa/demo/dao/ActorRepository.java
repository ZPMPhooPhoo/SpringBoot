package com.turing.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.jpa.demo.model.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long>{

}
