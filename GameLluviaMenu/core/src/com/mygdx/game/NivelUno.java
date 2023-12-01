package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class NivelUno extends Nivel{
	private GotaFactory factory;
	private long lastDropTime;
	private Music rainMusic;
	
	public NivelUno(final GameLluviaMenu game) {
		super(game);
		Texture gotaBuenaTexture = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMalaTexture = new Texture(Gdx.files.internal("dropBad.png"));
        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Sound badDropSound = Gdx.audio.newSound(Gdx.files.internal("dropBadSong.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		this.factory = new NivelUnoGotaFactory(gotaBuenaTexture, gotaMalaTexture, dropSound, badDropSound);
		crearGotas();
		
	}
	
	@Override
	public void iniciarNivel() {
		rainMusic.setLooping(true);
		rainMusic.play();
        
	}
	
	public void destruir() {
        rainMusic.dispose();
	}
	
	public void crearGotas() {
		Gota gota = factory.createGota();
		super.addGotas(gota);
		lastDropTime = TimeUtils.nanoTime();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            crearGotas();
        }
	}

	@Override
	public boolean actualizarMovimiento(Tarro tarro) {
		
		if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotas();
		
		for (int i = 0; i < super.getGotas().size; i++) {
            Gota gota = super.getGotas().get(i);
            Rectangle position = gota.getPosition();
            position.y -= 150 * Gdx.graphics.getDeltaTime();
    
            if(position.y + 64 < 0) {
            	super.getGotas().removeIndex(i);
            } else if(gota.colisionaCon(tarro)) {
            	gota.actuar(tarro);
            	if (tarro.getVidas() <= 0) {
                    return false;
                }
            	super.getGotas().removeIndex(i);
            }
		}
		return true;
	}
	

}
