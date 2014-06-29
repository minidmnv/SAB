package pl.dwg.GameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pl.dwg.Enums.TileEnum;
import pl.dwg.SABHelpers.AssetLoader;

public class Tile {
	public final int TILE_SIZE = 32;
	
	private TileEnum kind;
	private boolean isBlocking;
	
	public Tile(TileEnum kind, boolean isBlocking) {
		this.kind = kind;
		this.isBlocking = isBlocking;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	public TextureRegion getAsset() {
		return AssetLoader.mapTilesets[kind.getI()][kind.getJ()];
	}
}
