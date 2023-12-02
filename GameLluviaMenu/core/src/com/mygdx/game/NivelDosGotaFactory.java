package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;


public class NivelDosGotaFactory implements GotaFactory{
	
	private Texture gotaBuenaTexture;
    private Texture gotaMalaTexture;
    private Texture gotaOroTexture;
    private Sound dropSound;
    private Sound badDropSound;
    private Sound dropGoldSong2;
    
    public NivelDosGotaFactory(Texture gotaBuenaTexture, Texture gotaMalaTexture, Texture gotaOroTexture, Sound dropSound, Sound badDropSound, Sound dropGoldSong2) {
    	this.gotaBuenaTexture = gotaBuenaTexture;
    	this.gotaMalaTexture = gotaMalaTexture;
    	this.gotaOroTexture = gotaOroTexture;
    	this.dropSound = dropSound;
    	this.badDropSound = badDropSound;
    	this.dropGoldSong2 = dropGoldSong2;
    }
	
	public Gota createGota() {
		int randomValue = MathUtils.random(1, 100);
		float x = MathUtils.random(0, 800 - 64);
        float y = 480;
        
		if(randomValue <= 55) {
			return new GotaBuena(gotaBuenaTexture, x, y, dropSound, new GotaBuenaComportamiento());
		} else if(randomValue <= 95) {
			return new GotaMala(gotaMalaTexture, x, y, badDropSound, new GotaMalaComportamiento());
		}
		else return new GotaOro(gotaOroTexture, x, y, dropGoldSong2, new GotaOroComportamiento());
			
	}
}
