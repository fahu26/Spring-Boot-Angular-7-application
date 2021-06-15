package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table(name = "post", schema = "fahim")
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String username;
	
	@Column 
	private String videoUrl;
	
	
	@Column
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Post(Long id, String title, String content, String username) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.username= username;
	}

	public Post() {
		super();
	}

	public Post(Long id, String title, String content, String username, String videoUrl) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.username = username;
		this.videoUrl = videoUrl;
	}
	
	
}
