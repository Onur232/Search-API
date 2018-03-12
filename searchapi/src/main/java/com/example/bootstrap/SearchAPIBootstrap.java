package com.example.bootstrap;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.adapters.InstagramAdapter;
import com.example.adapters.SearchAdapter;
import com.example.adapters.TwitterAdapter;
import com.example.converter.InputConverter;
import com.example.converter.OutputConverter;

@Component
public class SearchAPIBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private List<SearchAdapter> adapters=new ArrayList<>();
	private List<InputConverter> inputConverters=new ArrayList<>();
	private List<OutputConverter> outputConverters=new ArrayList<>();
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadAdapters();
		loadInputConverters();
		loadOutputConverters();
	}
	
	private void loadAdapters() {
		TwitterAdapter twitterAdapter=new TwitterAdapter();
		InstagramAdapter instagramAdapter=new InstagramAdapter();
		adapters.add(twitterAdapter);
		adapters.add(instagramAdapter);
	}
	
	private void loadInputConverters() {
		
	}
	
	private void loadOutputConverters() {
		
	}

	public List<SearchAdapter> getAdapters() {
		return adapters;
	}

	public List<InputConverter> getInputConverters() {
		return inputConverters;
	}

	public List<OutputConverter> getOutputConverters() {
		return outputConverters;
	}
	

}
