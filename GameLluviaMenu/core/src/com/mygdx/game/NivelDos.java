package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class NivelDos extends Nivel{
	
	private GotaFactory factory;
	private long lastDropTime;
	private Music musica;
	
	public NivelDos(final GameLluviaMenu game) {
		super(game);
		Texture gota = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
        Texture gotaOro = new Texture(Gdx.files.internal("dropGold.png"));
        
        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Sound badDropSound = Gdx.audio.newSound(Gdx.files.internal("dropBadSong.wav"));
        Sound goldDropSound = Gdx.audio.newSound(Gdx.files.internal("dropGoldSong2.wav"));
        musica = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        this.factory = new NivelDosGotaFactory(gota, gotaMala, gotaOro, dropSound, badDropSound, goldDropSound);
		crearGotas();
	}
	
	@Override
	public void iniciarNivel() {
		musica.setLooping(true);
		musica.play();
	}
	
	public void destruir() {
		
	}
	
	public void crearGotas() {
		Gota gota = factory.createGota();
		super.addGotas(gota);
		lastDropTime = TimeUtils.nanoTime();
	}
	
	
	@Override
	public boolean actualizarMovimiento(Tarro tarro) {
		
		if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotas();
		
		for (int i = 0; i < super.getGotas().size; i++) {
            Gota gota = super.getGotas().get(i);
            Rectangle position = gota.getPosition();
            position.y -= 300 * Gdx.graphics.getDeltaTime();
    
            if(position.y + 64 < 0) {
            	super.getGotas().removeIndex(i);
            } else if(gota.colisionaCon(tarro)) {
            	gota.actuar(tarro);
            	if (tarro.getVidas() <= 0) {
                    return false;
                }
            	if(tarro.getPuntos() >= 300)
            	{
            		destruir();
            		((GameLluviaMenu) game).avanzarAlSiguienteNivel();
            	}
            	super.getGotas().removeIndex(i);
            }
		}
		return true;
	}
	
}
