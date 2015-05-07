package designPattern.factoryPattern.cars;

public class SedanCar extends Car {

	SedanCar() {
		super(CarType.SEDAN);
		construct();
	}

	@Override
	protected void construct() {
		System.out.println("Building sedan car");
		// add accessories
	}
}
