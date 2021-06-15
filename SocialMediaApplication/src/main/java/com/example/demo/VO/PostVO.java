package com.example.demo.VO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class PostVO {
	private long id;

	@NotBlank(message = "Title is mandatory")
	private String title;
	
	@NotBlank(message = "Content is mandatory")
	private String content;
	
	@NotBlank(message = "Username is mandatory")
	@Min(3)
	private String username;
	
	@NotBlank(message = "Video URL is mandatory")
	private String videoUrl;
	
	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public PostVO(long id, String title, String content, String username) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.username= username;
	}
	
	public PostVO(long id, String title, String content, String username, String videoUrl) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.username = username;
		this.videoUrl = videoUrl;
	}
	public PostVO() {
		super();
	}
	
	
}
