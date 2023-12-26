package com.turingjavaee7.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.turingjavaee7.demo.model.Post;

public interface PostDao extends CrudRepository<Post, Long>{

}
