package com.turingjavaee7.demo.sevice;

import java.util.List;
import java.util.Optional;

import com.turingjavaee7.demo.model.Post;
import com.turingjavaee7.demo.model.dto.PostDto;

public interface PostService {
	Iterable<Post> getAllPost();
	PostDto savePost(PostDto postDto);
	PostDto updatePost(PostDto postDto);
	
	Optional<PostDto> getPostById(Long id);
	void deletePostById(Long id);
}
