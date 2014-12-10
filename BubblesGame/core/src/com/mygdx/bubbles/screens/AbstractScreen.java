package com.mygdx.bubbles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.bubbles.Bubbles;

public class AbstractScreen implements Screen {
	
	public static final int VIEWPORT_WIDTH = 768;
	public static final int VIEWPORT_HEIGHT = 1024;
	
	protected final Bubbles game;
	protected final Stage stage;
	
	private Skin skin;
	//private TextureAtlas atlas;
	private Table table;
	
	public AbstractScreen(Bubbles game){
		this.game = game;
		this.stage = new Stage(new StretchViewport(VIEWPORT_WIDTH,VIEWPORT_HEIGHT));
	}
		
	protected Skin getSkin(){
		if (skin==null){
			skin = new Skin(Gdx.files.internal("pack.json"), new TextureAtlas("pack.atlas"));
			
		}
		return skin;
	}	
	
	protected Table getTable(){
		if (table==null){
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
		}
		return table;
		
	} 
	
	@Override
	public void render(float delta) {
		
		stage.act(delta);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		
	}
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
		
	}
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	

}
