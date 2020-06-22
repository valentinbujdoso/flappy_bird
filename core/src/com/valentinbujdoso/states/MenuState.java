package com.valentinbujdoso.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.valentinbujdoso.FlappyDemo;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(Stage stage) {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().setProjectionMatrix(cam.combined);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().draw(playBtn, cam.position.x - (playBtn.getWidth() / 2), cam.position.y);
        stage.getBatch().end();

        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
