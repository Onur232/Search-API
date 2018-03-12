package com.example.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.TweetEntity;

import twitter4j.Status;

@RepositoryRestResource(collectionResourceRel="tweets", path="tweets")
public interface TweetRepository extends MongoRepository<TweetEntity, String>{


//	List<Tweet> findByText(@Param("query") String query);
	 
//	public List<Tweet> saveOrUpdate(List<Status> sList);
	
}
