package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;

public class GotaMalaComportamiento implements GotaComportamiento {
	public void ejecutarAccion(Gota gotaMala, Tarro tarro, Sound sonido) {
		tarro.dañar();
		sonido.play();
	}
}
