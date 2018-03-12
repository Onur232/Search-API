package com.example.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
	
	@Id protected String id;
	protected String text;
	protected Date createdAt;
	
	@Override
	public String toString() {
		return " [id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
