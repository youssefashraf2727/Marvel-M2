package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;


public class GameWindow implements ActionListener, MouseListener {
	
	JPanel pan1,pan2,pan3;
	JFrame fr,temp;
	JButton up,down,left,right,leaderAbility,endTurn,attack,move,ability1,ability2,ability3;
	JLabel currName,currType,currStats,currEffects,currAA,p1name,t;
	ImageIcon CaptainAmericaig,Deadpoolig,Docig,Electroig,Ghostig,Helaig,Hulkig,Icemanig,Ironmanig,Lokiig,Quickig,Spideyig,Thorig,Venomig,Yellowig,Cov;
	JButton[] buttonarray;
	String c1,c2,c3,c4,c5,c6,original;
	String[] champnames1,champnames2;
	Border border,border2;
	Direction dd;
	public Game maingame;
	int kx,ky;
	
	public GameWindow(Game game) {	
		fr=new JFrame();
		temp=new JFrame();
		t=new JLabel();
		t.setForeground(new Color(110,15,15));
		t.setFont(new Font("Unispace",Font.BOLD,14));
		fr.setSize(1920,1070);
		fr.setLayout(new BorderLayout(10,10));
		
		pan1=new JPanel();
        pan2=new JPanel();
        pan3=new JPanel();
       
        pan1.setLayout(new GridLayout(5,5));
        
        
        
        pan1.setBounds(0,0,1600,1020);
        pan2.setLayout(new GridLayout(8,1));
        pan2.setBounds(1600,0,320,700);
        
        pan3.setLayout(new BorderLayout());
        pan3.setBounds(1600, 700, 280, 380);
        
        border= BorderFactory.createLineBorder(Color.BLUE, 3);
        border2= BorderFactory.createLineBorder(new Color(110,15,15), 3);
        
        p1name=new JLabel(game.getFirstPlayer().getName());
        p1name.setBounds(1705,960,120,50);
        p1name.setFont(new Font("Unispace",Font.BOLD,14));
        p1name.setForeground(new Color(110,15,15));
        
        
        if(game.getCurrentChampion() instanceof Hero) {
        	currType=new JLabel("Type: Hero");
        }
        if(game.getCurrentChampion() instanceof AntiHero) {
        	currType=new JLabel("Type: AntiHero");
        }
        if(game.getCurrentChampion() instanceof Villain) {
        	currType=new JLabel("Type: Villain");
        }
        currName=new JLabel();
        if(game.getCurrentChampion()==game.getFirstPlayer().getLeader() ||game.getCurrentChampion()==game.getSecondPlayer().getLeader()) {
        	currName.setText(game.getCurrentChampion().getName()+" (Leader)");
        	}
        else currName.setText(game.getCurrentChampion().getName());
        
        currName.setText("<html><center>"+game.getSecondPlayer().getName()+"<br/>"+currName.getText()+"</center></html>");
        currName.setBounds(1620,50,290,100);
        currName.setBorder(border);
        currName.setHorizontalAlignment(JLabel.CENTER);
        currName.setFont(new Font("Unispace",Font.BOLD,16));
        currName.setForeground(new Color(110,15,15));
        
        currType.setBounds(1620,150,290,100);
        currType.setBorder(border);
        currType.setHorizontalAlignment(JLabel.CENTER);
        currType.setFont(new Font("Unispace",Font.BOLD,16));
        currType.setForeground(new Color(110,15,15));
        
        currStats=new JLabel("HP: "+game.getCurrentChampion().getCurrentHP()+"/"+game.getCurrentChampion().getMaxHP()+"  Mana: "+game.getCurrentChampion().getMana()
        		+"  Action Points: "+game.getCurrentChampion().getCurrentActionPoints()+"/"+game.getCurrentChampion().getMaxActionPointsPerTurn());
        currStats.setBounds(1620,250,290,100);
        currStats.setBorder(border);
        currStats.setHorizontalAlignment(JLabel.CENTER);
        currStats.setFont(new Font("Unispace",Font.BOLD,10));
        currStats.setForeground(new Color(110,15,15));
        
        currEffects=new JLabel();
        currEffects.setBounds(1620,350,290,100);
        currEffects.setBorder(border);
        currEffects.setHorizontalAlignment(JLabel.CENTER);
        currEffects.setFont(new Font("Unispace",Font.BOLD,10));
        currEffects.setForeground(new Color(110,15,15));
        
        
        
        currAA=new JLabel("Attack Damage: "+game.getCurrentChampion().getAttackDamage()+"  Attack Range: "+game.getCurrentChampion().getAttackDamage());
        currAA.setBounds(1620,350,290,100);
        currAA.setBorder(border);
        currAA.setHorizontalAlignment(JLabel.CENTER);
        currAA.setFont(new Font("Unispace",Font.BOLD,10));
        currAA.setForeground(new Color(110,15,15));
        
        pan1.setBackground(new Color(110,15,15));
        pan2.setBackground(new Color(35,35,35));
        pan1.setBorder(border2);
        pan2.setBorder(border2);
        pan3.setBorder(border2);
        pan3.setBackground(new Color(0,0,0));
        up=new JButton("^");
        down=new JButton("v");
        left=new JButton("<");
        right=new JButton(">");
        endTurn=new JButton("End");
        move=new JButton("Move");
        leaderAbility=new JButton("Ult");
        attack=new JButton("AA");
        ability1=new JButton(game.getCurrentChampion().getAbilities().get(0).getName());
        ability2=new JButton(game.getCurrentChampion().getAbilities().get(1).getName());
        ability3=new JButton(game.getCurrentChampion().getAbilities().get(2).getName());
        
        up.setBounds(1735,850,60,60);
        down.setBounds(1735, 910, 60, 60);
        left.setBounds(1675,910,60,60);
        right.setBounds(1795,910,60,60);
        move.setBounds(1795,850,60,60);
        leaderAbility.setBounds(1855,850,55,120);
        endTurn.setBounds(1675,850,60,60);
        attack.setBounds(1620,850,55,120);
        ability1.setBounds(1620,800,290,50);
        ability2.setBounds(1620,750,290,50);
        ability3.setBounds(1620,700,290,50);
        
        up.setFont(new Font("Arial", Font.BOLD, 35));
        up.setForeground(new Color(110,15,15));
        down.setFont(new Font("Arial", Font.BOLD, 30));
        down.setForeground(new Color(110,15,15));
        left.setFont(new Font("Arial", Font.BOLD, 35));
        left.setForeground(new Color(110,15,15));
        right.setFont(new Font("Arial", Font.BOLD, 35));
        right.setForeground(new Color(110,15,15));
        move.setForeground(new Color(110,15,15));
        move.setFont(new Font("Unispace",Font.BOLD,9));
        endTurn.setForeground(new Color(110,15,15));
        endTurn.setFont(new Font("Unispace",Font.BOLD,9));
        leaderAbility.setFont(new Font("Unispace",Font.BOLD,10));
        leaderAbility.setForeground(new Color(110,15,15));
        attack.setFont(new Font("Unispace",Font.BOLD,14));
        attack.setForeground(new Color(110,15,15));
        ability1.setFont(new Font("Unispace",Font.BOLD,14));
        ability1.setForeground(new Color(110,15,15));
        ability2.setFont(new Font("Unispace",Font.BOLD,14));
        ability2.setForeground(new Color(110,15,15));
        ability3.setFont(new Font("Unispace",Font.BOLD,14));
        ability3.setForeground(new Color(110,15,15));
        
        attack.setBackground(new Color(35,35,35));
        leaderAbility.setBackground(new Color(35,35,35));
        up.setBackground(new Color(35,35,35));
        down.setBackground(new Color(35,35,35));
        left.setBackground(new Color(35,35,35));
        right.setBackground(new Color(35,35,35));
        endTurn.setBackground(new Color(35,35,35));
        move.setBackground(new Color(35,35,35));
        ability1.setBackground(new Color(35,35,35));
        ability2.setBackground(new Color(35,35,35));
        ability3.setBackground(new Color(35,35,35));
        
        move.addActionListener(this);
        up.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        down.addActionListener(this);
        endTurn.addActionListener(this);
        leaderAbility.addActionListener(this);
        attack.addActionListener(this);
        ability1.addActionListener(this);
        ability2.addActionListener(this);
        ability3.addActionListener(this);
        
        ability1.addMouseListener(this);
        ability2.addMouseListener(this);
        ability3.addMouseListener(this);
        
        CaptainAmericaig=new ImageIcon("CaptainAmericaingame.png");
        Deadpoolig=new ImageIcon("Deadpoolingame.png");
        Docig=new ImageIcon("DoctorStrangeingame.png");
        Electroig=new ImageIcon("Electroingame.png");
        Ghostig=new ImageIcon("GhostRideringame.png");
        Helaig=new ImageIcon("Helaingame.png");
        Hulkig=new ImageIcon("Hulkingame.png");
        Icemanig=new ImageIcon("Icemaningame.png");
        Ironmanig=new ImageIcon("IronManingame.png");
        Lokiig=new ImageIcon("Lokiingame.png");
        Quickig=new ImageIcon("Quicksilveringame.png");
        Spideyig=new ImageIcon("Spidermaningame.png");
        Thorig=new ImageIcon("Thoringame.png");
        Venomig=new ImageIcon("Venomingame.png");
        Yellowig=new ImageIcon("Yellowingame.png");
        Cov=new ImageIcon("Cover.png");
        
        maingame=game;
        maingame.placeChampions();
        
        pan2.add(currName);
        pan2.add(currType);
        pan2.add(currStats);
        pan2.add(currAA);
        pan2.add(currEffects);
        
        buttongrid(pan1);
        pan3.add(p1name);
        pan3.add(endTurn);
        pan3.add(leaderAbility);
        pan3.add(move);
        pan3.add(up);
        pan3.add(down);
        pan3.add(left);
        pan3.add(right);
        pan3.add(attack);
        pan3.add(ability1);
        pan3.add(ability2);
        pan3.add(ability3);
        pan3.add(new JLabel(""));
        
        fr.setIconImage(Toolkit.getDefaultToolkit().getImage("Logo.png"));
        fr.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        fr.add(pan1);
        fr.add(pan2);
        fr.add(pan3);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
		}
	
