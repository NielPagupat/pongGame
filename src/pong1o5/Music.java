package pong1o5;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	Clip music;
	String Location;
	AudioInputStream Stream;
	float dB;
	Music(String Location) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File Music = new File(Location);
		Stream = AudioSystem.getAudioInputStream(Music);
		music = AudioSystem.getClip();
		music.open(Stream);
		this.Location = Location;
		
	}
	
	public void playMusic() {
		music.start();
	}
	public void stopMusic() {
		music.stop();
	}
	
	public void changeVolume(float db) {
		FloatControl menuGainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
		menuGainControl.setValue(db);
		this.dB = db;
	}
	
	public void loopMusic() {
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void sfxMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File Music = new File(Location);
		Stream = AudioSystem.getAudioInputStream(Music);
		music = AudioSystem.getClip();
		music.open(Stream);
		changeVolume(this.dB);
		music.start();
	}

}

