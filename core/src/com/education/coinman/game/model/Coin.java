package com.education.coinman.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.control.MovingObjectController;
import com.education.coinman.game.control.MovingObjectController;

public class Coin extends GameObject {
    private MovingObjectController coinController;

    public Coin(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        coinController = new MovingObjectController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        coinController.handle("Coin");
    }
}
