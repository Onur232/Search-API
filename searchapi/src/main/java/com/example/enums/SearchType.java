package com.example.enums;


public enum SearchType {
	
	INSTAGRAM(0),
	TWITTER(1);
	
	private final int value;
	
	SearchType(final int newValue) {
		value=newValue;
	}
	
	public int getValue() {
		return value;
	}
	

}
