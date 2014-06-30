package pl.dwg.Screens;

import pl.dwg.GameWorld.GameRenderer;
import pl.dwg.GameWorld.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen, GestureListener{

	private GameWorld world;
	private GameRenderer renderer;
	private OrthographicCamera gameCam;
	
	private float runTime = 0;
	private FPSLogger fpsLogger;
	
	public GameScreen() {
		gameCam = new OrthographicCamera();
		gameCam.setToOrtho(true, 1280, 800);

		world = new GameWorld(gameCam);
		Gdx.input.setInputProcessor(world.getStage());
		fpsLogger = new FPSLogger();
		renderer = new GameRenderer(world, gameCam);
	}
	
	@Override
	public void render(float delta) {
		
		runTime += delta;
		world.update(delta);
		renderer.render(delta);
//		fpsLogger.log(); 
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
