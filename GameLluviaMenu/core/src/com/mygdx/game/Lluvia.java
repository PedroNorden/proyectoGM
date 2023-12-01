/*package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.Rectangle;

public class Lluvia {
    private Array<Gota> gotas;
    private long lastDropTime;
    private Texture gotaBuenaTexture;
    private Texture gotaMalaTexture;
    private Texture gotaOroTexture;
    private Texture EstrellaTexture;
    
    private Sound dropSound;
    private Sound badDropSound;
    private Sound goldDropSound;
    private Music rainMusic;

    public Lluvia(Texture gotaBuenaTexture, Texture gotaMalaTexture, Texture gotaOroTexture,Texture EstrellaTexture, Sound ss, Sound ssBad, Sound ssGold, Music mm) {
    	this.rainMusic = mm;
    	this.dropSound = ss;
    	this.badDropSound = ssBad;
    	this.goldDropSound = ssGold;
    	this.gotaBuenaTexture = gotaBuenaTexture;
    	this.gotaMalaTexture = gotaMalaTexture;
    	this.gotaOroTexture = gotaOroTexture;
    	this.EstrellaTexture = EstrellaTexture;
    }

    public void crear() {
        gotas = new Array<>();
        crearGotaDeLluvia();
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    public void crearGotaDeLluvia() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;
        

        int randomValue = MathUtils.random(1, 10);

        if (randomValue <= 3) {
        	gotas.add(new GotaBuena(gotaBuenaTexture, x, y, dropSound, new GotaBuenaComportamiento()));
        } else if (randomValue <= 9) {
        	gotas.add(new GotaMala(gotaMalaTexture, x, y, badDropSound, new GotaMalaComportamiento()));
        } else {
        	gotas.add(new GotaOro(gotaOroTexture, x, y, goldDropSound, new GotaOroComportamiento()));
        }

        lastDropTime = TimeUtils.nanoTime();
        
    }

 
    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }
    
    public Array<Gota> getGota(){
    	return gotas;
    }
    

    public void pausar() {
        rainMusic.stop();
    }

    public void continuar() {
        rainMusic.play();
    }
}*/
