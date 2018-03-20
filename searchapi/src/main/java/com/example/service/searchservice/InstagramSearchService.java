package com.example.service.searchservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.InstagramEntity;
import com.example.service.saveservice.InstagramSaveService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;



@Service
public class InstagramSearchService {
	
	
	private InstagramEntity instagramEntity;
	JSONObject jsonObject;
	
	@Autowired
	private InstagramSaveService instagramSaveService;


	public InstagramEntity getInstagramInformation() {
		try {

			Client client = Client.create();

//			WebResource webResource = client.resource("https://jsonplaceholder.typicode.com/albums");
			//yukardaki adres sample json çıktısı veriyor.
			String userId="351564405";
			String endpointString = "https://api.instagram.com/v1/users/self/?access_token=f0624";
			
			WebResource webResource = client.resource(endpointString);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			
			jsonObject=new JSONObject(output);
			String object = jsonObject.getString("data");
			JSONObject jsonObject2 = jsonObject.getJSONObject("data");
			System.out.println(jsonObject2);
			String object2 = jsonObject2.getString("id");
			System.out.println(object2);
			
			instagramEntity = new InstagramEntity();
			instagramEntity.setId(jsonObject2.getString("id"));
			instagramEntity.setText("bio");
			instagramEntity.setCreatedAt(new Date());
			instagramEntity.setUsername(jsonObject2.getString("username"));
			instagramEntity.setProfilePicture(jsonObject2.getString("profile_picture"));
			instagramEntity.setFullName(jsonObject2.getString("full_name"));
			instagramSaveService.save(instagramEntity);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return instagramEntity;
		
	}


	public void retrieveInstagramInformationFromMongoDb() {
		instagramSaveService.retrieveInstagramInformationFromMongoDb();
		
		
	}

}
