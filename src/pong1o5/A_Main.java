package pong1o5;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class A_Main {
	static B_1Mainframe MFrame;
	public static void main(String [] arg) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		MFrame = new B_1Mainframe();
	}
}
