package com.mygdx.bubbles.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.bubbles.Bubbles;
import com.mygdx.bubbles.services.BubblesMusic;

public class MenuScreen extends AbstractScreen {
	
  	
	public MenuScreen(Bubbles game) {
		super(game);
		
	}
	
	@Override
	public void show(){
		super.show();
		
		game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
		
		Table table = super.getTable();
		table.clear();
		Texture back = new Texture("back.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		Image logo = new Image(game.getAssetManager().
				get("pack.atlas", TextureAtlas.class).
				findRegion("logo"));
		
		
		
		
		Button startButton = new Button(getSkin(),"play");
		startButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new ModeScreen(game));
			}
		});
		startButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(startButton);
		
		
		
		Button scoreButton = new Button( getSkin(),"score");
		scoreButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new ScoreScreen(game));
			}
		});
		scoreButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(scoreButton);
		
		
		
		
		Button optionsButton = new Button( getSkin(),"options");
		optionsButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new OptionsScreen(game));
			}
		});
		optionsButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(optionsButton);
		
		
		
		
		
		table.add(logo);
		table.row();
		table.add(startButton);
		table.row();
		table.add(scoreButton); 
		table.row();
		table.add(optionsButton);
		table.row();
		//table.add(musicButton).expand().bottom().left();
		
		
	}
	
	
	public void render(float delta){
		super.render(delta);
	}



}
