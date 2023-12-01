package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaMala extends Gota {
	
	private GotaMalaComportamiento estrategia;
	
    public GotaMala(Texture texture, float x, float y, Sound sonido,  GotaMalaComportamiento estrategia) {
        super(texture, x, y, sonido);
        this.estrategia = estrategia;
    }

    @Override
    public void actuar(Tarro tarro) {
    	estrategia.ejecutarAccion(this, tarro, this.getSonido());
    }
    
    @Override
    public boolean colisionaCon(Tarro tarro) {
    	return this.getPosition().overlaps(tarro.getArea());
    }
}