	public void buttongrid(JPanel z) {
		Object[][] board=maingame.getBoard();
		for(int i=4;i>=0;i--) {
			for(int j=0;j<5;j++) {
				final int xnew=i;
				final int ynew=j;
				JButton grid=new JButton();
				if(board[i][j]==null) {
					grid=new JButton();
					
				}
				if(board[i][j] instanceof Cover) {
					grid=new JButton();
					
					grid.setIcon(Cov);
				}
				if(board[i][j] instanceof Champion) {
					grid=new JButton();
					if(((Champion)board[i][j]).getName().equals("Captain America")) {
						grid.setIcon(CaptainAmericaig);
					}
					if(((Champion)board[i][j]).getName().equals("Deadpool")) {
						grid.setIcon(Deadpoolig);
					}
					if(((Champion)board[i][j]).getName().equals("Dr Strange")) {
						grid.setIcon(Docig);
					}
					if(((Champion)board[i][j]).getName().equals("Electro")) {
						grid.setIcon(Electroig);
					}
					if(((Champion)board[i][j]).getName().equals("Ghost Rider")) {
						grid.setIcon(Ghostig);
					}
					if(((Champion)board[i][j]).getName().equals("Hela")) {
						grid.setIcon(Helaig);
					}
					if(((Champion)board[i][j]).getName().equals("Hulk")) {
						grid.setIcon(Hulkig);
					}
					if(((Champion)board[i][j]).getName().equals("Iceman")) {
						grid.setIcon(Icemanig);
					}
					if(((Champion)board[i][j]).getName().equals("Ironman")) {
						grid.setIcon(Ironmanig);
					}
					if(((Champion)board[i][j]).getName().equals("Loki")) {
						grid.setIcon(Lokiig);
					}
					if(((Champion)board[i][j]).getName().equals("Quicksilver")) {
						grid.setIcon(Quickig);
					}
					if(((Champion)board[i][j]).getName().equals("Spiderman")) {
						grid.setIcon(Spideyig);
					}
					if(((Champion)board[i][j]).getName().equals("Thor")) {
						grid.setIcon(Thorig);
					}
					if(((Champion)board[i][j]).getName().equals("Venom")) {
						grid.setIcon(Venomig);
					}
					if(((Champion)board[i][j]).getName().equals("Yellow Jacket")) {
						grid.setIcon(Yellowig);
					}
					
				}
				grid.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        kx=xnew;
                        ky=ynew;

                    }
                });
				grid.setBackground(new Color(35,35,35));
				z.add(grid);
				z.updateUI();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==up) {
			dd=Direction.UP;
		}
		if(e.getSource()==down) {
			dd=Direction.DOWN;
		}
		if(e.getSource()==left) {
			dd=Direction.LEFT;
		}
		if(e.getSource()==right) {
			dd=Direction.RIGHT;
		}
		
		
		
		
		if(e.getSource()==move) {
			try {
				maingame.move(dd);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pan1, e1.getMessage());
			}
			 currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
		        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			pan1.removeAll();
			buttongrid(pan1);
		}
		
		
		if(e.getSource()==endTurn) {
			maingame.endTurn();
			ability1.setText(maingame.getCurrentChampion().getAbilities().get(0).getName());
			ability2.setText(maingame.getCurrentChampion().getAbilities().get(1).getName());
			ability3.setText(maingame.getCurrentChampion().getAbilities().get(2).getName());
			if(maingame.getCurrentChampion()==maingame.getFirstPlayer().getLeader() ||maingame.getCurrentChampion()==maingame.getSecondPlayer().getLeader()) {
	        	currName.setText(maingame.getCurrentChampion().getName()+" (Leader)");
	        	}
	        else currName.setText(maingame.getCurrentChampion().getName());
			
			currName.setText("<html><center>"+maingame.getSecondPlayer().getName()+"<br/>"+currName.getText()+"</center></html>");
			
			 if(maingame.getCurrentChampion() instanceof Hero) {
		        	currType.setText("Type: Hero");
		        }
		        if(maingame.getCurrentChampion() instanceof AntiHero) {
		        	currType.setText("Type: AntiHero");
		        }
		        if(maingame.getCurrentChampion() instanceof Villain) {
		        	currType.setText("Type: Villain");
		        }
		    
		        
		    currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
	        +"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
		    
		    currAA.setText("Attack Damage: "+maingame.getCurrentChampion().getAttackDamage()+"  Attack Range: "+maingame.getCurrentChampion().getAttackDamage());
		    
		    currEffects.setText("");
		    if(maingame.getCurrentChampion().getAppliedEffects().size()>0) {
	        	for(int i=0;i<maingame.getCurrentChampion().getAppliedEffects().size();i++) {
	        			if(!currEffects.getText().equals("")) {
	        			currEffects.setText(maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
	        			}
	        			else currEffects.setText(currEffects.getText()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
	        	}
	  }
		    
		    
		    
		    
			pan1.removeAll();
			buttongrid(pan1);
		}
		
		
		if(e.getSource()==leaderAbility) {
			try {
				maingame.useLeaderAbility();
			} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(pan1, e1.getMessage());
				
			}
			 currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
		        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			 
			 
			 if(maingame.getCurrentChampion().getAppliedEffects().size()>0) {
		        	for(int i=0;i<maingame.getCurrentChampion().getAppliedEffects().size();i++) {
		        		if(!currEffects.getText().equals("")) {
		        			currEffects.setText(maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        			}
		        			else currEffects.setText(currEffects.getText()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        }
		  }
			
			 
			
			if(maingame.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(pan1, maingame.checkGameOver().getName()+" has won!");
			fr.dispose();}
			pan1.removeAll();
			buttongrid(pan1);
		}
		
		
		if(e.getSource()==attack) {
			try {
				maingame.attack(dd);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(pan1, e1.getMessage());
			} 
			currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
	        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			
			
			
			
			if(maingame.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(pan1, maingame.checkGameOver().getName()+" has won!");
			fr.dispose();}
			pan1.removeAll();
			buttongrid(pan1);
		}
		
		if(e.getSource()==ability1) {
			if(maingame.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SELFTARGET || maingame.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.TEAMTARGET || maingame.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SURROUND) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(0));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(0), dd);
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET) {
				
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(0), kx, ky);
				} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
						| CloneNotSupportedException e1) {
					
					JOptionPane.showMessageDialog(pan1, "<html><center>"+e1.getMessage()+"<br/>"+"Select a champion and use your singletarget ability if off cooldown"+"</center></html>");
				}
			}
			
			
			currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
	        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			
			 if(maingame.getCurrentChampion().getAppliedEffects().size()>0) {
		        for(int i=0;i<maingame.getCurrentChampion().getAppliedEffects().size();i++) {
		        	if(!currEffects.getText().equals("")) {
		        		currEffects.setText(maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        		}
		        		else currEffects.setText(currEffects.getText()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        }
		     }
			 
			if(maingame.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(pan1, maingame.checkGameOver().getName()+" has won!");
			fr.dispose();}
			pan1.removeAll();
			buttongrid(pan1); 
		}
		else if(e.getSource()==ability2) {
			if(maingame.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SELFTARGET || maingame.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.TEAMTARGET || maingame.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SURROUND) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(1));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(1), dd);
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET) {
				
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(1), kx, ky);
				} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
						| CloneNotSupportedException e1) {
					
					JOptionPane.showMessageDialog(pan1, "<html><center>"+e1.getMessage()+"<br/>"+"Select a champion and use your singletarget ability if off cooldown"+"</center></html>");
				}
			}
			
			
			currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
	        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			
			 if(maingame.getCurrentChampion().getAppliedEffects().size()>0) {
		        for(int i=0;i<maingame.getCurrentChampion().getAppliedEffects().size();i++) {
		        	if(!currEffects.getText().equals("")) {
		        		currEffects.setText(maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        		}
		        		else currEffects.setText(currEffects.getText()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        }
		     }
			 
			if(maingame.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(pan1, maingame.checkGameOver().getName()+" has won!");
			fr.dispose();}
			pan1.removeAll();
			buttongrid(pan1); 
		}
		else if(e.getSource()==ability3) {
			if(maingame.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SELFTARGET || maingame.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.TEAMTARGET || maingame.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SURROUND) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(2));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(0), dd);
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(pan1, e1.getMessage());
				}
			}
			else if(maingame.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET) {
				
				try {
					maingame.castAbility(maingame.getCurrentChampion().getAbilities().get(2), kx, ky);
				} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
						| CloneNotSupportedException e1) {
					
					JOptionPane.showMessageDialog(pan1, "<html><center>"+e1.getMessage()+"<br/>"+"Select a champion and use your singletarget ability if off cooldown"+"</center></html>");
				}
			}
			
			
			currStats.setText("HP: "+maingame.getCurrentChampion().getCurrentHP()+"/"+maingame.getCurrentChampion().getMaxHP()+"  Mana: "+maingame.getCurrentChampion().getMana()
	        		+"  Action Points: "+maingame.getCurrentChampion().getCurrentActionPoints()+"/"+maingame.getCurrentChampion().getMaxActionPointsPerTurn());
			
			 if(maingame.getCurrentChampion().getAppliedEffects().size()>0) {
		        for(int i=0;i<maingame.getCurrentChampion().getAppliedEffects().size();i++) {
		        	if(!currEffects.getText().equals("")) {
		        		currEffects.setText(maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        		}
		        		else currEffects.setText(currEffects.getText()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getName()+" "+maingame.getCurrentChampion().getAppliedEffects().get(i).getDuration());
		        }
		     }
			 
			if(maingame.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(pan1, maingame.checkGameOver().getName()+" has won!");
			fr.dispose();}
			pan1.removeAll();
			buttongrid(pan1); 
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==ability1) {
			temp.setBounds(1660,500,200,200);
			t.setBounds(300,300,200,200);
			
			if(maingame.getCurrentChampion().getAbilities().get(0) instanceof DamagingAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(0).getCastArea().name()+"<br/>"+"Type: Damaging"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(0).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(0).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(0).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(0).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(0).getBaseCooldown()+"<br/>"+"Damage Amount: "+ ((DamagingAbility)(maingame.getCurrentChampion().getAbilities().get(0))).getDamageAmount());
			}
			
			if(maingame.getCurrentChampion().getAbilities().get(0) instanceof HealingAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(0).getCastArea().name()+"<br/>"+"Type: Healing"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(0).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(0).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(0).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(0).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(0).getBaseCooldown()+"<br/>"+"Healing Amount: "+ ((HealingAbility)(maingame.getCurrentChampion().getAbilities().get(0))).getHealAmount());
			}
			
			if(maingame.getCurrentChampion().getAbilities().get(0) instanceof CrowdControlAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(0).getCastArea().name()+"<br/>"+"Type: Crowd Control"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(0).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(0).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(0).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(0).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(0).getBaseCooldown()+"<br/>"+"CC Type: "+ ((CrowdControlAbility)(maingame.getCurrentChampion().getAbilities().get(0))).getEffect().getName());
			}
			
			t.setVisible(true);
			temp.add(t);
			temp.setVisible(true);
		}
		if(e.getSource()==ability2) {
			temp.setBounds(1660,500,200,200);
			t.setBounds(300,300,200,200);
			if(maingame.getCurrentChampion().getAbilities().get(1) instanceof DamagingAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(1).getCastArea().name()+"<br/>"+"Type: Damaging"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(1).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(1).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(1).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(1).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(1).getBaseCooldown()+"<br/>"+"Damage Amount: "+ ((DamagingAbility)(maingame.getCurrentChampion().getAbilities().get(1))).getDamageAmount());
			}
			if(maingame.getCurrentChampion().getAbilities().get(1) instanceof HealingAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(1).getCastArea().name()+"<br/>"+"Type: Healing"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(1).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(1).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(1).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(1).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(1).getBaseCooldown()+"<br/>"+"Healing Amount: "+ ((HealingAbility)(maingame.getCurrentChampion().getAbilities().get(1))).getHealAmount());
			}
			if(maingame.getCurrentChampion().getAbilities().get(1) instanceof CrowdControlAbility) {
			t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(1).getCastArea().name()+"<br/>"+"Type: Crowd Control"+"<br/>"+"Range: "
			+maingame.getCurrentChampion().getAbilities().get(1).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(1).getManaCost())
			+","+maingame.getCurrentChampion().getAbilities().get(1).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(1).getCurrentCooldown()+","
			+maingame.getCurrentChampion().getAbilities().get(1).getBaseCooldown()+"<br/>"+"CC Type: "+ ((CrowdControlAbility)(maingame.getCurrentChampion().getAbilities().get(1))).getEffect().getName());
			}
			t.setVisible(true);
			temp.add(t);
			temp.setVisible(true);
			}
		
		if(e.getSource()==ability3) {
				temp.setBounds(1660,500,200,200);
				t.setBounds(300,300,200,200);
				if(maingame.getCurrentChampion().getAbilities().get(2) instanceof DamagingAbility) {
				t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(2).getCastArea().name()+"<br/>"+"Type: Damaging"+"<br/>"+"Range: "
				+maingame.getCurrentChampion().getAbilities().get(2).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(2).getManaCost())
				+","+maingame.getCurrentChampion().getAbilities().get(2).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(2).getCurrentCooldown()+","
				+maingame.getCurrentChampion().getAbilities().get(2).getBaseCooldown()+"<br/>"+"Damage Amount: "+ ((DamagingAbility)(maingame.getCurrentChampion().getAbilities().get(2))).getDamageAmount());
				}
				if(maingame.getCurrentChampion().getAbilities().get(2) instanceof HealingAbility) {
				t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(2).getCastArea().name()+"<br/>"+"Type: Healing"+"<br/>"+"Range: "
				+maingame.getCurrentChampion().getAbilities().get(2).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(2).getManaCost())
				+","+maingame.getCurrentChampion().getAbilities().get(2).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(2).getCurrentCooldown()+","
				+maingame.getCurrentChampion().getAbilities().get(2).getBaseCooldown()+"<br/>"+"Healing Amount: "+ ((HealingAbility)(maingame.getCurrentChampion().getAbilities().get(2))).getHealAmount());
				}
				if(maingame.getCurrentChampion().getAbilities().get(2) instanceof CrowdControlAbility) {
				t.setText("<html><center>"+"Cast Area: "+maingame.getCurrentChampion().getAbilities().get(2).getCastArea().name()+"<br/>"+"Type: Crowd Control"+"<br/>"+"Range: "
				+maingame.getCurrentChampion().getAbilities().get(2).getCastRange()+"<br/>"+"Mana and Action cost: "+Integer.toString(maingame.getCurrentChampion().getAbilities().get(2).getManaCost())
				+","+maingame.getCurrentChampion().getAbilities().get(2).getRequiredActionPoints()+"<br/>"+"Cooldowns: "+ maingame.getCurrentChampion().getAbilities().get(2).getCurrentCooldown()+","
				+maingame.getCurrentChampion().getAbilities().get(2).getBaseCooldown()+"<br/>"+"CC Type: "+ ((CrowdControlAbility)(maingame.getCurrentChampion().getAbilities().get(2))).getEffect().getName());
				}
				
				t.setVisible(true);
				temp.add(t);
				temp.setVisible(true);
			}
			
		
		}
		
		
	

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==ability1 || e.getSource()==ability2 || e.getSource()==ability3 ) {
			temp.dispose();
		}
		
		
	}

}
