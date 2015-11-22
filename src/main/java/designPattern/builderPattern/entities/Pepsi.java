package designPattern.builderPattern.entities;

import designPattern.builderPattern.abstractentities.ColdDrink;

public class Pepsi extends ColdDrink {
	@Override
	public float price() {
		return 28.85f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}
