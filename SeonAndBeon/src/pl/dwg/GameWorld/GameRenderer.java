package pl.dwg.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.tiled.TileMapRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera cam;
//	RENDERERS
	private ShapeRenderer shapeRenderer;
	private TileMapRenderer tileMapRenderer;
	private SpriteBatch batcher;
	
	//constructor
	public GameRenderer(GameWorld world) {
		this.world = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 1280, 800);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batcher = new SpriteBatch();
	}
	
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		world.getStage().draw();
		world.getCurrentMap().draw(shapeRenderer);
		
		for( Actor a : world.getStage().getActors()) {
			a.draw(batcher, 1);
		}
		
		//DRAW EVERYTHING HERE FFS
//		shapeRenderer.begin(ShapeType.FilledRectangle);
//		
//		shapeRenderer.setColor(0 / 255f, 255 / 255f , 60 / 255f, 1f);
//		
//		for(int i = 0;i < 80; i++)
//			for(int j = 0;j < 80;j++) {
//				if(world.getCurrentMap().getMapField(i, j) == 0)
//					shapeRenderer.filledRect(i * size, j * size, size, size);
//			}
//		
//		shapeRenderer.setColor(255 / 255f, 0 / 255f , 0 / 255f, 1f);
//		
//		for(int i = 0;i < 80; i++)
//			for(int j = 0;j < 80;j++) {
//				if(world.getCurrentMap().getMapField(i, j) == 1)
//					shapeRenderer.filledRect(i * size, j * size, size, size);
//			}
//		
		shapeRenderer.end();
	}
}
