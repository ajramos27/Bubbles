package com.mygdx.bubbles.services;

public enum BubblesSound {
	
	POP1("pop1.ogg"),
	POP2("pop2.ogg");
	
	private final String fileName;
	
	private BubblesSound(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return fileName;
	}

}
