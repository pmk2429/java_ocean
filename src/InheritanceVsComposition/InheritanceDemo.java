package InheritanceVsComposition;


class Vehicle {

	Functionality object;

	public Vehicle(Functionality object) {
		this.object = object;
	}

	public void doSomething() {
		System.out.println("did something in Vehicle");
	}

	public void onPostExecuteDemo(int value) {
		object.setData(value);
		System.out.println("Post executed in Vehicle");
	}

	static interface Functionality {
		public void setData(int value);

		public Object myObject();
	}
}


public class InheritanceDemo implements Vehicle.Functionality {
	int originalValue;

	public static void main(String[] args) {
		InheritanceDemo inObj = new InheritanceDemo();
		Vehicle vehicle = new Vehicle(inObj);
		vehicle.doSomething();
		vehicle.onPostExecuteDemo(2429);
		System.out.println("Data in MAIN: " + inObj.getDataSet());
	}

	@Override
	public void setData(int value) {
		originalValue = value;
		System.out.println("Set Data in InheritanceDemo: " + originalValue);
	}

	public int getDataSet(){
		return originalValue;
	}
	
	@Override
	public Object myObject() {
		// TODO Auto-generated method stub
		return null;
	}
}
