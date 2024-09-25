package gui;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class next {
	JFrame frame= new JFrame();
	JButton name= new JButton();
	JButton type= new JButton();
	JButton counter= new JButton();
	JButton next= new JButton();
	
	
	public static void main(String [] args) throws IOException {
		new next();
}
	
	next(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.setResizable(true);
		frame.setLayout(new GridLayout(2,2));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		name= new JButton("God of Thunder");
		name.setBounds(740,650,500,500);
		type= new JButton("CC");
		type.setBounds(740,650,500,500);
		counter= new JButton("2");
		counter.setBounds(740,650,500,500);
		next= new JButton("Next");
		next.setBounds(740,650,500,500);
		frame.add(name);
		frame.add(type);
		frame.add(counter);
		frame.add(next);
	}
}
