package pl.dwg.SABHelpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	// cons
	public static final int MAP_TILESET_ROWS = 0;
	public static final int MAP_TILESET_COLS = 0;
	public static final int MAP_TILESET_WIDTH = 44; 
	public static final int MAP_TILESET_HEIGHT = 48;
	// textures
	public static Texture heroTxt;
	public static Texture mapTileset;
	// texture regions
	public static TextureRegion hero;
	public static TextureRegion[][] mapTilesets;
	
	public static void load() {
//		heroTxt = new Texture("data/heroTxt.jpg");
//		hero = new TextureRegion(heroTxt, 0, 0, 40, 52);
		mapTileset = new Texture("data/map_tileset.png");
	
		mapTilesets = new TextureRegion[22][21];
		for(int i = 0; i < MAP_TILESET_COLS; i++) {
			for(int j = 0;j < MAP_TILESET_ROWS; j++) {
				mapTilesets[i][j] = new TextureRegion(mapTileset,
						 (i * MAP_TILESET_WIDTH), (j * MAP_TILESET_HEIGHT), 
						 MAP_TILESET_WIDTH, MAP_TILESET_HEIGHT);
			}
		}
	}
	
	public static void dispose() {
		mapTileset.dispose();
		heroTxt.dispose();
	}
}
