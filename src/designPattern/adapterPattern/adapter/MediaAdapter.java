package designPattern.adapterPattern.adapter;

import designPattern.adapterPattern.entities.VlcPlayer;
import designPattern.adapterPattern.entities.Winamp;
import designPattern.adapterPattern.interfaces.AdvancedMediaPlayer;
import designPattern.adapterPattern.interfaces.MediaPlayer;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcPlayer();

		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Winamp();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("winamp")) {
			advancedMusicPlayer.playMp4(fileName);
		}

	}

}
