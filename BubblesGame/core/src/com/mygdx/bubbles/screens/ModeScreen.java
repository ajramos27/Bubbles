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

public class ModeScreen extends AbstractScreen {

	public ModeScreen(Bubbles game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void show(){
		super.show();
		
		game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
		
		Table table = super.getTable();
		table.clear();
		Texture back = new Texture("fondo.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		Image logo = new Image(game.getAssetManager().
				get("pack.atlas", TextureAtlas.class).
				findRegion("logo"));
		
		table.add(logo).top().left();
		table.row();		
		
		Button classicButton = new Button(getSkin(),"classic");
		classicButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new HelpScreen(game, "classic"));
			}
		});
		classicButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(classicButton);
		
		table.add(classicButton);
		table.row();
		
		Button arcadeButton = new Button( getSkin(),"arcade");
		arcadeButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new HelpScreen(game, "arcade"));
			}
		});
		arcadeButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(arcadeButton);
		
		
		table.add(arcadeButton); 
		table.row();
		
		Button plusButton = new Button( getSkin(),"plus");
		plusButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new HelpScreen(game, "plus"));
			}
		});
		plusButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(plusButton);
		
		table.add(plusButton);
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
