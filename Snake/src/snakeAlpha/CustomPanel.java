package snakeAlpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	JPanel topPanel;
	CustomPanel(SnakeParameters par)
	{
	this.setLayout(new FlowLayout());
	
	topPanel = new JPanel();
	this.add(topPanel,BorderLayout.NORTH);
	
	   // Tworzenie przycisków
       JButton ZielButton = new JButton("Zielony");
       JButton CzerwButton = new JButton("Czerwony");
       JButton NiebButton = new JButton("Niebieski");

       ZielButton.addActionListener(e->{
    	   par.SetSnakeColor("Zielony");
    	   
    	   ZielButton.setBackground(Color.GREEN);
    	   CzerwButton.setBackground(null);
    	   NiebButton.setBackground(null);
       });
       CzerwButton.addActionListener(e->{
    	  par.SetSnakeColor("Czerwony");
    	   
    	   ZielButton.setBackground(null);
    	   CzerwButton.setBackground(Color.RED);
    	   NiebButton.setBackground(null);
       });
       NiebButton.addActionListener(e->{
    	   par.SetSnakeColor("Niebieski");
    	   
    	   ZielButton.setBackground(null);
    	   CzerwButton.setBackground(null);
    	   NiebButton.setBackground(Color.BLUE);
       });

        Dimension buttonSize = new Dimension(250, 50);
        JButton[] buttons = {ZielButton, CzerwButton, NiebButton};
        for (JButton button : buttons) {
            button.setPreferredSize(buttonSize);
            button.setMaximumSize(buttonSize);
            button.setFont(new Font("Arial", Font.BOLD, 18));
           // button.addActionListener(this);
            topPanel.add(button);
        }
        
    JPanel bottomPanel = new ImagePanel("/SnakeColors.png");
    bottomPanel.setPreferredSize(new Dimension(1000,700));
    this.add(bottomPanel,BorderLayout.SOUTH);
    
		
	}
	public JPanel GetCustomSnakePanel() {
		return topPanel;
	}
	
}