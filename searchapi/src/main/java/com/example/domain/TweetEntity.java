package com.example.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import twitter4j.GeoLocation;

//@Document(collection="tweets")
public class TweetEntity extends BaseEntity{
	
	private int accessLevel;
	private int favoriteCount;
	private int retweetCount;
	private GeoLocation geoLocation;
	
	@Override
	public String toString() {
		return "Tweet [accessLevel=" + accessLevel + ", favoriteCount=" + favoriteCount + ", retweetCount="
				+ retweetCount + ", geoLocation=" + geoLocation + ", id=" + id + ", text=" + text + ", createdAt="
				+ createdAt + "]";
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

}
