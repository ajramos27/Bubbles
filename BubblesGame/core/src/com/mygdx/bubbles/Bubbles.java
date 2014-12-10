package com.mygdx.bubbles;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bubbles.screens.SplashScreen;
import com.mygdx.bubbles.services.MusicManager;
import com.mygdx.bubbles.services.PreferencesManager;
import com.mygdx.bubbles.services.ProfileManager;
import com.mygdx.bubbles.services.SoundManager;

public class Bubbles extends Game {
	
	public SpriteBatch batcher;
	
	private AssetManager manager = new AssetManager();
	private SoundManager soundManager;
	private MusicManager musicManager;
	private ProfileManager profileManager;
	private PreferencesManager preferencesManager;
		
	public AssetManager getAssetManager(){
			return manager;
		}
		
	public SoundManager getSoundManager(){
			return soundManager;
		}
		
	public MusicManager getMusicManager(){
			return musicManager;
		}
	
	public ProfileManager getProfileManager(){
			return profileManager;
		}
		
	public PreferencesManager getPreferencesManager(){
			return preferencesManager;
		}
		
	public Bubbles(){
			
	}
	
	
	
	@Override
	public void create () {
		preferencesManager = new PreferencesManager();
		profileManager = new ProfileManager();
		musicManager = new MusicManager(manager);
		soundManager = new SoundManager(manager);
		batcher = new SpriteBatch();
		
		setScreen(new SplashScreen(this));
	
	}
	
	public void render() {
		super.render();
	}
	
}
