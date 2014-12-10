package com.mygdx.bubbles.services;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;

public class MusicManager {
private boolean enabled = true;
	
	private BubblesMusic musicBeingPlayed;
	
	private AssetManager manager;
	
	public MusicManager(AssetManager manager){
		this.manager = manager;
	}
	
	public void play(BubblesMusic music ){
		if (!enabled) return;
		
		//if (musicBeingPlayed==music) return;
		
		//stop();
		
		Music musicResource = manager.get(music.getFileName());
		
		if (musicResource==null) return;
				
		musicResource.setVolume(0.5f);
		musicResource.setLooping(true);
		musicResource.play();
		
		musicBeingPlayed = music;
		musicBeingPlayed.setMusicResource(musicResource);
		
		
		
	}
	
	public void stop(){
		if (musicBeingPlayed==null) return;
		
		Music musicResource = musicBeingPlayed.getMusicResource();
		musicResource.stop();
		
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled){
			if (musicBeingPlayed!=null)
				play(musicBeingPlayed);
		}else{
			stop();
		}
	}

}
