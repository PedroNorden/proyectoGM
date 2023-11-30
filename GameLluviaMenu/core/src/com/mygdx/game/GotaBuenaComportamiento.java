package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;

public class GotaBuenaComportamiento implements GotaComportamiento {

    public void ejecutarAccion(Gota gotaBuena, Tarro tarro, Sound sonido) {
        tarro.sumarPuntos(10);
        sonido.play();
    }
}
