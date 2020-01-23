package com.education.coinman.game.control;

import com.badlogic.gdx.math.Polygon;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MovingObjectController {

    private float moveSpeed = 5;
    private int speedCount = 0;
    private Polygon bounds;

    public MovingObjectController(Polygon bounds){
        this.bounds = bounds;
    }

    public float getMoveSpeed() { return moveSpeed; }
    public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }

    public void handle(String objectType) {

        if(objectType.equals("Coin")) {
            bounds.setPosition(bounds.getX() - moveSpeed, bounds.getY());
        }

        if(objectType.equals("Bomb")) {
            float bombMoveSpeed = moveSpeed + 2;
            bounds.setPosition(bounds.getX() - bombMoveSpeed, bounds.getY());
        }

    }
}
