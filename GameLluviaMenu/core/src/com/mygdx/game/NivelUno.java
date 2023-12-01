package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class NivelUno extends Nivel{

	private long lastDropTime;
	
	public NivelUno(final GameLluviaMenu game) {
		super(game);
	}
	
	@Override
	public void iniciarNivel() {
		
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public boolean actualizarMovimiento(Tarro tarro) {
		
		if(TimeUtils.nanoTime() - lastDropTime > 100000000) lluvia.crearGotaDeLluvia();
		
		for (int i = 0; i < lluvia.getGota().size; i++) {
            Gota gota = lluvia.getGota().get(i);
            Rectangle position = gota.getPosition();
            position.y -= 150 * Gdx.graphics.getDeltaTime();
    
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
