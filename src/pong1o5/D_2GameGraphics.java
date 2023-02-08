package pong1o5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

@SuppressWarnings("serial")
public class D_2GameGraphics extends JPanel {
	int yVelocity = 10;
	int player1Movement = C_2Gamepanel.paddleRight.y;
	int player2Movement = C_2Gamepanel.paddleLeft.y;
	int ballxMovement = C_2Gamepanel.ball.x;
	int ballyMovement = C_2Gamepanel.ball.y;
	Image paddleRight;
	Image paddleLeft;
	Image ball;
	int id;
	D_2GameGraphics(int id){
		this.id = id;
		paddleRight = new ImageIcon("Sprites/PaddleRight.png").getImage();
		paddleLeft = new ImageIcon("Sprites/PaddleLeft.png").getImage();
		ball = new ImageIcon("Sprites/ingameBall.png").getImage();
		this.setLocation(C_2Gamepanel.xLocation,C_2Gamepanel.yLocation);
		this.setSize(1000,600);
		
		
	}
	
	public void paint(Graphics g) {
		this.setOpaque(false);
		Graphics2D g2D = (Graphics2D)g;
		if(id == 1) {
			g2D.drawImage(paddleRight, 1000-25, player1Movement, null);
		} else if(id == 2) {
			g2D.drawImage(paddleLeft, 0, player2Movement, null);
		} else if(id ==3) {
			g2D.drawImage(ball, ballxMovement, ballyMovement, null);
		} else if (id == 4) {
			C_1Gameframe.gamePanel.score.draw(g);
		}
		
		
	}
	
	public void move() {
		if (player1Movement != C_2Gamepanel.paddleRight.y ) {
			player1Movement = C_2Gamepanel.paddleRight.y;
		}
		if (player2Movement != C_2Gamepanel.paddleLeft.y ) {
			player2Movement = C_2Gamepanel.paddleLeft.y;
		}
		if (ballxMovement != C_2Gamepanel.ball.x || ballyMovement != C_2Gamepanel.ball.y) {
			ballxMovement = C_2Gamepanel.ball.x;
			ballyMovement = C_2Gamepanel.ball.y;
			
		}
		
		
	}
	
	

}
