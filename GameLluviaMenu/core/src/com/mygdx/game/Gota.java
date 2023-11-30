package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota{
    private Rectangle position;
    private Texture texture;
    private Sound sonido;

    public Gota(Texture texture, float x, float y, Sound sonido) {
        this.texture = texture;
        this.position = new Rectangle(x, y, 34, 52);
        this.sonido = sonido;
    }

    public Rectangle getPosition() {
        return position;
    }

    public Sound getSonido() {
        return sonido;
    }

    public abstract void actuar(Tarro tarro);

    public void dibujar(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }


    public abstract boolean colisionaCon(Tarro objeto);

}
