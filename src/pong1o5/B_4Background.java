package pong1o5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class B_4Background extends JPanel implements ActionListener{
	
	Image ball;
	Image bg;
	int xVelocity = 10;
	int yVelocity = 7;
	int xLocation = 0;
	int yLocation = 0;
	int sway = -400;
	int swaySpeed = 1;
	Timer timer;
	
	B_4Background(){
		this.setSize(Tools.FRAMEWIDTH, Tools.FRAMEHEIGHT);
		this.setLocation(0,0);
		
		
		ball = new ImageIcon("Sprites/ball.png").getImage();
		bg = new ImageIcon("Sprites/bg.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.drawImage(bg, sway, 0, null);
		g2D.drawImage(ball, xLocation, yLocation, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(xLocation >= Tools.FRAMEWIDTH-ball.getWidth(null) || xLocation < 0) {
			xVelocity *= -1;
		}
		if(yLocation >= Tools.FRAMEHEIGHT-ball.getHeight(null) || yLocation < 0) {
			yVelocity *= -1;
		}
		if(sway >= 0 || sway < -400) {
			swaySpeed *= -1;
		}
		
		
		sway += swaySpeed;
		yLocation += yVelocity;
		xLocation += xVelocity;
		repaint();
		
	}
}
