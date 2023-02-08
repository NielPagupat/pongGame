package pong1o5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

@SuppressWarnings("serial")
public class D_1IngameBg extends JPanel{
	Image bg;
	D_1IngameBg(){
		bg = new ImageIcon("Sprites/altBg.png").getImage();
		this.setBounds(Tools.FRAMEWIDTH/2-1200/2, Tools.FRAMEHEIGHT/2-800/2, 1200, 800);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.drawImage(bg, 0, 0, null);
	}
}
