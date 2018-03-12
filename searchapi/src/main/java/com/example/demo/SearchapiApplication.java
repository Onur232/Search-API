package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.controller.TwitterRestController;
import com.example.domain.TweetEntity;
import com.example.repository.TweetRepository;
import com.example.service.searchservice.TweetSearchService;


/**
 * @author Onur Tas
 * An API for search at various social media sites
 *
 */
@SpringBootApplication
//@ComponentScan(basePackageClasses=IndexController.class)
//@ComponentScan(basePackageClasses = {IndexController.class, Tweet.class , TweetSearchService.class, TweetServiceJpaDaoImpl.class}  )
@EnableMongoRepositories(basePackageClasses=TweetRepository.class)
@ComponentScan("com.example")
@EntityScan("com.example.domain")
public class SearchapiApplication {
	
	// Query cümlesi = http://localhost:8080/tweets?queryString=galatasaray

	public static void main(String[] args) {
		SpringApplication.run(SearchapiApplication.class, args);
	}
}
