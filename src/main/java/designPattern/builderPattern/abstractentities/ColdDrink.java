package designPattern.builderPattern.abstractentities;

import designPattern.builderPattern.interfaces.*;
import designPattern.builderPattern.wrapper.Bottle;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
