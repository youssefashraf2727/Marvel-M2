package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	Image background;
	
	MyPanel() {
		this.setPreferredSize(new Dimension(1000,1000));
		background= new ImageIcon("background game.jpg").getImage();
}
public void paint(Graphics g) {
	Graphics2D g2D=(Graphics2D) g;
	g2D.drawImage(background, 0, 0, null);
}
}

