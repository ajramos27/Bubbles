package com.mygdx.bubbles.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.bubbles.Bubbles;
import com.mygdx.bubbles.services.BubblesMusic;

public class OptionsScreen extends AbstractScreen {

	public OptionsScreen(Bubbles game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public void show(){
		super.show();
		
		game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
		
		Table table = super.getTable();
		table.clear();
		Texture back = new Texture("fondo.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		Label music= new Label("MUSIC", getSkin());
		music.setFontScale(2);
		table.add(music);
		table.row();
		
		
		Button onButton = new Button(getSkin(),"musicaon");
		onButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
				game.getMusicManager().setEnabled(true);
				
				
			}
		});
		onButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(onButton);
		
		table.add(onButton);
		table.row();
		
		Button offButton = new Button( getSkin(),"musicaoff");
		offButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.getMusicManager().setEnabled(false);
			}
		});
		offButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(offButton);
		
		
		table.add(offButton); 
		table.row();
		
				
		
		Button returnButton = new Button( getSkin(),"return");
		returnButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new MenuScreen(game));
			}
		});
		returnButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(returnButton);
		
		table.add(returnButton);
		table.row();
		
				
	}
	
	
	public void render(float delta){
		super.render(delta);
	}


	

}
