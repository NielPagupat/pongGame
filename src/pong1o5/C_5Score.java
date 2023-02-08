package pong1o5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public class C_5Score {
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	Image img;
	C_5Score(int GAME_WIDTH,int GAME_HEIGHT) {
		C_5Score.GAME_WIDTH = GAME_WIDTH;
		C_5Score.GAME_HEIGHT = GAME_HEIGHT;
		img = new ImageIcon("Sprites/ScoreBoard.png").getImage();
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		
		g.drawImage(img, 0, 0, null);
		
		g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_WIDTH/2) - 85, 50);
		g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (GAME_WIDTH/2) + 20, 50);
	}

}


