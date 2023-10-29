package com.mygdx.game;

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
    private Sound dropSound;
    private Music rainMusic;

    public Lluvia(Texture gotaBuenaTexture, Texture gotaMalaTexture, Sound ss, Music mm) {
        this.rainMusic = mm;
        this.dropSound = ss;
        this.gotaBuenaTexture = gotaBuenaTexture;
        this.gotaMalaTexture = gotaMalaTexture;
    }

    public void crear() {
        gotas = new Array<>();
        crearGotaDeLluvia();
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearGotaDeLluvia() {
        float x = MathUtils.random(0, 800-64);
        float y = 480;
        if (MathUtils.random(1,10) < 5) {
            gotas.add(new GotaBuena(gotaBuenaTexture, x, y));
        } else {
            gotas.add(new GotaMala(gotaMalaTexture, x, y));
        }
        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Tarro tarro) {
        if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia();
    
        for (int i = 0; i < gotas.size; i++) {
            Gota gota = gotas.get(i);
            Rectangle position = gota.getPosition();
            position.y -= 300 * Gdx.graphics.getDeltaTime();
    
            if(position.y + 64 < 0) {
                gotas.removeIndex(i);
            } else if(gota.colisionaCon(tarro)) { 
                gota.actuar(tarro);
                if (gota instanceof GotaBuena) {
                    dropSound.play();
                } else if (tarro.getVidas() <= 0) {
                    return false;
                }
                gotas.removeIndex(i);
            }
        }
        return true;
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) {
        for (Gota gota : gotas) {
            gota.dibujar(batch);
        }
    }

    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }

    public void pausar() {
        rainMusic.stop();
    }

    public void continuar() {
        rainMusic.play();
    }
}
