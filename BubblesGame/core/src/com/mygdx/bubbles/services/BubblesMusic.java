package com.mygdx.bubbles.services;

import com.badlogic.gdx.audio.Music;

public enum BubblesMusic {

	TITLE_MUSIC("copycat.mp3");
	
	private Music musicResource;
	private final String fileName;
	
	
	private BubblesMusic(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return fileName;
	}

	public Music getMusicResource() {
		return musicResource;
	}

	public void setMusicResource(Music musicResource) {
		this.musicResource = musicResource;
	}
}
