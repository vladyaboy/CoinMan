package com.education.coinman.game.control;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.education.coinman.game.view.GameScreen;

public class CoinManController {

    private Polygon coinManBounds;
    private float gravity = 0.6f;
    private float velocity = 0;
    private float maxJumps = 2;
    private float jumpCount = 0;

    public CoinManController(Polygon coinManBounds) {
        this.coinManBounds = coinManBounds;
    }

    public void handle() {
        handeJump();
    }

    private void handeJump() {
        float coinManY = coinManBounds.getY();
        if(Gdx.input.justTouched()) {
            if(jumpCount < maxJumps) {
                jumpCount++;
                velocity = -20;
            }
        }
        velocity += gravity;
        coinManY -= velocity;

        if(coinManY <= 0) {
            coinManY = 0;
            jumpCount = 0;
        }
        coinManBounds.setPosition(coinManBounds.getX(), coinManY);
    }

}
