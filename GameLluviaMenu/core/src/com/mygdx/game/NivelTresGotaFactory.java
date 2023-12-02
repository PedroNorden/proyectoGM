package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;


public class NivelTresGotaFactory implements GotaFactory{
	
	private Texture gotaBuenaTexture;
    private Texture gotaMalaTexture;
    private Texture gotaOroTexture;
    private Texture estrellaTexture;
    private Sound dropSound;
    private Sound badDropSound;
    private Sound dropGoldSong2;
    private Sound estrellaSound;
    
    public NivelTresGotaFactory(Texture gotaBuenaTexture, Texture gotaMalaTexture, Texture gotaOroTexture, Texture estrellaTexture, Sound dropSound, Sound badDropSound, Sound dropGoldSong2, Sound estrellaSound) {
    	this.gotaBuenaTexture = gotaBuenaTexture;
    	this.gotaMalaTexture = gotaMalaTexture;
    	this.gotaOroTexture = gotaOroTexture;
    	this.estrellaTexture = estrellaTexture;
    	this.dropSound = dropSound;
    	this.badDropSound = badDropSound;
    	this.dropGoldSong2 = dropGoldSong2;
    	this.estrellaSound = estrellaSound;
    }
	
	public Gota createGota() {
		int randomValue = MathUtils.random(1, 100);
		float x = MathUtils.random(0, 800 - 64);
        float y = 480;
        
		if(randomValue <= 45) {
			return new GotaBuena(gotaBuenaTexture, x, y, dropSound, new GotaBuenaComportamiento());
		} else if(randomValue <= 94) {
			return new GotaMala(gotaMalaTexture, x, y, badDropSound, new GotaMalaComportamiento());
		}
		else if(randomValue <= 99) {
			return new GotaOro(gotaOroTexture, x, y, dropGoldSong2, new GotaOroComportamiento());
		}
		else return new Estrella(estrellaTexture, x, y, estrellaSound, new EstrellaComportamiento());
			
	}
}
