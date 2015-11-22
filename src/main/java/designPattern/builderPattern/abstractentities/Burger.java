package designPattern.builderPattern.abstractentities;

import designPattern.builderPattern.interfaces.*;
import designPattern.builderPattern.wrapper.FoodWrapper;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new FoodWrapper();
	}

	@Override
	public abstract float price();

}
