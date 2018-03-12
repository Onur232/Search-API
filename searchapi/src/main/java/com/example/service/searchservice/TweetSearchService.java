package com.example.service.searchservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.TweetEntity;
import com.example.repository.TweetRepository;
import com.example.service.saveservice.TweetSaveService;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TweetSearchService {
	
	private static final String CONSUMER_KEY = "IVzxUXVimWLQLD1dOkWzq0chn";
	private static final String CONSUMER_SECRET = 	"I5rlrrpeDPtOeFdcVHkx7OvHp2kyHfT8w79J6tZshqrkNIqQK3";
	private static final String ACCESS_TOKEN = "936847519400714240-NLkThzLK1jjIQ0ZqyYRXe83LdSKLMTU";
	private static final String ACCESS_TOKEN_SECRET = "LlTTZfHaOvIDB4BkrJBsTpVugU9p9QekqYx7QJk79Pr1r";

//	private TweetRepository tweetRepository;
//	
//	public void setTweetRepository(TweetRepository tweetRepository) {
//		this.tweetRepository = tweetRepository;
//	}
	
	@Autowired
	private TweetSaveService tweetSaveService;
	
	
	public List<Status> searchByString(String queryString) {
		List<Status> statuss=new ArrayList<>();
		
		Twitter twitter = doAuthentication();
		Query query=new Query(queryString);
		System.out.println(queryString);
		QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (Status	status : result.getTweets()) {
			System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
			statuss.add(status);
		}
		return statuss;
		
	}


	private Twitter doAuthentication() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	            .setOAuthConsumerKey(CONSUMER_KEY)
	            .setOAuthConsumerSecret(CONSUMER_SECRET)
	            .setOAuthAccessToken(ACCESS_TOKEN)
	            .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    return twitter;
	}

	public List<TweetEntity> saveOrUpdate(List<Status> status) {
//		return tweetRepository.saveOrUpdate(status);
//		return tweetRepository.saveAll(status);
		return tweetSaveService.save(status);
	}
	
	public void showTweetsFromMongoDb() {
		tweetSaveService.retrieveTweetsFromMongoDb();
	}
	
	

}
