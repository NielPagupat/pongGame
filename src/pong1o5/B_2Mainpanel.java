package pong1o5;

import javax.swing.*;

@SuppressWarnings("serial")
public class B_2Mainpanel extends JPanel{
		static C_1Gameframe GAME;
	B_2Mainpanel(){
		
		JLabel logo = new JLabel();
		ImageIcon icon = new ImageIcon("Sprites/PONG++.png");
		logo.setIcon(icon);
		logo.setBounds((Tools.PANELWIDTH/2)-100, 150, 200, 200);
		
		JButton startGame = new JButton();
		startGame.setBounds((Tools.PANELWIDTH/2)-300/2, 400, 300, 50);
		startGame.addActionListener(e -> startGame());
		ImageIcon startGameIcon = new ImageIcon("Sprites/startGame.png");
		startGame.setIcon(startGameIcon);
		
		JButton options = new JButton();
		options.setBounds((Tools.PANELWIDTH/2)-200/2, 500, 200, 50);
		options.addActionListener(e -> {A_Main.MFrame.menuPanel.setVisible(false);A_Main.MFrame.optionsPanel.setVisible(true);});
		ImageIcon optionIcon = new ImageIcon("Sprites/options.png");
		options.setIcon(optionIcon);
		
		JButton exit = new JButton();
		exit.addActionListener(e ->  System.exit(0));
		exit.setBounds((Tools.PANELWIDTH/2)-100/2, 600, 100, 50);
		ImageIcon exitIcon = new ImageIcon("Sprites/exit.png");
		exit.setIcon(exitIcon);
		
		
		this.add(exit);
		this.add(options);
		this.add(startGame);
		this.add(logo);
		this.setBounds(Tools.PXLOCATION, Tools.PYLOCATION, Tools.PANELWIDTH, Tools.PANELHEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public void startGame() {
		A_Main.MFrame.setVisible(false);
		A_Main.MFrame.menuMusic.stopMusic();
		GAME = new C_1Gameframe();
		GAME.setVisible(true);
		
	}

	JPanel bg() {
		JPanel bg = new JPanel();
		JLabel img =new JLabel();
		img.setIcon(new ImageIcon("Sprites/bgPanel.png"));
		img.setBounds(0,0,700,400);
		bg.add(img);
		bg.setBounds(Tools.PXLOCATION, Tools.PYLOCATION, Tools.PANELWIDTH, Tools.PANELHEIGHT);
		bg.setOpaque(false);
		return bg;
	}
}
