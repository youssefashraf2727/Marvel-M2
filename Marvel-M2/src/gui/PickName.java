package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import engine.Game;
import engine.Player;

@SuppressWarnings({ "serial", "unused" })
public class PickName extends JFrame {
	JFrame frame;
	private static JPanel Panel;
	private static JLabel player1l;
	private static JLabel player2l;
	private static JLabel error;
	private static JButton button;
	private static JTextField player1n;
	private static JTextField player2n;
	private InputHandler Ihandle=new InputHandler();
	MyPanel panel;

	public static void main(String [] args) throws IOException {
		new PickName();
		
		
		
		}
	
	public PickName() {
		frame=new JFrame();
		frame.setTitle("Marvel: Ultimate War");
		frame.setSize(1000,1000);
		frame.setResizable(true);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image= new ImageIcon("Logo.png");
		frame.setIconImage(image.getImage());
		image.setImage(image.getImage());
		Panel=new JPanel();
		Panel.setLayout(null);
		player1l =new JLabel("Enter Player 1 Name");
		player2l =new JLabel("Enter Player 2 Name");
		error=new JLabel("Please input two different names, maximum 20 characters");
		error.setFont(new Font("Unispace",Font.BOLD,17));
		error.setForeground(new Color(110,15,15));
		error.setBounds(670,50,600,250);
		error.setVisible(false);
		button=new JButton("Select your Champions!");
		button.setFont(new Font("Unispace",Font.BOLD,15));
		button.setBounds(740,650,400,50);
		button.addActionListener(Ihandle);
		player1l.setFont(new Font("Unispace",Font.BOLD,35));
		player1l.setForeground(new Color(110,15,15));
		player1l.setBounds(740,200,400,250);
		player2l.setFont(new Font("Unispace",Font.BOLD,35));
		player2l.setForeground(new Color(110,15,15));
		player2l.setBounds(740,400,400,250);
		player1n=new JTextField(20);
		player2n=new JTextField(20);
		player1n.setBounds(740,350,400,50);
		player2n.setBounds(740,550,400,50);
		Panel.add(player1l);
		Panel.add(player1n);
		Panel.add(player2l);
		Panel.add(player2n);
		Panel.add(button);
		Panel.add(error);
		frame.add(Panel);
		frame.setVisible(true);
		
	}
	

	public class InputHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Player p1=new Player(player1n.getText());
			Player p2=new Player(player2n.getText());
			if(e.getSource()==button) {
				if(player1n.getText().length()<=0 || player2n.getText().length()<=0 || player1n.getText().replaceAll("\\s+","").equalsIgnoreCase(player2n.getText().replaceAll("\\s+","")) || player1n.getText().length()>20 || player2n.getText().length()>20) {
					error.setVisible(true);
					}
				else {
				frame.dispose();
				try {
					ChampionSelect myWindow= new ChampionSelect(p1,p2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
			
			
		}
		
	
	}
	
	
public static String getP1name() {
	return player1n.getText();
}




public static String getP2name() {
	return player2n.getText();
}

}




	
	
	
		
		
		
	
	
	
	
	
	
	


