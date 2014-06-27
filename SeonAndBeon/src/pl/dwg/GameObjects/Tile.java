package pl.dwg.GameObjects;

import pl.dwg.Enums.TileEnum;

public class Tile {
	public final int TILE_SIZE = 32;
	private boolean isBlocking;
	
	public Tile(TileEnum kind, boolean isBlocking) {
		
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}
}
