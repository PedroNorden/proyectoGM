package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class GotaOro extends Gota{
	
	public GotaOro(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void actuar(Tarro tarro) {
        tarro.sumarVida();
    }
    
    @Override
    public boolean colisionaCon(Tarro tarro) {
    	return this.getPosition().overlaps(tarro.getArea());
    }
}
