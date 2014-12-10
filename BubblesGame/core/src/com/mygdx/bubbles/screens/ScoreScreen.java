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
import com.mygdx.bubbles.services.BubblesMusic;

public class ScoreScreen extends AbstractScreen{

	public ScoreScreen(Bubbles game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public void show(){
		super.show();
	game.getMusicManager().play(BubblesMusic.TITLE_MUSIC);
	
	Table table = super.getTable();
	table.clear();
	Texture back = new Texture("score.jpg");
	back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
	
	
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
}
