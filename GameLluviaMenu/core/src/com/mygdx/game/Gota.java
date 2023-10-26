package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota {
    protected Rectangle position;
    protected Texture texture;

    public Gota(Texture texture, float x, float y) {
        this.texture = texture;
        this.position = new Rectangle(x, y, 64, 64);
    }

    public Rectangle getPosition() {
        return position;
    }

    public abstract void actuar(Tarro tarro);

    public void dibujar(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}
