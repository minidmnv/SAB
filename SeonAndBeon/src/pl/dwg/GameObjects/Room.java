package pl.dwg.GameObjects;

import java.awt.Point;

public class Room {

	private int x1, x2, y1, y2, width, height;
	private Point center;
	
	//constructor
	public Room(int x1, int y1, int width, int height) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
		this.width = width;
		this.height = height;
		center = new Point();
		center.x = (int) Math.floor((x1+x2) / 2); 
		center.y = (int) Math.floor((y1+y2) / 2);
	}
	
	public boolean intersect(Room room) {
		return (x1 <= room.getX2() && x2 >= room.getX1() &&
				y1 <= room.getY2() && y2 >= room.getY1());
	}
	
	public void draw() {
		
	}

	//getters
	public int getX1() { return x1; }
	public int getY1() { return y1;	}
	public int getX2() { return x2;	}
	public int getY2() { return y2;	}
	public Point getCenter() { return center; }
}
