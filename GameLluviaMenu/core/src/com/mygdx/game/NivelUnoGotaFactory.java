package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;


public class NivelUnoGotaFactory implements GotaFactory{
	
	private Texture gotaBuenaTexture;
    private Texture gotaMalaTexture;
    private Sound dropSound;
    private Sound badDropSound;
    
    public NivelUnoGotaFactory(Texture gotaBuenaTexture, Texture gotaMalaTexture, Sound dropSound, Sound badDropSound) {
    	this.gotaBuenaTexture = gotaBuenaTexture;
    	this.gotaMalaTexture = gotaMalaTexture;
    	this.dropSound = dropSound;
    	this.badDropSound = badDropSound;
    }
	
	public Gota createGota() {
		int randomValue = MathUtils.random(1, 100);
		float x = MathUtils.random(0, 800 - 64);
        float y = 480;
        
		if(randomValue <= 60) {
			return new GotaBuena(gotaBuenaTexture, x, y, dropSound, new GotaBuenaComportamiento());
		} else return new GotaMala(gotaMalaTexture, x, y, badDropSound, new GotaMalaComportamiento());
	}
}
