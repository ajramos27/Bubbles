package com.mygdx.bubbles.levels;

import java.util.Random;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorBad extends Actor {

	private Texture badbubble;
	private TextureRegion mybad;
	private static final int MAX_X = 700;
	private static final int MAX_Y = 750;
	private float dx, dy;	
	private static final int[] deltas = {-2,-1,0,1,2};
	private Random random = new Random();
		
	
	public ActorBad() {
		badbubble = new Texture("bbad.png");
		mybad = new TextureRegion(badbubble);
		setSize(100, 100);
		this.setPosition(random.nextInt(MAX_X), random.nextInt(MAX_Y));
		this.dx = deltas[random.nextInt(deltas.length)];
		this.dy = deltas[random.nextInt(deltas.length)];
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color col = getColor();
		batch.setColor(col.r, col.g, col.b, col.a * parentAlpha);
		batch.draw(mybad, getX(), getY(),
				getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
		this.setX(this.getX()+dx);
		this.setY(this.getY()+dy);
		if (getX()>MAX_X || getX()<0)
			this.dx*=-1;
		if (getY()>MAX_Y || getY()<0)
			this.dy*=-1;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	

	
}
