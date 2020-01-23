package com.education.coinman.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.control.MovingObjectController;

public class Bomb extends GameObject {
    private MovingObjectController bombController;

    public Bomb(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        bombController = new MovingObjectController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        bombController.handle("Bomb");
    }
}
