package snakeAlpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelPanel extends JPanel{

	JPanel topPanel;
	LevelPanel(SnakeParameters par)
	{
		//this.setBackground(Color.blue);
		this.setLayout(new FlowLayout());
		
		topPanel = new JPanel();
		this.add(topPanel,BorderLayout.NORTH);
		
		   // Tworzenie przycisków
	       JButton ClassicButton = new JButton("Classic");
	       JButton FancyButton = new JButton("Fancy");
	       JButton ExtremeButton = new JButton("Extreme");

	       ClassicButton.addActionListener(e->{
	    	   par.SetLevel("Classic");
	    	   par.SetWidth(600);
	    	   par.SetHeight(600);
	    	   par.SetDelay(75);
	    	   
	    	   ClassicButton.setBackground(Color.GREEN);
	    	   FancyButton.setBackground(null);
	    	   ExtremeButton.setBackground(null);
	       });
	       FancyButton.addActionListener(e->{
	    	   par.SetLevel("Fancy");
	    	   par.SetWidth(800);
	    	   par.SetHeight(800);
	    	   par.SetDelay(65);
	    	   
	    	   ClassicButton.setBackground(null);
	    	   FancyButton.setBackground(Color.YELLOW);
	    	   ExtremeButton.setBackground(null);
	       });
	       ExtremeButton.addActionListener(e->{
	    	   par.SetLevel("Extreme");
	    	   par.SetWidth(700);
	    	   par.SetHeight(700);
	    	   par.SetDelay(50);
	    	   
	    	   ClassicButton.setBackground(null);
	    	   FancyButton.setBackground(null);
	    	   ExtremeButton.setBackground(Color.RED);
	       });

	        Dimension buttonSize = new Dimension(250, 50);
	        JButton[] buttons = {ClassicButton, FancyButton, ExtremeButton};
	        for (JButton button : buttons) {
	            button.setPreferredSize(buttonSize);
	            button.setMaximumSize(buttonSize);
	            button.setFont(new Font("Arial", Font.BOLD, 18));
	           // button.addActionListener(this);
	            topPanel.add(button);
	        }
	        
	        JPanel bottomPanel = new ImagePanel("/Levels.png");
	        bottomPanel.setPreferredSize(new Dimension(1000,700));
	        this.add(bottomPanel,BorderLayout.SOUTH);
	        
	}
	JPanel GetTopPanel() {
		return topPanel;
	}
	
	
}