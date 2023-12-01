package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class NivelDos extends Nivel{
	
	private Texture gota;
	private Texture gotaMala;
	private Texture gotaOro;
	private Texture Estrella;
	private Sound dropSound;
	private Sound badDropSound;
	private Sound goldDropSound;
	private Music musica;
	
	public NivelDos(final GameLluviaMenu game) {
		super(game);
		gota = new Texture(Gdx.files.internal("drop.png"));
        gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
        gotaOro = new Texture(Gdx.files.internal("dropGold.png"));
        Estrella =  new Texture(Gdx.files.internal("StarLluvia.png"));
        
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        badDropSound = Gdx.audio.newSound(Gdx.files.internal("dropBadSong.wav"));
        goldDropSound = Gdx.audio.newSound(Gdx.files.internal("dropGoldSong2.wav"));
        musica = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        
	}
	
	@Override
	public void iniciarNivel() {
		this.lluvia = new Lluvia(gota, gotaMala, gotaOro, Estrella, dropSound, badDropSound, goldDropSound, musica);
	}
	
	@Override
	public boolean actualizarMovimiento(Tarro tarro) {
		for (int i = 0; i < lluvia.getGota().size; i++) {
            Gota gota = lluvia.getGota().get(i);
            Rectangle position = gota.getPosition();
            position.y -= 300 * Gdx.graphics.getDeltaTime();
    
            if(position.y + 64 < 0) {
                lluvia.getGota().removeIndex(i);
            } else if(gota.colisionaCon(tarro)) {
            	gota.actuar(tarro);
            	if (tarro.getVidas() <= 0) {
                    return false;
                }
            	lluvia.getGota().removeIndex(i);
            }
    
		}
		return true;
	}
	
	@Override
    public void actualizarDibujoLluvia(SpriteBatch batch) {
        for (Gota gota : lluvia.getGota()) {
            gota.dibujar(batch);
        }
    }
	
}
