package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.utils.Timer;

public class EstrellaComportamiento implements GotaComportamiento {

    public void ejecutarAccion(Gota estrella, final Tarro tarro, Sound sonido) {
        
        final int vidasActuales = tarro.getVidas();

        
        tarro.setVidas(100);

        sonido.play();

        
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                
                tarro.setVidas(vidasActuales);
            }
        }, 5); 
    }
}