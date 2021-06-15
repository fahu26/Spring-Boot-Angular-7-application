package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.PostVO;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/savePosts")
	public ResponseEntity<?> createPost( @RequestBody PostVO postVO){
		this.postService.createPost(postVO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllPosts")
	public ResponseEntity<List<PostVO>> getAllPost() {
		return new ResponseEntity<>(this.postService.getAllPosts(),HttpStatus.OK);
	}
	
	@GetMapping("/viewPosts/{id}")
	public ResponseEntity<PostVO> getPostById(@PathVariable long id)throws PostNotFoundException {
		return new ResponseEntity<>(this.postService.getPostById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("deletePosts/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable long id) {
		this.postService.deletePost(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}}
