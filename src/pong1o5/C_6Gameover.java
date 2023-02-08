package pong1o5;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class C_6Gameover extends JPanel{
	int winner;
	JLabel Winner;
	C_6Gameover(){
		
		
		
		
		JButton restart = new JButton();
		restart.setIcon(new ImageIcon("Sprites/restart.png"));
		JButton returnToMain = new JButton();
		returnToMain.setIcon(new ImageIcon("Sprites/MainMenu.png"));
		JButton exit = new JButton();
		exit.setIcon(new ImageIcon("Sprites/exit2.png"));
		
		
		restart.addActionListener(e -> {C_1Gameframe.gamePanel.restart(); this.setVisible(false);});
		returnToMain.addActionListener(e -> {A_Main.MFrame.setVisible(true); A_Main.MFrame.menuMusic.playMusic(); B_2Mainpanel.GAME.dispose();});
		exit.addActionListener(e -> {System.exit(0);});
		
		restart.setBounds(Tools.PANELWIDTH/2 - 200/2, 425 , 200, 50);
		returnToMain.setBounds(Tools.PANELWIDTH/2 - 200/2, 500 , 200, 50);
		exit.setBounds(Tools.PANELWIDTH/2 - 200/2, 575 , 200, 50);
		
		this.setLayout(null);
		this.add(restart);
		this.add(returnToMain);
		this.add(exit);
		
		this.setSize(Tools.PANELWIDTH, Tools.PANELHEIGHT);
		this.setLocation(Tools.PXLOCATION, Tools.PYLOCATION);
		this.setVisible(false);
		this.setOpaque(false);
	}
	
	public void setWinner1() {
		
		Winner = new JLabel();
		Winner.setBounds(Tools.PANELWIDTH/2 - 300/2, 150 , 300, 200);
		Winner.setIcon(new ImageIcon("Sprites/player1win.png"));
		
		
		
		this.add(Winner);
	}
	
	public void setWinner2() {
		Winner = new JLabel();
		Winner.setBounds(Tools.PANELWIDTH/2 - 300/2, 150 , 300, 200);
		Winner.setIcon(new ImageIcon("Sprites/player2win.png"));
		this.add(Winner);
	}
	
	static JPanel bg() {
		JPanel bg = new JPanel();
		JLabel img =new JLabel();
		img.setOpaque(false);
		img.setIcon(new ImageIcon("Sprites/bgPanel.png"));
		img.setBounds(0,0,700,400);
		bg.add(img);
		bg.setBounds(Tools.PXLOCATION, Tools.PYLOCATION, Tools.PANELWIDTH, Tools.PANELHEIGHT);
		bg.setOpaque(false);
		bg.setVisible(true);
		return bg;
	}

}
