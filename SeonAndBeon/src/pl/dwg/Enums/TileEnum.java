package pl.dwg.Enums;

public enum TileEnum {
	DARK_BRICK(21, 1), GRASS(0, 0), MUD(0, 0);
	
	private int i, j;
	
	TileEnum(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getColumn() {
		return i;
	}

	public void setColumn(int i) {
		this.i = i;
	}

	public int getRow() {
		return j;
	}

	public void setRow(int j) {
		this.j = j;
	}
}
