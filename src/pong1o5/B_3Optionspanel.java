package pong1o5;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



@SuppressWarnings("serial")
public class B_3Optionspanel extends JPanel{
	int lastMusicVol = 50;
	int lastMasterVol = 50;
	int lastSfxVol = 50;
	B_3Optionspanel(){
		JSlider masterVol = new JSlider(0, 100, 100);
		JSlider musicVol = new JSlider(0, masterVol.getValue(), 100);
		JSlider sfxVol = new JSlider(0,100, 100);
		JLabel mvLabel = new JLabel("Master Volume", JLabel.CENTER);
		JLabel mLabel = new JLabel("Music Volume", JLabel.CENTER);
		JLabel sLabel = new JLabel("SFX Volume", JLabel.CENTER);
		JButton back = new JButton();
		
		
		
		
		back.addActionListener(e -> {A_Main.MFrame.menuPanel.setVisible(true);A_Main.MFrame.optionsPanel.setVisible(false);});

		
		masterVol.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				double masterGain = (masterVol.getValue()*(lastMusicVol *0.01)) * 0.01;
				double masterSfxGain = (masterVol.getValue()*(lastSfxVol *0.01)) * 0.01; 
				float dB = (float) (Math.log(masterGain) / Math.log(10.0) * 20.0);
				float sfxDb = (float) (Math.log(masterSfxGain) / Math.log(10.0) * 20.0);
				
				System.out.println("masterVol"+ masterVol.getValue());
				if (musicVol.getValue() != 0) {
					A_Main.MFrame.menuMusic.changeVolume(dB);
					B_1Mainframe.inGameMusic.changeVolume(dB);
					lastMasterVol = masterVol.getValue();
				} 
				if (sfxVol.getValue() != 0) {
					B_1Mainframe.bounceSfx.changeVolume(sfxDb);
					B_1Mainframe.scoreSfx.changeVolume(sfxDb);
					B_1Mainframe.youWinSfx.changeVolume(sfxDb);
				}
				
			}
			
		});
		
		musicVol.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(masterVol.getValue() != 0) {
					double gain = (musicVol.getValue()* (lastMasterVol* 0.01))* 0.01;   
					float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
					System.out.println("musicVol"+ musicVol.getValue());
					A_Main.MFrame.menuMusic.changeVolume(dB);
					B_1Mainframe.inGameMusic.changeVolume(dB);
					lastMusicVol = musicVol.getValue();
				}
			}
			
		});
		
		sfxVol.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(masterVol.getValue() != 0) {
					double gain = (sfxVol.getValue()* (lastMasterVol* 0.01))* 0.01;   
					float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
					B_1Mainframe.bounceSfx.changeVolume(dB);
					B_1Mainframe.scoreSfx.changeVolume(dB);
					B_1Mainframe.youWinSfx.changeVolume(dB);
					lastSfxVol = sfxVol.getValue();
				}
				
			}
			
		});
		
		
		
		ImageIcon backIcon = new ImageIcon("Sprites/back.png");
		
		masterVol.setBounds((Tools.PANELWIDTH/2)-300/2, 150, 300, 50);
		masterVol.setOpaque(false);
		
		
		musicVol.setBounds((Tools.PANELWIDTH/2)-300/2, 350, 300, 50);
		musicVol.setOpaque(false);
		
		
		sfxVol.setBounds((Tools.PANELWIDTH/2)-300/2, 450, 300, 50);
		sfxVol.setOpaque(false);
		
		back.setIcon(backIcon);
		back.setBackground(new Color(0, 0, 0, 0));
		back.setBorderPainted(false);
		back.setBounds((Tools.PANELWIDTH/2)-50/2, 600, 50, 50);
		
		mvLabel.setBounds((Tools.PANELWIDTH/2)-300/2, 175, 300, 50);
		mvLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		mvLabel.setForeground(Color.white);
		
		mLabel.setBounds((Tools.PANELWIDTH/2)-300/2, 375, 300, 50);
		mLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		mLabel.setForeground(Color.white);
		
		sLabel.setBounds((Tools.PANELWIDTH/2)-300/2, 475, 300, 50);
		sLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		sLabel.setForeground(Color.white);
		
		
		
		this.add(sLabel);
		this.add(mLabel);
		this.add(mvLabel);
		this.add(masterVol);
		this.add(musicVol);
		this.add(sfxVol);
		this.add(back);
		this.setBounds(Tools.PXLOCATION, Tools.PYLOCATION, Tools.PANELWIDTH, Tools.PANELHEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
	}
}
