package designPattern.builderPattern.entities;

import designPattern.builderPattern.abstractentities.ColdDrink;

public class Coke extends ColdDrink {
	@Override
	public float price() {
		return 30.58f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}
