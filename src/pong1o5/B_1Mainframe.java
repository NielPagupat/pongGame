package pong1o5;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;





@SuppressWarnings("serial")
public class B_1Mainframe extends JFrame {
	
	B_4Background bg;
	B_2Mainpanel menuPanel;
	B_3Optionspanel optionsPanel;
	public Music menuMusic;
	public static Music inGameMusic;
	public static Music bounceSfx;
	public static Music scoreSfx;
	public static Music youWinSfx;
	B_1Mainframe() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		menuMusic = new Music("Sprites/ost.wav");
		menuMusic.playMusic();
		menuMusic.loopMusic();
		inGameMusic = new Music("Sprites/AbandonShip.wav");
		bounceSfx = new Music("Sprites/bruh.wav");
		scoreSfx = new Music("Sprites/scoreSfx.wav");
		youWinSfx = new Music("Sprites/youWin.wav");
		JLayeredPane overlay = new JLayeredPane();
		overlay.setBounds(0, 0,Tools.FRAMEWIDTH, Tools.FRAMEHEIGHT);
		bg = new B_4Background();
		menuPanel = new B_2Mainpanel();
		optionsPanel = new B_3Optionspanel();
		optionsPanel.setVisible(false);
		overlay.add(bg, Integer.valueOf(0));
		overlay.add(menuPanel.bg(), Integer.valueOf(1));
		overlay.add(menuPanel, Integer.valueOf(2));
		overlay.add(optionsPanel,Integer.valueOf(2));
		this.setTitle("PONG++");
		this.setIconImage(new ImageIcon("Sprites/PONG++.png").getImage());
		this.add(overlay);
		this.setSize(Tools.FRAMEWIDTH, Tools.FRAMEHEIGHT);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
