package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Estrella implements Colisionable{
	
	private Rectangle position;
	private Texture texture;
	
	public Estrella(Texture texture, float x, float y) {
		
		this.texture = texture;
        this.position = new Rectangle(x, y, 34, 52);

    }

	public Rectangle getPosition() {
        return position;
    }
	
	public void dibujar(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
	
    public void actuar(Tarro tarro) {
        tarro.sumarPuntos(30);
    }
    
    public boolean colisionaCon(Tarro tarro) {
    	return this.getPosition().overlaps(tarro.getArea());
    }
	
}
