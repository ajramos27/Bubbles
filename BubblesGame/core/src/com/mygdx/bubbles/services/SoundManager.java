package com.mygdx.bubbles.services;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	
	private float volume = 1f;
	private boolean enabled = true;
	
	private AssetManager manager;
	
	public SoundManager(AssetManager manager){
		this.manager = manager;
	}
	
	public void play(BubblesSound sound){
		if (!enabled) return;
		
		Sound soundToPlay = manager.get(sound.getFileName());
		if (soundToPlay==null) return;
		
		soundToPlay.play(volume);
		
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
