package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VO.PostVO;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	public List<PostVO> getAllPosts(){
		return this.postRepository.findAll()
				.stream()
				.map(this::getEntityToVOObject)
				.collect(Collectors.toList());
	}
	
	public PostVO getPostById(long id)throws PostNotFoundException {
		Post post= this.postRepository.findById(id)
				.orElseThrow(()->new PostNotFoundException("Post not found for id: "+id));
		return getEntityToVOObject(post);
	}
	
	public void createPost(PostVO postVo) {
		this.postRepository.save(getVOToEntityObject(postVo));
	}
	
	public void deletePost(long id) {
		this.postRepository.deleteById(id);
	}
	
	public PostVO getEntityToVOObject(Post post) {
		PostVO postVO= new PostVO();
		postVO.setId(post.getId());
		postVO.setContent(post.getContent());
		postVO.setTitle(post.getTitle());
		postVO.setUsername(post.getUsername());
		postVO.setVideoUrl(post.getVideoUrl());
		return postVO;
	}
	
	public Post getVOToEntityObject(PostVO postVo) {
		Post post= new Post();
	//	post.setId(postVo.getId());
		post.setContent(postVo.getContent());
		post.setTitle(postVo.getTitle());
		post.setUsername(postVo.getUsername());
		post.setVideoUrl(postVo.getVideoUrl());
		return post;
	}
}
