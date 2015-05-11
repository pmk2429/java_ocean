package designPattern.builderPattern.entities;

import designPattern.builderPattern.abstractentities.Burger;

public class ChickenBurger extends Burger {
	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}
