package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.InstagramEntity;

public interface InstagramRepository extends MongoRepository<InstagramEntity, String>{

}
