package pl.dwg.GameObjects;

import java.util.ArrayList;
import java.util.List;

import pl.dwg.Enums.TileEnum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class GameMap {

	//STA£E
	private final int MIN_ROOM_SIZE = 8;
	private final int MAX_ROOM_SIZE = 20;
	private final int MIN_ROOMS = 12;
	private final int MAX_CORRIDOR_SIZE = 1;
	private final int MIN_CORRIDOR_SIZE = 1;
	private final int MAP_SIZE = 100;
	
	//zmienne
	private Tile tiles[][];
	private List<Room> rooms;
	//koniec zmiennych
	
	//CONSTRUCTOR
	public GameMap() {};
	public GameMap(int multiplier) {
		tiles = new Tile[MAP_SIZE][MAP_SIZE];
		rooms = new ArrayList<Room>();
		
		System.out.println("Pocz¹tek generowania mapy");
		
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
			
			for(int i = 0; i < MAP_SIZE; i++) {
				for (int j = 0; j < MAP_SIZE; j++) {
					if(tiles[i][j] != null && !tiles[i][j].isBlocking()) {
						shp.filledRect(j * 8, i * 8, 8, 8);
					}
				}
			}
			
			
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
		int dirW = room.getCenter().x < newRoom.getCenter().x ? 1 : -1;
		int dirH = newRoom.getCenter().y < room.getCenter().y ? 1 : -1;
		int corridorLength = Math.abs(newRoom.getCenter().x - room.getCenter().x), i = 0; // corridorLength
		int corridorWidth = (int) Math.floor(MIN_CORRIDOR_SIZE + Math.random()
				* (MAX_CORRIDOR_SIZE - MIN_CORRIDOR_SIZE)); // corridorWidth
		
		// corridor w
		while (i < corridorLength) {
			for(int j = 0; j < corridorWidth; j++) {
				System.out.println("Poszed³ wszerz - x: " + (room.getCenter().x + (i * dirW)) + ", y: " + (room.getCenter().y + j));
				tiles[room.getCenter().x + (i * dirW)][room.getCenter().y + j] = new Tile(TileEnum.DARK_BRICK, false);
			}
			i++;
		}
		corridorLength = Math.abs(newRoom.getCenter().y - room.getCenter().y); i = 0;
			
		// corridor h
		while (i < corridorLength) {
			for(int j = 0; j < corridorWidth; j++) {
				System.out.println("Poszed³ wzdloz - x: " + (newRoom.getCenter().x + j) + ", y: " + (newRoom.getCenter().y + (i * dirH)));
				tiles[newRoom.getCenter().x + j][newRoom.getCenter().y + (i * dirH)] = new Tile(TileEnum.DARK_BRICK, false);
			}
			i++;
		}
		
	}
	// GETTERS
	public Tile[][] getGameMap() { return tiles; }
	public Tile getGameMapTile(int x, int y) { return tiles[x][y]; }
	public List<Room> getRooms() { return rooms; }
	// SETTERS	
		
}
