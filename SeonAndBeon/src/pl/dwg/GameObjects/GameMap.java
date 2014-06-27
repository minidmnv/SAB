package pl.dwg.GameObjects;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import pl.dwg.Enums.TileEnum;
import pl.dwg.SABHelpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMap {

	//STA�E
	private final int MIN_ROOM_SIZE = 10;
	private final int MAX_ROOM_SIZE = 22;
	private final int MIN_ROOMS = 14;
	private final int MIN_CORRIDOR_SIZE = 4;
	private final int MAX_CORRIDOR_SIZE = 1;
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
		
		System.out.println("Pocz�tek generowania mapy");
		
		generateGameMap(multiplier);
	
		System.out.println("Koniec generowania mapy");
		
	}
	
	private void generateGameMap(int multiplier) {
		createRooms();
		placeRooms();
	}
	
	private void placeRooms() {
		for(Room room : rooms) {
			System.err.println("P1: (" + room.getX1() + ", " + room.getY1() + "), P2: ("
					+room.getY1() + ", " + room.getY2() + ");");
			for (int i = 0; i < room.getY2() - room.getY1(); i++) {	//wysoko��
				for (int j = 0; j < room.getX2() - room.getX1(); j++) {
					tiles[room.getX1() + j][room.getY1() + i] = new Tile(TileEnum.DARK_BRICK, false);
				}
			}
		}
		
	}

	public void draw(SpriteBatch batcher) {

		batcher.begin();
		batcher.disableBlending();
		for (int i = 0; i < MAP_SIZE; i++) {
			for (int j = 0; j < MAP_SIZE; j++) {
				if (tiles[i][j] != null && !tiles[i][j].isBlocking()) {
					System.out.println((i * AssetLoader.MAP_TILESET_WIDTH) + ", " + 
							(j * AssetLoader.MAP_TILESET_HEIGHT) + ", " + AssetLoader.MAP_TILESET_WIDTH + ", " + 
							AssetLoader.MAP_TILESET_HEIGHT);
					
					
					batcher.draw(tiles[i][j].getAsset(), i * AssetLoader.MAP_TILESET_WIDTH, 
							j * AssetLoader.MAP_TILESET_HEIGHT, AssetLoader.MAP_TILESET_WIDTH, 
							AssetLoader.MAP_TILESET_HEIGHT);
				}
			}
		}
		
		batcher.end();
			
	}
	private void createRooms() {
		boolean failed;
		Room newRoom;
		int x,y,w,h; //random values
		
		for(int createdRooms = 0; createdRooms < MIN_ROOMS; createdRooms++) {
			failed = false;
			w = (int) Math.floor(MIN_ROOM_SIZE + (Math.random() * (MAX_ROOM_SIZE - MIN_ROOM_SIZE)));
			h = (int) Math.floor(MIN_ROOM_SIZE + (Math.random() * (MAX_ROOM_SIZE - MIN_ROOM_SIZE)));
			x = (int) Math.floor(Math.random() * (MAP_SIZE - w));
			y = (int) Math.floor(Math.random() * (MAP_SIZE - h));
			newRoom = new Room(x, y, w, h);
			if(newRoom.getX2() >= MAP_SIZE || newRoom.getY2() >= MAP_SIZE) {
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
		Point pCorridorStart;
		int dirW = room.getCenter().x < newRoom.getCenter().x ? 1 : -1;
		int dirH = room.getCenter().y < newRoom.getCenter().y ? 1 : -1;
		int corridorLength = Math.abs(newRoom.getCenter().x - room.getCenter().x), i = 0; // corridorLength
		int corridorWidth = (int) Math.floor(MIN_CORRIDOR_SIZE + Math.random()
				* (MAX_CORRIDOR_SIZE - MIN_CORRIDOR_SIZE)); // corridorWidth
		
		// corridor w
		while (i <= corridorLength) {
			for (int j = 0; j < corridorWidth; j++) {
				tiles[room.getCenter().x + (i * dirW)][room.getCenter().y + j - (corridorWidth / 2)] = new Tile(
						TileEnum.DARK_BRICK, false);
			}
			i++;
		}

		pCorridorStart = new Point(
				room.getCenter().x + (corridorLength * dirW),
				room.getCenter().y);

		corridorLength = Math.abs(newRoom.getCenter().y - room.getCenter().y);
		i = 0;

		// corridor h
		while (i <= corridorLength) {
			for (int j = 0; j < corridorWidth; j++) {
				tiles[pCorridorStart.x + j - (corridorWidth / 2)][pCorridorStart.y + (i * dirH)] = new Tile(
						TileEnum.DARK_BRICK, false);
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
