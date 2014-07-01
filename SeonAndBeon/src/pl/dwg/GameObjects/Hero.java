package pl.dwg.GameObjects;

import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.List;

import pl.dwg.Enums.HeroClassEnum;
import pl.dwg.SABHelpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Hero extends MyActor{
	
	private float x, y, width = 32, height = 48;
	
	//ENUMS
	public enum HeroDirection {NORTH, EASTNORTH, EAST, EASTSOUTH, SOUTH, WESTSOUTH, WEST, WESTNORTH}
	public enum HeroState {POISONED, HUNGRY, STARVING, DRIES, DEHYDRATED, SLOWED, BURNING, BLEEDING}
	
	
	//HERO VARIABLES
	private HeroClassEnum heroClass; //class of our hero
	private int level, hpPoints, mpPoints, experience, hunger, dry; //status hero variables 
	private int expTreshold; //exp needed to level UP! :D formula = (4*(level+1)^3)/5
	
	private String name; //player's name
	
	private double strength, speed, agility, mind; //direct hero variables
	private double defence, weight; //eq variables
	
	private boolean isAlive = true; //alive variable (hpPoints > 0)
	
	private int kills;
	
	private List<HeroState> states; //statuses of our hero
	
	//do wyjebania
	private ShapeRenderer shp;
	
	//--------------
	 
	private TextureRegion heroLook = AssetLoader.hero;
	/* ----------------------------------------------------------- */
	
	//constructor used to create brand new hero
	public Hero() {
		states = new ArrayList<HeroState>();
		experience = 0;
		hunger = 100;
		dry = 100;
		kills = 0;
		hpPoints = 100;
		
		shp = new ShapeRenderer();
		
		setBounds(x, y, width, height);
		addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				((Hero)event.getTarget()).interact();
				return true;
			}});
		
	}
	
	//constructor used in loading the game etc.
	public Hero(HeroClassEnum heroClass, String name, int hpPoints, int mpPoints, double strength, 
			double speed, double agility, double mind, double defence, double weight, List<HeroState> states, 
			int experience, int hunger, int dry, int kills) {
	
		this.heroClass = heroClass;
		this.name = name;
		this.hpPoints = hpPoints;
		this.mpPoints = mpPoints;
		this.strength = strength;
		this.speed = speed;
		this.agility = agility;
		this.mind = mind;
		this.defence = defence;
		this.weight = weight;
		this.states = states;
		this.experience = experience;
		this.hunger = hunger;
		this.dry = dry;
		this.kills = kills;
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if(this.experience >= expTreshold)
			levelUp();
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha) {
		shp.begin(ShapeType.FilledRectangle);
		shp.setColor(255 / 255f, 0 / 255f, 0 / 255f, 1f);
		shp.filledRect(x, y, width, height);
		shp.end();
	}

	public void interact() {
		System.out.println("Are U fucking retarded? Get off me!");
		this.x += 40;
		this.y += 32;
	}
	
	private void levelUp() {
		
	}
	
	//getters
	public HeroClassEnum getHeroClass() { return heroClass; }
	public int getLevel() { return level; }
	public int getHpPoints() { return hpPoints; }
	public int getMpPoints() { return mpPoints; }
	public int getExperience() { return experience; }
	public int getHunger() { return hunger; }
	public int getDry() { return dry; }
	public String getName() { return name; }
	public double getStrength() { return strength; }
	public double getSpeed() { return speed; }
	public double getAgility() { return agility; }
	public double getMind() { return mind; }
	public double getDefence() { return defence; }
	public double getWeight() { return weight; }
	public boolean isAlive() { return isAlive; }
	public List<HeroState> getStates() { return states; }
	public int getKills() { return kills; }
	
	public float getX() {return x;	}
	public float getY() {return y;	}
	public float getWidth() {return width;	}
	public float getHeight() {return height;	}
	
	//setters
	public void setHeroClass(HeroClassEnum heroClass) { this.heroClass = heroClass; }
	public void setLevel(int level) { 
		this.level = level; 
		this.expTreshold = (int) ((4 * pow(level+1, 3))/5);
	}
	public void setHpPoints(int hpPoints) { this.hpPoints = hpPoints; }
	public void setMpPoints(int mpPoints) { this.mpPoints = mpPoints; }
	public void setExperience(int experience) { this.experience = experience; }
	public void setHunger(int hunger) { this.hunger = hunger; }
	public void setDry(int dry) { this.dry = dry; }
	/* public void setExpTreshold() {} not needed */
	public void setName(String name) { this.name = name; }
	public void setStrength(float strength) { this.strength = strength; }
	public void setSpeed(float speed) { this.speed = speed; }
	public void setAgility(float agility) { this.agility = agility; }
	public void setMind(float mind) { this.mind = mind; }
	public void setIsAlive(boolean isAlive) { this.isAlive = isAlive; }
	public void setKills(int kills) { this.kills = kills; }
	
}