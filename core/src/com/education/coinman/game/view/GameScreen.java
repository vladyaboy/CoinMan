package com.education.coinman.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.model.Coin;
import com.education.coinman.game.model.CoinMan;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen implements Screen {

    private Texture bgTexture;
    private Texture coinManTexture;
    private Texture coinTexture;
    private SpriteBatch batch;
    private CoinMan coinMan;
    private OrthographicCamera camera;
    private int coinCount = 100;
    private ArrayList<Coin> coinArrayList;
    public static float deltaCff;
    private Random random;

    @Override
    public void show() {
        batch = new SpriteBatch();
        bgTexture = new Texture("bg.png");
        coinManTexture = new Texture("frame-1.png");
        coinMan = new CoinMan(coinManTexture,Gdx.graphics.getWidth() / 3,0,coinManTexture.getWidth() / 3, coinManTexture.getHeight() / 3);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        coinTexture = new Texture("coin.png");
        coinArrayList = new ArrayList<>();
        random = new Random();
        generateCoins(coinCount, 10000);

    }

    private void generateCoins(int coinCount, int ping) {
        for(int i = 0; i < coinCount; i++) {
            int count = 0;
            while (count < ping) {
                count++;
                if(count == ping) {
                    float coinX = Gdx.graphics.getWidth();
                    float coinY = random.nextFloat() * Gdx.graphics.getHeight();
                    coinArrayList.add(new Coin(coinTexture, coinX, coinY, coinTexture.getWidth(), coinTexture.getHeight()));
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.draw(bgTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        coinMan.draw(batch);
        for(Coin coin : coinArrayList) {
            coin.draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) width / height;
        camera.translate(camera.viewportWidth / 4,camera.viewportHeight / 4);
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        batch.dispose();
    }
}
