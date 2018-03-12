package com.example.api;


import com.example.adapters.SearchAdapter;
import com.example.converter.InputConverter;
import com.example.converter.OutputConverter;

public class SearchAPI {
	
	private SearchAdapter searchAdapter;
	private InputConverter inputConverter;
	private OutputConverter outputConverter;
	private SearchOutput searchOutput;
	
	SearchAPI(SearchBuilder builder) {
		this.searchAdapter=builder.searchAdapter;
		this.inputConverter=builder.inputConverter;
		this.outputConverter=builder.outputConverter;
	}

	public SearchOutput search(SearchInput searchInput) {
		return searchOutput;
	}
}
