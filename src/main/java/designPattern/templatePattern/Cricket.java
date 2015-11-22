package designPattern.templatePattern;

public class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("Cricket Initialized");

	}

	@Override
	void startPlay() {
		System.out.println("Cricket Started");

	}

	@Override
	void endPlay() {
		System.out.println("Cricket Ended");

	}

}
