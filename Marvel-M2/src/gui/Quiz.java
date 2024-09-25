package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import engine.Game;
import model.world.Champion;

public class Quiz extends JFrame implements ActionListener,MouseListener {
	private static final long serialVersionUID = 1L;
	JFrame frame= new JFrame();
	JButton name= new JButton();
	JButton type= new JButton();
	JButton counter= new JButton();
	JButton next= new JButton();


public static void main(String[] args) throws IOException {
	new Quiz();
}

Quiz(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000,1000);
	frame.setResizable(true);
	frame.setLayout(new GridLayout(2,2));
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	name= new JButton("Shield throw");
	name.setBounds(740,650,500,500);
	type= new JButton("DMG");
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

public void actionPerformed(ActionEvent e) {
	Game g=new Game(null,null);
	try {
		g.loadAbilities("Abilities.csv");
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	try {
		g.loadChampions("Champions.csv");
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	if(e.getSource()==next) {
		frame.dispose();
		next myWindow= new next();
	}

}

@Override
public void mouseClicked(MouseEvent e) {
	Game g=new Game(null,null);
	try {
		g.loadAbilities("Abilities.csv");
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	try {
		g.loadChampions("Champions.csv");
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	if(e.getSource()==next) {
		name= new JButton("new name");
	}
}

@Override
public void mousePressed(MouseEvent e) {
	if(e.getSource()==next) {
		name= new JButton("new name");
	}
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}