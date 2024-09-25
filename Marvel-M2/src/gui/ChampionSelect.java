package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.*;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import gui.PickName.InputHandler;
import model.world.Champion;


@SuppressWarnings({ "serial", "unused" })
public class ChampionSelect extends JFrame implements ActionListener,MouseListener {
	JFrame frame = new JFrame();
	JButton Spiderman= new JButton();
	JButton CaptainAmerica= new JButton(); 
	JButton Deadpool= new JButton(); 
	JButton DrStrange= new JButton(); 
	JButton Electro= new JButton(); 
	JButton GhostRider= new JButton(); 
	JButton Hela= new JButton(); 
	JButton Hulk= new JButton(); 
	JButton Iceman= new JButton(); 
	JButton Ironman= new JButton(); 
	JButton Loki= new JButton(); 
	JButton Quicksilver= new JButton();
	JButton Thor= new JButton();
	JButton Venom= new JButton(); 
	JButton YellowJacket= new JButton();
	JLabel Spidermanl= new JLabel();
	JLabel P1L= new JLabel();
	JLabel P1=new JLabel();
	JLabel P2L= new JLabel();
	JLabel P2=new JLabel();
	private int turnNum=0;
	Player play1=new Player(PickName.getP1name());
	Player play2=new Player(PickName.getP2name());
	JFrame CapPop=new JFrame();
	JLabel Caplbl=new JLabel();
	ImageIcon CapImg=new ImageIcon("CaptainAmericaPopUp.png");
	JFrame DeadPop=new JFrame();
	JLabel Deadlbl=new JLabel();
	ImageIcon DeadImg=new ImageIcon("DeadpoolPopUp.png");
	JFrame DocPop=new JFrame();
	JLabel Doclbl=new JLabel();
	ImageIcon DocImg=new ImageIcon("DocPopUp.png");
	JFrame ElectroPop=new JFrame();
	JLabel Electrolbl=new JLabel();
	ImageIcon ElectroImg=new ImageIcon("ElectroPopUp.png");
	JFrame GhostPop=new JFrame();
	JLabel Ghostlbl=new JLabel();
	ImageIcon GhostImg=new ImageIcon("GhostPopUp.png");
	JFrame HelaPop=new JFrame();
	JLabel Helalbl=new JLabel();
	ImageIcon HelaImg=new ImageIcon("HelaPopUp.png");
	JFrame HulkPop=new JFrame();
	JLabel Hulklbl=new JLabel();
	ImageIcon HulkImg=new ImageIcon("HulkPopUp.png");
	JFrame IcePop=new JFrame();
	JLabel Icelbl=new JLabel();
	ImageIcon IceImg=new ImageIcon("IcePopUp.png");
	JFrame IronManPop=new JFrame();
	JLabel IronManlbl=new JLabel();
	ImageIcon IronManImg=new ImageIcon("IronPopUp.png");
	JFrame LokiPop=new JFrame();
	JLabel Lokilbl=new JLabel();
	ImageIcon LokiImg=new ImageIcon("LokiPopUp.png");
	JFrame QuickPop=new JFrame();
	JLabel Quicklbl=new JLabel();
	ImageIcon QuickImg=new ImageIcon("QuickPopUp.png");
	JFrame SpideyPop=new JFrame();
	JLabel Spideylbl=new JLabel();
	ImageIcon SpideyImg=new ImageIcon("SpideyPopUp.png");
	JFrame ThorPop=new JFrame();
	JLabel Thorlbl=new JLabel();
	ImageIcon ThorImg=new ImageIcon("ThorPopUp.png");
	JFrame VenomPop=new JFrame();
	JLabel Venomlbl=new JLabel();
	ImageIcon VenomImg=new ImageIcon("VenomPopUp.png");
	JFrame YellowPop=new JFrame();
	JLabel Yellowlbl=new JLabel();
	ImageIcon YellowImg=new ImageIcon("YellowPopUp.png");
	Game g;
	
	
	
	
	
	public static void main(String [] args) throws IOException {
		
}
	
	

