package com.education.coinman.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.control.CoinManController;

public class CoinMan extends GameObject {

    private CoinManController coinManController;

    public CoinMan(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        coinManController = new CoinManController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        coinManController.handle();
    }
}
