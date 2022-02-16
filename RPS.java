package rps;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class RPS extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame  frame;
	private JButton rock;
	private JButton paper;
	private JButton scissors;
	private JLabel 	userchoice;
	private JLabel 	computerchoice;
	private JLabel userresult;
	private JLabel draws;
	private JLabel pcresults;
	private JLabel gameovertext;
	
	public RPS() {
		Font font = new Font( "Times new Roman", Font.BOLD, 36 );
		Border outer = BorderFactory.createEmptyBorder( 0, 20, 0, 20 );
		Border inner = BorderFactory.createLineBorder( Color.blue, 3 );
		frame=new JFrame();
		Container cp1=frame.getContentPane();
		cp1.setLayout(new BoxLayout(cp1, BoxLayout.Y_AXIS));
		frame.setPreferredSize( new Dimension( 700, 600 ) );
		frame.setMinimumSize(new Dimension(700,550));
		frame.add(Box.createVerticalStrut(5));
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    JPanel panel1=new JPanel();
	    panel1.setBorder( new CompoundBorder( outer, inner ) );
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setPreferredSize( new Dimension( 150, 200 ) );
		panel1.add(Box.createVerticalStrut(15));
		JPanel players=new JPanel();
		players.setLayout(new BoxLayout(players, BoxLayout.X_AXIS));
		players.add(Box.createHorizontalStrut(100));
		ImageIcon usericon = new ImageIcon("Human.jpg");
		Image userimg = usericon.getImage();
		Image newuserimg = userimg.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); 
		usericon = new ImageIcon(newuserimg);
		ImageIcon user=usericon;
		players.add(new JLabel(user));
		players.add(Box.createHorizontalGlue());
		ImageIcon computericon = new ImageIcon("Computer.jpg");
		Image computerimg = computericon.getImage();
		Image newcomputerimg = computerimg.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); 
		computericon = new ImageIcon(newcomputerimg);
		ImageIcon computer=computericon;
		players.add(new JLabel(computer));
		players.add(Box.createHorizontalStrut(100));
		JPanel choice=new JPanel();
		choice.setLayout(new BoxLayout(choice, BoxLayout.X_AXIS));
		ImageIcon emptyicon = new ImageIcon("blank.jpg");
		Image emptyimg = emptyicon.getImage();
		Image newemptyimg = emptyimg.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); 
		emptyicon = new ImageIcon(newemptyimg);
		ImageIcon empty=emptyicon;
		inner = BorderFactory.createLineBorder( Color.black, 3 );
		userchoice=new JLabel(empty);
		userchoice.setBorder( new CompoundBorder( outer, inner ) );
		computerchoice=new JLabel(empty);
		computerchoice.setBorder( new CompoundBorder( outer, inner ) );
		inner = BorderFactory.createLineBorder( Color.blue, 3 );
		choice.add(Box.createHorizontalStrut(62));
		choice.add(userchoice);
		choice.add(Box.createHorizontalGlue());
		choice.add(computerchoice);
		choice.add(Box.createHorizontalStrut(62));
		panel1.add(players);
		panel1.add(Box.createVerticalGlue());
		panel1.add(choice);
		panel1.add(Box.createVerticalStrut(15));
		frame.add(panel1);
		frame.add(Box.createVerticalGlue());
		JPanel panel2=new JPanel();
		panel2.setBorder( new CompoundBorder( outer, inner ) );
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.setPreferredSize( new Dimension( 400, 600 ) );
		panel2.add(Box.createVerticalStrut(10));
		JPanel resultspanel=new JPanel();
		resultspanel.setLayout(new BoxLayout(resultspanel, BoxLayout.X_AXIS));
		resultspanel.setPreferredSize( new Dimension( 80, 50 ) );
		resultspanel.add(Box.createHorizontalStrut(40));
		JPanel userR=new JPanel();
		userR.setLayout(new BoxLayout(userR, BoxLayout.X_AXIS));
		userR.add(new JLabel("Human:"));
		userresult=new JLabel("0");
		userR.add(userresult);
		resultspanel.add(userR);
		resultspanel.add(Box.createHorizontalGlue());
		JPanel draws=new JPanel();
		draws.setLayout(new BoxLayout(draws, BoxLayout.X_AXIS));
		draws.add(new JLabel("Draws:"));
		this.draws=new JLabel("0");
		draws.add(this.draws);
		resultspanel.add(draws);
		resultspanel.add(Box.createHorizontalGlue());
		JPanel pcR=new JPanel();
		pcR.setLayout(new BoxLayout(pcR, BoxLayout.X_AXIS));
		pcR.add(new JLabel("Computer:"));
		pcresults=new JLabel("0");
		pcR.add(pcresults);
		resultspanel.add(pcR);
		resultspanel.add(Box.createHorizontalStrut(40));
		panel2.add(resultspanel);
		panel2.add(Box.createVerticalGlue());
		JPanel GameOtext=new JPanel();
		GameOtext.setLayout(new BoxLayout(GameOtext, BoxLayout.X_AXIS));
		GameOtext.add(Box.createHorizontalStrut(160));
		gameovertext=new JLabel("");
		gameovertext.setFont(font);
		GameOtext.add(gameovertext);
		GameOtext.add(Box.createHorizontalStrut(160));
		panel2.add(GameOtext);
		panel2.add(Box.createVerticalStrut(10));
		frame.add(panel2);
		frame.add(Box.createVerticalGlue());
		JPanel buttons=new JPanel();
		buttons.setBorder( new CompoundBorder( outer, inner ) );
		ImageIcon rockicon = new ImageIcon("rock.jpg");
		Image rockimg = rockicon.getImage();
		Image newrockimg = rockimg.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); 
		rockicon = new ImageIcon(newrockimg);
		rock=new JButton(rockicon);
		ImageIcon papericon = new ImageIcon("paper.jpg");
		Image paperimg = papericon.getImage();
		Image newpaperimg = paperimg.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); 
		papericon = new ImageIcon(newpaperimg);
		paper=new JButton(papericon);
		ImageIcon scissorsicon = new ImageIcon("scissors.jpg");
		Image scissorsimg = scissorsicon.getImage();
		Image newscissorsimg = scissorsimg.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); 
		scissorsicon = new ImageIcon(newscissorsimg);
		scissors=new JButton(scissorsicon);
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		buttons.add(rock);
		buttons.add(paper);
		buttons.add(scissors);
		frame.add(buttons);
		frame.add(Box.createVerticalStrut(50));
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed( ActionEvent ae ) {
		Random rand=new Random();
		int random=rand.nextInt(2)+1;
		if(ae.getSource()== rock) {
			userchoice.setIcon(rock.getIcon());
			if(random==1) {
				computerchoice.setIcon(rock.getIcon());
				draws.setText(String.valueOf(Integer.parseInt(draws.getText())+1));
				gameovertext.setText("Draw!");
			}
			if(random==2) {
				computerchoice.setIcon(paper.getIcon());
				pcresults.setText(String.valueOf(Integer.parseInt(pcresults.getText())+1));
				gameovertext.setText("You Lose!");
			}
			if(random==3) {
				computerchoice.setIcon(scissors.getIcon());
				userresult.setText(String.valueOf(Integer.parseInt(userresult.getText())+1));
				gameovertext.setText("You Win!");
			}
		}
		if(ae.getSource()== paper) {
			userchoice.setIcon(paper.getIcon());
			if(random==1) {
				computerchoice.setIcon(rock.getIcon());
				userresult.setText(String.valueOf(Integer.parseInt(userresult.getText())+1));
				gameovertext.setText("You Win!");
			}
			if(random==2) {
				computerchoice.setIcon(paper.getIcon());
				draws.setText(String.valueOf(Integer.parseInt(draws.getText())+1));
				gameovertext.setText("Draw!");
			}
			if(random==3) {
				computerchoice.setIcon(scissors.getIcon());
				pcresults.setText(String.valueOf(Integer.parseInt(pcresults.getText())+1));
				gameovertext.setText("You Lose!");
			}
				
		}
		if(ae.getSource()== scissors) {
			userchoice.setIcon(scissors.getIcon());
			if(random==1) {
				computerchoice.setIcon(rock.getIcon());
				pcresults.setText(String.valueOf(Integer.parseInt(pcresults.getText())+1));
				gameovertext.setText("You Lose!");
			}
			if(random==2) {
				computerchoice.setIcon(paper.getIcon());
				userresult.setText(String.valueOf(Integer.parseInt(userresult.getText())+1));
				gameovertext.setText("You Win!");
			}
			if(random==3) {
				computerchoice.setIcon(scissors.getIcon());
				draws.setText(String.valueOf(Integer.parseInt(draws.getText())+1));
				gameovertext.setText("Draw!");
			}
				
		}
	}
	
	
	
}
