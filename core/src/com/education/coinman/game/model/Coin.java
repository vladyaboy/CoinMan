package com.education.coinman.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.control.CoinController;

public class Coin extends GameObject {
    private CoinController coinController;

    public Coin(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        coinController = new CoinController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        coinController.handle();
    }
}
