package com.example.service.saveservice;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.TweetEntity;
import com.example.repository.TweetRepository;

import twitter4j.Status;

@Service
public class TweetSaveService {
	
	@Autowired
	private TweetRepository tweetRepository;

	public List<TweetEntity> save(List<Status> statusList) {
		List<TweetEntity> tweets=new ArrayList<>();
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
		for (Status status : statusList) {
			TweetEntity tweet = new TweetEntity();
			tweet.setCreatedAt(status.getCreatedAt());
			tweet.setAccessLevel(status.getAccessLevel());
			tweet.setFavoriteCount(status.getFavoriteCount()); 
			tweet.setGeoLocation(status.getGeoLocation());
			tweet.setRetweetCount(status.getRetweetCount());
			tweet.setText(status.getText());
			tweets.add(tweet);
			tweetRepository.save(tweet);
		}
		
		
		
		return tweets;
	}
	
	public void retrieveTweetsFromMongoDb() {
		List<TweetEntity> findAll = tweetRepository.findAll();
		for (TweetEntity tweet : findAll) {
			System.out.println(tweet);
		}
	}
	
	

}
