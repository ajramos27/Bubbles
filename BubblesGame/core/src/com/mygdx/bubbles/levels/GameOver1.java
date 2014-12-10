package com.mygdx.bubbles.levels;

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
import com.mygdx.bubbles.screens.AbstractScreen;
import com.mygdx.bubbles.screens.ModeScreen;

public class GameOver1 extends AbstractScreen {

	float time;
	int n;
	Table table = super.getTable();
	boolean classic=false, arcade=false, plus=false;
	
	public GameOver1(Bubbles game, float counter, float timeCounter) {
		super(game);
		this.time= (float) ((counter + timeCounter) - 0.1);
		classic=true;
		arcade=false;
		plus=false;
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public GameOver1(Bubbles game, int n) {
		super(game);
		this.n= n;
		arcade=true;
		classic=false;
		plus=false;
		
	}
	
	
	
	public GameOver1(Bubbles game, int n2, boolean v) {
		super(game);
		this.n= n2;
		arcade=false;
		classic=false;
		plus=v;
	}


	public void show(){
		super.show();
				
		
		table.clear();
		Texture back = new Texture("gameover.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		if(classic==true){		
		Label timer = new Label("" + time, getSkin());
		Label t= new Label("TIME:", getSkin());
		t.setFontScale(2);
		timer.setFontScale(3);
		table.add(t);
		table.row();
		table.add(timer).center();
		table.row();
		
		Button startButton = new Button(getSkin(),"start");
		startButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				game.setScreen(new ClassicGame(game));
			}
		});
		startButton.addAction(Actions.scaleTo(1f,1f,1f));
		stage.addActor(startButton);
		
		table.add(startButton).bottom();
		table.row();
		}
		
		if(arcade==true){
			Label number = new Label("" + n, getSkin());
			Label t= new Label("BUBBLES:", getSkin());
			t.setFontScale(2);
			number.setFontScale(3);
			table.add(t);
			table.row();
			table.add(number).center();
			table.row();
			
			if(arcade){
			Button startButton = new Button(getSkin(),"start");
			startButton.addListener(new ClickListener(){
				public void clicked(InputEvent event, float x, float y){
					game.setScreen(new ArcadeGame(game));
				}
			});
			startButton.addAction(Actions.scaleTo(1f,1f,1f));
			stage.addActor(startButton);
			
			table.add(startButton).bottom();
			table.row();
			}else{
				Button startButton = new Button(getSkin(),"start");
				startButton.addListener(new ClickListener(){
					public void clicked(InputEvent event, float x, float y){
						game.setScreen(new PlusGame(game));
					}
				});
				startButton.addAction(Actions.scaleTo(1f,1f,1f));
				stage.addActor(startButton);
				
				table.add(startButton).bottom();
				table.row();
			}
		}
		
		
		
		
		
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
