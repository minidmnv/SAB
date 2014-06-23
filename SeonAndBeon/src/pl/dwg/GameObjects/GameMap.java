package pl.dwg.GameObjects;

import java.util.ArrayList;
import java.util.List;

import pl.dwg.Enums.TileEnum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class GameMap {

	//STA£E
	private final int MIN_ROOM_SIZE = 6;
	private final int MAX_ROOM_SIZE = 18;
	private final int MIN_ROOMS = 12;
	private final int MAX_CORRIDOR_SIZE = 7;
	private final int MIN_CORRIDOR_SIZE = 3;
	private final int MAP_SIZE = 80;
	
	//zmienne
	private Tile tiles[][];
	private List<Room> rooms;
	//koniec zmiennych
	
	//CONSTRUCTOR
	public GameMap() {};
	public GameMap(int multiplier) {
		tiles = new Tile[MAP_SIZE][MAP_SIZE];
		rooms = new ArrayList<Room>();
		
		generateGameMap(multiplier);
	
		System.out.println("Koniec generowania mapy");
		
	}
	
	private void generateGameMap(int multiplier) {
		createRooms();
		placeRooms();
	}
	
	private void placeRooms() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(ShapeRenderer shp) {
		for(Room room : rooms) {
			shp.begin(ShapeType.FilledRectangle);
			shp.setColor(255  / 255f, 255 / 255f, 0 / 255f, 1);
			shp.filledRect(room.getX1() * 8, room.getY1() * 8,
					(room.getX2() - room.getX1()) * 8, 
					(room.getY2() - room.getY1()) * 8);
			shp.end();
		}
			
	}
	private void createRooms() {
		boolean failed;
		Room newRoom;
		int x,y,w,h; //random values
		
		for(int createdRooms = 0; createdRooms < MIN_ROOMS; createdRooms++) {
			failed = false;
			w = (int) Math.floor(MIN_ROOM_SIZE + (Math.random() * (MAX_ROOM_SIZE - MIN_ROOM_SIZE)));
			h = (int) Math.floor(MIN_ROOM_SIZE + (Math.random() * (MAX_ROOM_SIZE - MIN_ROOM_SIZE)));
			x = (int) Math.floor(Math.random() * (MAP_SIZE - MIN_ROOM_SIZE));
			y = (int) Math.floor(Math.random() * (MAP_SIZE - MIN_ROOM_SIZE));
			newRoom = new Room(x, y, w, h);
			if(newRoom.getX2() > 79 || newRoom.getY2() > 79) {
				failed = true;
			}
			for(Room room : rooms) {
				if(newRoom.intersect(room)) {
					failed = true;
				}
			}
			if(!failed) {
				rooms.add(newRoom);
				if(createdRooms > 0)
					connectRooms(newRoom, rooms.get(createdRooms - 1));
			}
			if(failed) {
				--createdRooms;
			}
		}
	}
	
	private void connectRooms(Room newRoom, Room room) {
		int corridorLength = Math.abs(newRoom.getCenter().y - room.getCenter().y), i = 0; // corridorLength
		int corridorWidth = (int) Math.floor(MIN_CORRIDOR_SIZE + Math.random()
				* (MAX_CORRIDOR_SIZE - MIN_CORRIDOR_SIZE));
		// corridor h
		while (i < corridorLength) {
			int j;
			for(j = 1; j < corridorWidth; j++)
				switch(j) {
				case 0:
					tiles[j][i]	= new Tile(TileEnum.DARK_BRICK_WALL_LEFT, true);
					break;
				default:
					tiles[j][i]	= new Tile(TileEnum.DARK_BRICK, false);
				}
			tiles[j][i]	= new Tile(TileEnum.DARK_BRICK_WALL_RIGHT, true);
		}
			
		
		
		// corridor w
		
	}
	// GETTERS
	public Tile[][] getGameMap() { return tiles; }
	public Tile getGameMapTile(int x, int y) { return tiles[x][y]; }
	public List<Room> getRooms() { return rooms; }
	// SETTERS	
		
}
