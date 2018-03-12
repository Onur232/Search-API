package com.example.service.saveservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.InstagramEntity;
import com.example.domain.TweetEntity;
import com.example.repository.InstagramRepository;
import com.example.repository.TweetRepository;

import twitter4j.Status;

@Service
public class InstagramSaveService {

	@Autowired
	private InstagramRepository instagramRepository;

	public void save(InstagramEntity instagramEntity) {
		instagramRepository.save(instagramEntity);
	}
	
	public void retrieveInstagramInformationFromMongoDb() {
		for (int i = 0; i < 2; i++) {
			System.out.println();
		}
		System.out.println("Instagram information retrieved from MongoDB");
		System.out.println("-------------------------------------------------");
		List<InstagramEntity> findAll = instagramRepository.findAll();
		for (InstagramEntity insta : findAll) {
			System.out.println(insta);
		}
	}
	
	
}
