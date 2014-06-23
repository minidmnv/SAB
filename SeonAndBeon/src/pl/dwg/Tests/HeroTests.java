package pl.dwg.Tests;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import pl.dwg.Enums.HeroClassEnum;
import pl.dwg.GameObjects.Hero;

public class HeroTests {
	
	@Test
	public void testCreateEmpty() {
		
		Hero hero = new Hero();
		Assert.assertEquals(true, hero.getStates().isEmpty());
		Assert.assertEquals(0, hero.getExperience());
		Assert.assertEquals(100, hero.getDry());
		Assert.assertEquals(100, hero.getHunger());
		Assert.assertEquals(0, hero.getKills());
		
	}
	
	@Test
	public void testCreateLoad() {
		Hero hero = new Hero(HeroClassEnum.WARRIOR, "Lidjan", 68, 90, 5.3, 5.4, 2.2, 0.2, 0.7, 
				54.1, Arrays.asList(Hero.HeroState.BURNING, Hero.HeroState.HUNGRY), 23, 78, 54, 11);
	
		Assert.assertEquals(HeroClassEnum.WARRIOR, hero.getHeroClass());
		Assert.assertEquals("Lidjan", hero.getName());
		Assert.assertEquals(68, hero.getHpPoints());
		Assert.assertEquals(90, hero.getMpPoints());
		Assert.assertEquals(5.3, hero.getStrength());
		Assert.assertEquals(5.4, hero.getSpeed());
		Assert.assertEquals(2.2, hero.getAgility());
		Assert.assertEquals(0.2, hero.getMind());
		Assert.assertEquals(0.7, hero.getDefence());
		Assert.assertEquals(54.1, hero.getWeight());
		Assert.assertEquals(false, hero.getStates().isEmpty());
		Assert.assertEquals(Arrays.asList(Hero.HeroState.BURNING, Hero.HeroState.HUNGRY), hero.getStates());
		Assert.assertEquals(23, hero.getExperience());
		Assert.assertEquals(78, hero.getHunger());
		Assert.assertEquals(54, hero.getDry());
		Assert.assertEquals(11, hero.getKills());
	
	}
}