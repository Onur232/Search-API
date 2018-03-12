package com.example.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.InstagramEntity;
import com.example.service.searchservice.InstagramSearchService;

@RestController
public class InstagramRestController {
	
	@Autowired
	private InstagramSearchService instagramSearchService;
	
	// Query cümlesi = http://localhost:8080/instagram
	
		@RequestMapping(value= "/instagram",produces= {"application/json"} ,method=RequestMethod.GET)
		public InstagramEntity getInstagramInformation(Model model,RedirectAttributes redirectAttributes) {
			InstagramEntity instagramEntity= instagramSearchService.getInstagramInformation();
			System.out.println("Instagram informations are written to database"); 
			instagramSearchService.retrieveInstagramInformationFromMongoDb();
			return instagramEntity;
		}
	

}
