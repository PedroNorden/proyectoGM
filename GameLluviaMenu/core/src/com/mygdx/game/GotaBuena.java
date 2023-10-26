package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class GotaBuena extends Gota {
    public GotaBuena(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void actuar(Tarro tarro) {
        tarro.sumarPuntos(10);
    }
}
