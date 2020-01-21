package com.education.coinman.game.control;

import com.badlogic.gdx.math.Polygon;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CoinController {

    private float moveSpeed = 5;
    private int speedCount = 0;
    private Polygon bounds;

    public CoinController(Polygon bounds){
        this.bounds = bounds;
    }

    public float getMoveSpeed() { return moveSpeed; }
    public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }

    public void handle(){
                bounds.setPosition(bounds.getX() - moveSpeed, bounds.getY());
    }
}
