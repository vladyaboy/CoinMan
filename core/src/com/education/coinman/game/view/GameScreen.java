package com.education.coinman.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.education.coinman.game.model.CoinMan;

public class GameScreen implements Screen {

    private Texture bgTexture;
    private Texture coinManTexture;
    private SpriteBatch batch;
    private CoinMan coinMan;
    private OrthographicCamera camera;

    @Override
    public void show() {
        batch = new SpriteBatch();
        bgTexture = new Texture("bg.png");
        coinManTexture = new Texture("frame-1.png");
        coinMan = new CoinMan(coinManTexture,0,0,coinManTexture.getWidth() / 2, coinManTexture.getHeight() / 2);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.setProjectionMatrix(camera.combined);
        batch.draw(bgTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        coinMan.draw(batch);

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
