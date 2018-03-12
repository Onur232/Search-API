package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.TweetEntity;
import com.example.service.searchservice.TweetSearchService;

import twitter4j.Status;


@RestController
public class TwitterRestController {
	

	private TweetSearchService tweetService;

	@Autowired
	public void setTweetService(TweetSearchService tweetService) {
		this.tweetService = tweetService;
	}
	
	// Query cümlesi = http://localhost:8080/tweets?queryString=galatasaray
	
	@RequestMapping(value= "/tweets",produces= {"application/json"} ,method=RequestMethod.GET)
	public List<TweetEntity> getTweets(@RequestParam("queryString") String queryString,Model model,RedirectAttributes redirectAttributes) {
		List<Status> status = tweetService.searchByString(queryString);
		List<TweetEntity> tweets = tweetService.saveOrUpdate(status);
		for (TweetEntity tweet : tweets) {
			System.out.println("tweetler :" + tweet.getText());
		}
		model.addAttribute("tweets", tweets);
		System.out.println("Tweets are written to database"); 
		redirectAttributes.addFlashAttribute("tweets", tweets);
//		return "redirect:/showtweets";
		tweetService.showTweetsFromMongoDb();
		return tweets;
	}
	
	
}
