package designPattern.factoryPattern;

interface Human {
	public void Talk();

	public void Walk();
}

class Boy implements Human {
	@Override
	public void Talk() {
		System.out.println("Boy is talking...");
	}

	@Override
	public void Walk() {
		System.out.println("Boy is walking...");
	}
}

class Girl implements Human {

	@Override
	public void Talk() {
		System.out.println("Girl is talking...");
	}

	@Override
	public void Walk() {
		System.out.println("Girl is walking...");
	}
}

public class HumanFactory {
	public static Human createHuman(String m) {
		Human p = null;
		if (m.equals("boy")) {
			p = new Boy();
		} else if (m.equals("girl")) {
			p = new Girl();
		}

		return p;
	}
}
