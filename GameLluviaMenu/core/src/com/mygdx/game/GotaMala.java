package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class GotaMala extends Gota {
    public GotaMala(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void actuar(Tarro tarro) {
        tarro.dañar();
    }
}
