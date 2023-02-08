package pong1o5;

import javax.swing.*;

@SuppressWarnings("serial")
public class C_1Gameframe extends JFrame{
	public static C_2Gamepanel gamePanel;
	B_4Background bg;
	D_1IngameBg IBg;
	static D_2GameGraphics paddleRight;
	static D_2GameGraphics paddleLeft;
	static D_2GameGraphics ball;
	static D_2GameGraphics score;
	static JLayeredPane overlay;
	C_1Gameframe(){
		B_1Mainframe.inGameMusic.playMusic();
		B_1Mainframe.inGameMusic.loopMusic();
		bg = new B_4Background();
		IBg = new D_1IngameBg();
		gamePanel = new C_2Gamepanel();
		paddleRight = new D_2GameGraphics(1);
		paddleLeft = new D_2GameGraphics(2);
		ball = new D_2GameGraphics(3);
		score = new D_2GameGraphics(4);
		overlay = new JLayeredPane();
		overlay.setBounds(0, 0, Tools.FRAMEWIDTH, Tools.FRAMEHEIGHT);
		overlay.setLocation(0, 0);
		
		
		
		
		
		overlay.add(bg, Integer.valueOf(0));
		overlay.add(gamePanel, Integer.valueOf(1));
		overlay.add(IBg, Integer.valueOf(2));
		overlay.add(paddleRight, Integer.valueOf(3));
		overlay.add(paddleLeft, Integer.valueOf(3));
		overlay.add(ball, Integer.valueOf(3));
		overlay.add(score, Integer.valueOf(4));
		this.setTitle("PONG++");
		this.setIconImage(new ImageIcon("Sprites/PONG++.png").getImage());
		this.add(overlay);
		this.setSize(Tools.FRAMEWIDTH, Tools.FRAMEHEIGHT);
		this.setLayout(null);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		
	}
}
