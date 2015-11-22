package designPattern.adapterPattern.entities;

import designPattern.adapterPattern.interfaces.AdvancedMediaPlayer;

public class Winamp implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: " + fileName);

	}

}
