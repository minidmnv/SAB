package pl.dwg.GameWorld;

import pl.dwg.Enums.GameStateEnum;
import pl.dwg.GameObjects.GameMap;
import pl.dwg.GameObjects.Hero;
import pl.dwg.GameObjects.MyStage;
import pl.dwg.SABHelpers.AssetLoader;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameWorld {
	
	//zmienne
	private Hero hero;
	private GameMap currentMap;
	
	private Stage stage;
	private OrthographicCamera cam;
	
	private GameStateEnum currentState = GameStateEnum.RUNNING;
	
	//constructor
	public GameWorld(OrthographicCamera cam) {
		assetsInit();
		this.setCam(cam);
		stage = new MyStage();
		hero = new Hero();
		currentMap = new GameMap(2, cam);
		stage.addActor(currentMap);
		stage.addActor(hero);
	}

	public void update(float delta) {
		getCam().update();
		stage.act(delta);
	}
	
	private void assetsInit() {
		AssetLoader.load();
	}
	
	//getters
	public GameMap getCurrentMap() { return currentMap; }
	public Stage getStage() { return stage; }
	public GameStateEnum getCurrentState() { return currentState; }
	public OrthographicCamera getCam() { return cam; }
	//setters

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}
	
}
