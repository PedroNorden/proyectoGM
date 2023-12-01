package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaBuena extends Gota {
	
	private GotaBuenaComportamiento estrategia;
	
    public GotaBuena(Texture texture, float x, float y, Sound sonido, GotaBuenaComportamiento estrategia) {
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
