package com.mygdx.bubbles.screens;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.bubbles.Bubbles;
import com.mygdx.bubbles.services.BubblesMusic;
import com.mygdx.bubbles.services.BubblesSound;

public class SplashScreen extends AbstractScreen {

	public SplashScreen(Bubbles game) {
		super(game);
		
	}
	
	@Override
	public void show(){
		super.show();
		
		Table table = super.getTable();
		
		Texture back = new Texture("loading.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		
		game.getAssetManager().load("pack.atlas", com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
		//game.getAssetManager().load("fonts/default-32.fnt",BitmapFont.class);
		
		//game.getAssetManager().load(MatyasSound.CLICK.getFileName(), Sound.class);
		game.getAssetManager().load(BubblesMusic.TITLE_MUSIC.getFileName(), Music.class);
		game.getAssetManager().load(BubblesSound.POP1.getFileName(), Sound.class);
		game.getAssetManager().load(BubblesSound.POP2.getFileName(), Sound.class);
		
		
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
		if (game.getAssetManager().update()){
			stage.addAction(Actions.sequence(Actions.delay(0.25f),
											Actions.fadeOut(0.75f),
											new Action(){
												public boolean act(float delta){
													game.setScreen(new MenuScreen(game));
													return true;
												}
											}));
		}
		
	}
	
	
	
}
