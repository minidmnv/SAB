package pl.dwg.GameObjects;

import java.util.Collection;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class HUD extends Actor{

	private Collection<Actor> childrens;
	
	
	
	// GETTERS & SETTERS

	public Collection<Actor> getChildrens() {
		return childrens;
	}

	public void setChildrens(Collection<Actor> childrens) {
		this.childrens = childrens;
	}
	
}
