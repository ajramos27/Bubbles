package com.mygdx.bubbles.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.bubbles.Bubbles;
import com.mygdx.bubbles.screens.AbstractScreen;
import com.mygdx.bubbles.services.BubblesSound;


public class ClassicGame extends AbstractScreen {
	
	private ActorBubble bubble;
	private int num=50, n=num;
	public float counter, timeCounter;
	private ActorBubble[] burbujas = new ActorBubble[num];
	Table table = super.getTable();
	Table topTable = new Table();
	Label labelNum = new Label("Bubbles: " + n, getSkin());
	Label timer = new Label("     Time: " + (counter + timeCounter), getSkin());
	
	
	
	public ClassicGame(final Bubbles game) {
		super(game);		
		
	}
	
	public void show(){
		super.show();
		Gdx.input.setInputProcessor(stage);
		
		
		
		table.clear();
		Texture back = new Texture("back.jpg");
		back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(back,0,0,768,1024)));
		
		topTable.clear();
		topTable.add(labelNum);
		topTable.add(timer);
		topTable.row();
		table.clear();
		table.add(topTable).expand().top().left();
		
		for (int j=0;j<num;j++){
			
		burbujas[j]=new ActorBubble();
		
		}
		
		for (int j=0;j<num; j++){
			bubble= burbujas[j];
			stage.addActor(bubble);
		}
		
		for (int j=0;j<num;j++){
			final int k = j;
			//System.out.println(k);
			burbujas[j].addCaptureListener(new InputListener() {
				@Override
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					burbujas[k].addAction(Actions.removeActor());
					n= n-1;
									
					game.getSoundManager().play(BubblesSound.POP1);
					return true;
				}
			});
		}
		
		
		
	}
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		stage.draw();
		
		
		timeCounter += Gdx.graphics.getDeltaTime();
		if(timeCounter >= 1.0f){
		timeCounter = 0;
		counter++;
		}
		labelNum = new Label("Bubbles: " + n, getSkin());
		timer = new Label("     Time: " + (counter+ timeCounter), getSkin());
		
		topTable.clear();
		topTable.add(labelNum);
		topTable.add(timer).right();
		table.clear();
		table.add(topTable).expand().top().left();
		
		if(n==0){
			game.setScreen(new GameOver1(game, counter, timeCounter));
		}
		stage.act();
	
}
	

	
	
@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
				
	}
}

