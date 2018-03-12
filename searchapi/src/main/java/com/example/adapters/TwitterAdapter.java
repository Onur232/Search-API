package com.example.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.api.SearchAPI;
import com.example.api.SearchBuilder;
import com.example.api.SearchInput;
import com.example.api.SearchOutput;
import com.example.bootstrap.SearchAPIBootstrap;
import com.example.converter.InputConverter;
import com.example.converter.OutputConverter;
import com.example.enums.SearchType;


@Component
public class TwitterAdapter implements SearchAdapter{
	
	private SearchAPIBootstrap searchAPIBootstrap;
	private SearchBuilder searchBuilder;
	
	@Autowired
	public void setSearchAPIBootstrap(SearchAPIBootstrap searchAPIBootstrap) {
		this.searchAPIBootstrap = searchAPIBootstrap;
	}
	
	@Autowired
	public void setSearchBuilder(SearchBuilder searchBuilder) {
		this.searchBuilder = searchBuilder;
	}

	
	public SearchOutput search(SearchInput input, SearchType searchType) {
		SearchAdapter adapter = searchAPIBootstrap.getAdapters().get(searchType.getValue());
		InputConverter inputConverter = searchAPIBootstrap.getInputConverters().get(searchType.getValue());
		OutputConverter outputConverter = searchAPIBootstrap.getOutputConverters().get(searchType.getValue());
		SearchAPI api=searchBuilder
		.adapter(adapter)
		.inputConverter(inputConverter)
		.outputConverter(outputConverter)
		.build();
		return api.search(input);
		}
	
}
