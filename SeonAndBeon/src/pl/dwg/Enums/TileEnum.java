package pl.dwg.Enums;

public enum TileEnum {
	DARK_BRICK(21, 1), GRASS(0, 0), MUD(0, 0);
	
	private int i, j;
	
	TileEnum(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}
