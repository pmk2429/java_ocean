package designPattern.builderPattern.wrapper;

import designPattern.builderPattern.interfaces.*;

public class Bottle implements Packing {

	@Override
	public String pack() {
		return "Bottle";
	}
}
