package pl.dwg.SeonAndBeon;

import pl.dwg.Screens.GameScreen;

import com.badlogic.gdx.Game;


public class SABGame extends Game {

	@Override
	public void create() {
		System.out.println("New game created!");
		setScreen(new GameScreen());
		
	}

	@Override
	public void dispose() {
		System.out.println("Game will be disposed!");
		super.dispose();
		
	}
	
	
	
}