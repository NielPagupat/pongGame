package pong1o5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;



@SuppressWarnings("serial")
public class C_2Gamepanel extends JPanel implements Runnable {
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = 600;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 50;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	static int xLocation = (Tools.FRAMEWIDTH/2) - (GAME_WIDTH/2);
	static int yLocation = (Tools.FRAMEHEIGHT/2) - (GAME_HEIGHT/2);
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	public static C_3Paddle paddleLeft;
	public static C_3Paddle paddleRight;
	public static C_4Ball ball;
	C_5Score score;
	private boolean gameRunning = true;
	
	C_2Gamepanel(){
		newPaddles();
		newBall();
		score = new C_5Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setLocation(xLocation,yLocation);
		
		gameThread = new Thread(this);
		gameThread.start();  
	}
	public void newBall() {
		random = new Random();
		ball = new C_4Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
		
	}
	
	public void newPaddles() {
		paddleLeft = new C_3Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT,1);
		paddleRight = new C_3Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0, this);
	}
	
	public void draw(Graphics g) {
		//paddleLeft.draw(g);
		//paddleRight.draw(g);
		//ball.paint(g);
		//score.draw(g);
	}
	
	public void move() {
		C_1Gameframe.paddleRight.move();
		C_1Gameframe.paddleLeft.move();
		C_1Gameframe.ball.move();
		paddleLeft.move();
		paddleRight.move();
		ball.move();
	}
	
	
public void checkCollision() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		//stop paddle at window edges
				if(paddleLeft.y<=0)
					paddleLeft.y=0;
				if(paddleLeft.y >=(GAME_HEIGHT-PADDLE_HEIGHT))
					paddleLeft.y = GAME_HEIGHT-PADDLE_HEIGHT;
				if(paddleRight.y<=0)
					paddleRight.y=0;
				if(paddleRight.y >=(GAME_HEIGHT-PADDLE_HEIGHT))
					paddleRight.y = GAME_HEIGHT-PADDLE_HEIGHT;
		
		//bounce ball off top & bottom window edges
		if(ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
			B_1Mainframe.bounceSfx.sfxMusic();
		}
		if(ball.y>= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
			B_1Mainframe.bounceSfx.sfxMusic();
		}
		
		//bounce ball off paddles
		if(ball.intersects(paddleLeft)) {
			
			B_1Mainframe.bounceSfx.sfxMusic();
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		
		}
		
		if(ball.intersects(paddleRight)) {
			B_1Mainframe.bounceSfx.sfxMusic();
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		//Give a player 1 point & creates new paddles & ball
		if(ball.x <= 0) {
			B_1Mainframe.scoreSfx.sfxMusic();
			score.player2++; 
			newPaddles();
			newBall();
		}
		
		if(ball.x >=  GAME_WIDTH-BALL_DIAMETER) {
			B_1Mainframe.scoreSfx.sfxMusic();
			score.player1++; 
			newPaddles();
			newBall();
		}	
	}
	
	JPanel gameOver_bg;
	public void endGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(score.player1==7) {
		    gameRunning = false;
		    B_1Mainframe.inGameMusic.stopMusic();
		    B_1Mainframe.youWinSfx.sfxMusic();
		    C_6Gameover gameOver = new C_6Gameover();
		    gameOver_bg = new C_6Gameover().bg();
		    gameOver_bg.setVisible(true);
		    gameOver.setWinner2();
		    C_1Gameframe.overlay.add(gameOver, Integer.valueOf(6));
		    C_1Gameframe.overlay.add(gameOver_bg, Integer.valueOf(5));
		    
		    gameOver.setVisible(true);}
		   
		if(score.player2==7) {
		    gameRunning = false;
		    B_1Mainframe.inGameMusic.stopMusic();
		    B_1Mainframe.youWinSfx.sfxMusic();
		    C_6Gameover gameOver = new C_6Gameover();
		    gameOver_bg = new C_6Gameover().bg();
		    gameOver_bg.setVisible(true);
		    gameOver.setWinner1();
		    C_1Gameframe.overlay.add(gameOver, Integer.valueOf(6));
		    C_1Gameframe.overlay.add(gameOver_bg, Integer.valueOf(5));
		   
		    gameOver.setVisible(true);
		    
		
		
		}	
	}
	
	@Override
	public void run() {
		//game loop
				long lastTime = System.nanoTime();
				double amountOfTicks = 60.0;
				double ns = 1000000000 / amountOfTicks;
				double delta = 0;
				while(gameRunning) {
					long now = System.nanoTime();
					delta += (now - lastTime)/ns;
					lastTime = now;
					if(delta >=1) {
						move();
						
						try {
							checkCollision();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							endGame();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						repaint();
						delta--;
					}
		
				}
	
	}
	
	public void restart() {
		gameOver_bg.setVisible(false);
		gameRunning = true;
        score.player1 = 0;
        score.player2 = 0;
        newPaddles();
        newBall();
        B_1Mainframe.inGameMusic.playMusic();
        gameThread = new Thread(C_2Gamepanel.this);
        gameThread.start();
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			paddleLeft.keyPressed(e);
			paddleRight.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			
			
			paddleLeft.keyReleased(e);
			paddleRight.keyReleased(e);
		}
	}
}