	ChampionSelect(Player play1,Player play2) throws IOException{
		this.play1=play1;
		this.play2=play2;
		this.g=new Game(play1,play2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(5,3));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		P1L=new JLabel("Player 1 Pick Your Leader");
		P1L.setFont(new Font("Unispace",Font.BOLD,15));
		P1L.setForeground(new Color(110,15,15));
		P1L.setVerticalAlignment(JLabel.CENTER);
		P1L.setHorizontalAlignment(JLabel.CENTER);
		P1L.setVisible(true);
		
		P1=new JLabel("Player 1 Pick Your Champion");
		P1.setFont(new Font("Unispace",Font.BOLD,15));
		P1.setForeground(new Color(110,15,15));
		P1.setVerticalAlignment(JLabel.CENTER);
		P1.setHorizontalAlignment(JLabel.CENTER);
		P1.setVisible(false);
		
		P2L=new JLabel("Player 2 Pick Your Leader");
		P2L.setFont(new Font("Unispace",Font.BOLD,15));
		P2L.setForeground(new Color(110,15,15));
		P2L.setVerticalAlignment(JLabel.CENTER);
		P2L.setHorizontalAlignment(JLabel.CENTER);
		P2L.setVisible(false);
		
		P2=new JLabel("Player 2 Pick Your Champion");
		P2.setFont(new Font("Unispace",Font.BOLD,15));
		P2.setForeground(new Color(110,15,15));
		P2.setVerticalAlignment(JLabel.CENTER);
		P2.setHorizontalAlignment(JLabel.CENTER);
		P2.setVisible(false);
		
		ImageIcon Logo= new ImageIcon("Logo.png");
		frame.setIconImage(Logo.getImage());
		ImageIcon Spiderimg= new ImageIcon("Spiderman.png");
		Spiderman=new JButton(Spiderimg);
		Spiderman.setBounds(740,650,500,500);
		ImageIcon Captainimg= new ImageIcon("Captain America.png");
		CaptainAmerica=new JButton(Captainimg);
		CaptainAmerica.setBounds(740,650,500,500);
		ImageIcon Deadpoolimg= new ImageIcon("Deadpool.png");
		Deadpool=new JButton(Deadpoolimg);
		Deadpool.setBounds(740,650,500,500);
		ImageIcon Drstrangeimg= new ImageIcon("Doctor Strange.png");
		DrStrange=new JButton(Drstrangeimg);
		DrStrange.setBounds(740,650,500,500);
		ImageIcon Electroimg= new ImageIcon("Electro.png");
		Electro=new JButton(Electroimg);
		Electro.setBounds(740,650,500,500);
		ImageIcon Ghostriderimg= new ImageIcon("Ghost Rider.png");
		GhostRider=new JButton(Ghostriderimg);
		GhostRider.setBounds(740,650,500,500);
		ImageIcon Helaimg= new ImageIcon("Hela.png");
		Hela=new JButton(Helaimg);
		Hela.setBounds(740,650,500,500);
		ImageIcon Hulkimg= new ImageIcon("Hulk.png");
		Hulk=new JButton(Hulkimg);
		Hulk.setBounds(740,650,500,500);
		ImageIcon Icemanimg= new ImageIcon("Iceman.png");
		Iceman=new JButton(Icemanimg);
		Iceman.setBounds(740,650,500,500);
		ImageIcon Ironmanimg= new ImageIcon("Iron Man.png");
		Ironman=new JButton(Ironmanimg);
		Ironman.setBounds(740,650,500,500);
		ImageIcon Lokiimg= new ImageIcon("Loki.png");
		Loki=new JButton(Lokiimg);
		Loki.setBounds(740,650,500,500);
		ImageIcon Quicksilverimg= new ImageIcon("Quicksilver.png");
		Quicksilver=new JButton(Quicksilverimg);
		Quicksilver.setBounds(740,650,500,500);
		ImageIcon Thorimg= new ImageIcon("Thor.png");
		Thor=new JButton(Thorimg);
		Thor.setBounds(740,650,500,500);
		ImageIcon Venomimg= new ImageIcon("Venom.png");
		Venom=new JButton(Venomimg);
		Venom.setBounds(740,650,500,500);
		ImageIcon Yellowimg= new ImageIcon("Yellow Jacket.png");
		YellowJacket=new JButton(Yellowimg);
		YellowJacket.setBounds(740,650,500,500);
		Spiderman.addActionListener(this);
		Spiderman.addMouseListener(this);
		CaptainAmerica.addActionListener(this);
		CaptainAmerica.addMouseListener(this);
		Deadpool.addActionListener(this);
		Deadpool.addMouseListener(this);
		DrStrange.addActionListener(this);
		DrStrange.addMouseListener(this);
		Electro.addActionListener(this);
		Electro.addMouseListener(this);
		GhostRider.addActionListener(this);
		GhostRider.addMouseListener(this);
		Hela.addActionListener(this);
		Hela.addMouseListener(this);
		Hulk.addActionListener(this);
		Hulk.addMouseListener(this);
		Iceman.addActionListener(this);
		Iceman.addMouseListener(this);
		Ironman.addActionListener(this);
		Ironman.addMouseListener(this);
		Loki.addActionListener(this);
		Loki.addMouseListener(this);
		Quicksilver.addActionListener(this);
		Quicksilver.addMouseListener(this);
		Thor.addActionListener(this);
		Thor.addMouseListener(this);
		Venom.addActionListener(this);
		Venom.addMouseListener(this);
		YellowJacket.addActionListener(this);
		YellowJacket.addMouseListener(this);
		frame.add(CaptainAmerica);
		frame.add(Deadpool);
		frame.add(DrStrange);
		frame.add(Electro);
		frame.add(GhostRider);
		frame.add(Hela);
		frame.add(Hulk);
		frame.add(Iceman);
		frame.add(Ironman);
		frame.add(Loki);
		frame.add(Quicksilver);
		frame.add(Spiderman);
		frame.add(Thor);
		frame.add(Venom);
		frame.add(YellowJacket);
		frame.add(P1L);
		frame.add(P1);
		frame.add(P2L);
		frame.add(P2);
		
}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
		JButton temp= (JButton) e.getSource();
			temp.setEnabled(false);
		if(((e.getSource()==Spiderman)||(e.getSource()==CaptainAmerica)||(e.getSource()==Deadpool)||(e.getSource()==DrStrange)||(e.getSource()==Electro)||(e.getSource()==GhostRider)||(e.getSource()==Hulk)||(e.getSource()==Hela)||(e.getSource()==Iceman)||(e.getSource()==Ironman)||(e.getSource()==Loki)||(e.getSource()==Quicksilver)||(e.getSource()==Thor)||(e.getSource()==Venom)||(e.getSource()==YellowJacket))) {
			
			if(turnNum==0) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play1.getTeam().add(c);
					play1.setLeader(c);
				}
				
