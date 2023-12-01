package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Estrella extends Gota{
    public Estrella(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void actuar(Tarro tarro) {
        //tarro.sumarPuntos(10);
    }
    
    @Override
    public boolean colisionaCon(Tarro tarro) {
    	return this.getPosition().overlaps(tarro.getArea());
    }
}
