package com.example.domain;

public class InstagramEntity extends BaseEntity{
	
	private String username;
	private String profilePicture;
	private String fullName;
	
	@Override
	public String toString() {
		return "InstagramEntity [username=" + username + ", profilePicture=" + profilePicture + ", fullName=" + fullName
				+ ", id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}