				P1L.setVisible(false);
				P2L.setVisible(true);
				turnNum=1;
			}
			else if(turnNum==1) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play2.getTeam().add(c);
					play2.setLeader(c);
				}
				
				
				P2L.setVisible(false);
				P1.setVisible(true);
				turnNum=2;
				}
			else if(turnNum==2) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play1.getTeam().add(c);
					
				}
				
				P1.setVisible(false);
				P2.setVisible(true);
				turnNum=3;
				}
			else if(turnNum==3) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play2.getTeam().add(c);
					
				}
				
				P1.setVisible(true);
				P2.setVisible(false);
				turnNum=4;
				}
			else if(turnNum==4) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play1.getTeam().add(c);
					
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play1.getTeam().add(c);
					
				}
				
				
				P2.setVisible(true);
				P1.setVisible(false);
				turnNum=5;
			}
			else if(turnNum==5) {
				if(e.getSource()==CaptainAmerica) {
					Champion c=g.getAvailableChampions().get(0);
					c.getAbilities().add(g.getAvailableAbilities().get(0));
					c.getAbilities().add(g.getAvailableAbilities().get(1));
					c.getAbilities().add(g.getAvailableAbilities().get(2));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Deadpool) {
					Champion c=g.getAvailableChampions().get(1);
					c.getAbilities().add(g.getAvailableAbilities().get(3));
					c.getAbilities().add(g.getAvailableAbilities().get(4));
					c.getAbilities().add(g.getAvailableAbilities().get(5));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==DrStrange) {
					Champion c=g.getAvailableChampions().get(2);
					c.getAbilities().add(g.getAvailableAbilities().get(6));
					c.getAbilities().add(g.getAvailableAbilities().get(7));
					c.getAbilities().add(g.getAvailableAbilities().get(8));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Electro) {
					Champion c=g.getAvailableChampions().get(3);
					c.getAbilities().add(g.getAvailableAbilities().get(9));
					c.getAbilities().add(g.getAvailableAbilities().get(10));
					c.getAbilities().add(g.getAvailableAbilities().get(11));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==GhostRider) {
					Champion c=g.getAvailableChampions().get(4);
					c.getAbilities().add(g.getAvailableAbilities().get(12));
					c.getAbilities().add(g.getAvailableAbilities().get(13));
					c.getAbilities().add(g.getAvailableAbilities().get(14));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Hela) {
					Champion c=g.getAvailableChampions().get(5);
					c.getAbilities().add(g.getAvailableAbilities().get(15));
					c.getAbilities().add(g.getAvailableAbilities().get(16));
					c.getAbilities().add(g.getAvailableAbilities().get(17));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Hulk) {
					Champion c=g.getAvailableChampions().get(6);
					c.getAbilities().add(g.getAvailableAbilities().get(18));
					c.getAbilities().add(g.getAvailableAbilities().get(19));
					c.getAbilities().add(g.getAvailableAbilities().get(20));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Iceman) {
					Champion c=g.getAvailableChampions().get(7);
					c.getAbilities().add(g.getAvailableAbilities().get(21));
					c.getAbilities().add(g.getAvailableAbilities().get(22));
					c.getAbilities().add(g.getAvailableAbilities().get(23));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Ironman) {
					Champion c=g.getAvailableChampions().get(8);
					c.getAbilities().add(g.getAvailableAbilities().get(24));
					c.getAbilities().add(g.getAvailableAbilities().get(25));
					c.getAbilities().add(g.getAvailableAbilities().get(26));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Loki) {
					Champion c=g.getAvailableChampions().get(9);
					c.getAbilities().add(g.getAvailableAbilities().get(27));
					c.getAbilities().add(g.getAvailableAbilities().get(28));
					c.getAbilities().add(g.getAvailableAbilities().get(29));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Quicksilver) {
					Champion c=g.getAvailableChampions().get(10);
					c.getAbilities().add(g.getAvailableAbilities().get(30));
					c.getAbilities().add(g.getAvailableAbilities().get(31));
					c.getAbilities().add(g.getAvailableAbilities().get(32));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Spiderman) {
					Champion c=g.getAvailableChampions().get(11);
					c.getAbilities().add(g.getAvailableAbilities().get(33));
					c.getAbilities().add(g.getAvailableAbilities().get(34));
					c.getAbilities().add(g.getAvailableAbilities().get(35));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Thor) {
					Champion c=g.getAvailableChampions().get(12);
					c.getAbilities().add(g.getAvailableAbilities().get(36));
					c.getAbilities().add(g.getAvailableAbilities().get(37));
					c.getAbilities().add(g.getAvailableAbilities().get(38));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==Venom) {
					Champion c=g.getAvailableChampions().get(13);
					c.getAbilities().add(g.getAvailableAbilities().get(39));
					c.getAbilities().add(g.getAvailableAbilities().get(40));
					c.getAbilities().add(g.getAvailableAbilities().get(41));
					play2.getTeam().add(c);
					
				}
				else if(e.getSource()==YellowJacket) {
					Champion c=g.getAvailableChampions().get(14);
					c.getAbilities().add(g.getAvailableAbilities().get(42));
					c.getAbilities().add(g.getAvailableAbilities().get(43));
					c.getAbilities().add(g.getAvailableAbilities().get(44));
					play2.getTeam().add(c);
					System.out.println("Kimo");
					
				}
				this.g=new Game(play1,play2);
				frame.dispose();
				CapPop.dispose();
				DeadPop.dispose();
				DocPop.dispose();
				ElectroPop.dispose();
				GhostPop.dispose();
				HelaPop.dispose();
				HulkPop.dispose();
				IcePop.dispose();
				IronManPop.dispose();
				LokiPop.dispose();
				QuickPop.dispose();
				SpideyPop.dispose();
				ThorPop.dispose();
				VenomPop.dispose();
				YellowPop.dispose();
				new GameWindow(g);
				
			}
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==CaptainAmerica) {
			CapPop.setSize(500,500);
			Caplbl.setBounds(0,0,500,500);
			Caplbl.setIcon(CapImg);
			Caplbl.setVisible(true);
			CapPop.add(Caplbl);
			CapPop.setVisible(true);
			
		}
		if(e.getSource()==Deadpool) {
			DeadPop.setSize(500,500);
			Deadlbl.setBounds(0,0,500,500);
			Deadlbl.setIcon(DeadImg);
			Deadlbl.setVisible(true);
			DeadPop.add(Deadlbl);
			DeadPop.setVisible(true);
			
		}
		if(e.getSource()==DrStrange) {
			DocPop.setSize(500,500);
			Doclbl.setBounds(0,0,500,500);
			Doclbl.setIcon(DocImg);
			Doclbl.setVisible(true);
			DocPop.add(Doclbl);
			DocPop.setVisible(true);
			
		}
		if(e.getSource()==Electro) {
			ElectroPop.setSize(500,500);
			Electrolbl.setBounds(0,0,500,500);
			Electrolbl.setIcon(ElectroImg);
			Electrolbl.setVisible(true);
			ElectroPop.add(Electrolbl);
			ElectroPop.setVisible(true);
			
		}
		if(e.getSource()==GhostRider) {
			GhostPop.setSize(500,500);
			Ghostlbl.setBounds(0,0,500,500);
			Ghostlbl.setIcon(GhostImg);
			Ghostlbl.setVisible(true);
			GhostPop.add(Ghostlbl);
			GhostPop.setVisible(true);
			
		}
		if(e.getSource()==Hela) {
			HelaPop.setSize(500,500);
			Helalbl.setBounds(0,0,500,500);
			Helalbl.setIcon(HelaImg);
			Helalbl.setVisible(true);
			HelaPop.add(Helalbl);
			HelaPop.setVisible(true);
			
		}
		if(e.getSource()==Hulk) {
			HulkPop.setSize(500,500);
			Hulklbl.setBounds(0,0,500,500);
			Hulklbl.setIcon(HulkImg);
			Hulklbl.setVisible(true);
			HulkPop.add(Hulklbl);
			HulkPop.setVisible(true);
			
		}
	
		if(e.getSource()==Ironman) {
			IronManPop.setSize(500,500);
			IronManlbl.setBounds(0,0,500,500);
			IronManlbl.setIcon(IronManImg);
			IronManlbl.setVisible(true);
			IronManPop.add(IronManlbl);
			IronManPop.setVisible(true);
			
		}
		if(e.getSource()==Loki) {
			LokiPop.setSize(500,500);
			Lokilbl.setBounds(0,0,500,500);
			Lokilbl.setIcon(LokiImg);
			Lokilbl.setVisible(true);
			LokiPop.add(Lokilbl);
			LokiPop.setVisible(true);
			
		}
		if(e.getSource()==Quicksilver) {
			QuickPop.setSize(500,500);
			Quicklbl.setBounds(0,0,500,500);
			Quicklbl.setIcon(QuickImg);
			Quicklbl.setVisible(true);
			QuickPop.add(Quicklbl);
			QuickPop.setVisible(true);
			
		}
		if(e.getSource()==Iceman) {
			IcePop.setSize(500,500);
			Icelbl.setBounds(0,0,500,500);
			Icelbl.setIcon(IceImg);
			Icelbl.setVisible(true);
			IcePop.add(Icelbl);
			IcePop.setVisible(true);
			
		}
		if(e.getSource()==Spiderman) {
			SpideyPop.setSize(500,500);
			Spideylbl.setBounds(0,0,500,500);
			Spideylbl.setIcon(SpideyImg);
			Spideylbl.setVisible(true);
			SpideyPop.add(Spideylbl);
			SpideyPop.setVisible(true);
			
		}
		if(e.getSource()==Thor) {
			ThorPop.setSize(500,500);
			Thorlbl.setBounds(0,0,500,500);
			Thorlbl.setIcon(ThorImg);
			Thorlbl.setVisible(true);
			ThorPop.add(Thorlbl);
			ThorPop.setVisible(true);
			
		}
		if(e.getSource()==Venom) {
			VenomPop.setSize(500,500);
			Venomlbl.setBounds(0,0,500,500);
			Venomlbl.setIcon(VenomImg);
			Venomlbl.setVisible(true);
			VenomPop.add(Venomlbl);
			VenomPop.setVisible(true);
			
		}
		if(e.getSource()==YellowJacket) {
			YellowPop.setSize(500,500);
			Yellowlbl.setBounds(0,0,500,500);
			Yellowlbl.setIcon(YellowImg);
			Yellowlbl.setVisible(true);
			YellowPop.add(Yellowlbl);
			YellowPop.setVisible(true);
			
		}
		
		
	
	
	
	
	}



	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==CaptainAmerica) {
			CapPop.dispose();
		}
		if(e.getSource()==Deadpool) {
			DeadPop.dispose();
		}
		if(e.getSource()==DrStrange) {
			DocPop.dispose();
		}
		if(e.getSource()==Electro) {
			ElectroPop.dispose();
		}
		if(e.getSource()==GhostRider) {
			GhostPop.dispose();
		}
		if(e.getSource()==Hela) {
			HelaPop.dispose();
		}
		if(e.getSource()==Hulk) {
			HulkPop.dispose();
		}
		if(e.getSource()==Iceman) {
			IcePop.dispose();
		}
		if(e.getSource()==Ironman) {
			IronManPop.dispose();
		}
		if(e.getSource()==Loki) {
			LokiPop.dispose();
		}
		if(e.getSource()==Quicksilver) {
			QuickPop.dispose();
		}
		if(e.getSource()==Spiderman) {
			SpideyPop.dispose();
		}
		if(e.getSource()==Thor) {
			ThorPop.dispose();
		}
		if(e.getSource()==Venom) {
			VenomPop.dispose();
		}
		if(e.getSource()==YellowJacket) {
			YellowPop.dispose();
		}
		
		
	}
}
		
	
	


