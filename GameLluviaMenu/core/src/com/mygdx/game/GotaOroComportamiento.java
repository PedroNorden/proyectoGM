package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;

public class GotaOroComportamiento implements GotaComportamiento {
	public void ejecutarAccion(Gota gotaOro, Tarro tarro, Sound sonido) {
		tarro.sumarVida();
		sonido.play();
	}
}
