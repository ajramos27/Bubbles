package com.mygdx.bubbles.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.bubbles.Bubbles;
import com.mygdx.bubbles.levels.ArcadeGame;
import com.mygdx.bubbles.levels.ClassicGame;
import com.mygdx.bubbles.levels.PlusGame;
import com.mygdx.bubbles.services.BubblesMusic;

public class HelpScreen extends AbstractScreen{

	private String mode;
	
	public HelpScreen(Bubbles game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	public HelpScreen(Bubbles game, String string) {
		super(game);
		this.mode= string;
	}

	public void show(){
		super.show();
		
		game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
		Table table = super.getTable();
		table.clear();
		
		if(mode.equals("classic")){
			
			
			Texture back = new Texture("ayuda1.jpg");
			back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
			
		}
		
		if(mode.equals("arcade")){
			
			
			Texture back = new Texture("ayuda2.jpg");
			back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
			
		}
		
		if(mode.equals("plus")){
			
			Texture back = new Texture("ayuda3.jpg");
			back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
			
		}
		
		
		Button startButton = new Button(getSkin(),"start");
		startButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				if(mode.equals("classic")) game.setScreen(new ClassicGame(game));
				if(mode.equals("arcade")) game.setScreen(new ArcadeGame(game));
				if(mode.equals("plus")) game.setScreen(new PlusGame(game));
			}
		});
		startButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(startButton);
		
		table.add(startButton).expand().bottom();
		table.row();
		
		
		
		Button returnButton = new Button( getSkin(),"return");
		returnButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new ModeScreen(game));
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
