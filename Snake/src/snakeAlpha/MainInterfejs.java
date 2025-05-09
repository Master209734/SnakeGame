package snakeAlpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainInterfejs extends JFrame implements ActionListener {
	JPanel bgPanel,instruction, buttonPanel;
	private JButton startButton, changeButton, levelButton, manButton;
	private JPanel top,bottom;
	
	MainInterfejs()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(1165, 835);
	    setTitle("Snake Game Menu");
	    
	    bgPanel = new ImagePanel("/IMG_0602.JPG");	
	    bgPanel.setPreferredSize(new Dimension(1165, 300));
	    this.add(bgPanel);
	    
	    
	    buttonPanel = new JPanel();	    
	  //this.setLayout(new BorderLayout());
  		buttonPanel.setOpaque(false);
  		buttonPanel.setPreferredSize(new Dimension(1165, 835));
  		// Top Panel
  		top = new JPanel();
  		top.setOpaque(false);
  		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
  		top.setAlignmentX(CENTER_ALIGNMENT);
  		top.setPreferredSize(new Dimension(1165, 235));
  		
  		 startButton = new JButton("Rozpocznij Rozgrywkę");
           Dimension startButtonSize = new Dimension(400, 100); // Zmieniono na realny rozmiar
           startButton.setPreferredSize(startButtonSize);
           startButton.setMaximumSize(startButtonSize); // Wymuszenie maksymalnego rozmiaru
           startButton.setAlignmentX(CENTER_ALIGNMENT); // Wycentrowanie w osi X
           startButton.setFont(new Font("Arial", Font.BOLD, 25));
  		
  		top.add(startButton);
  		buttonPanel.add(top,BorderLayout.NORTH);
  		
  		// BottomPanel
  		 bottom = new JPanel();
  	        bottom.setOpaque(false);
  	        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
  	        bottom.setAlignmentX(CENTER_ALIGNMENT);

  	        // Tworzenie przycisków
  	        changeButton = new JButton("Zmień Ustawienia");
  	        levelButton = new JButton("Poziom Gry");
  	        manButton = new JButton("Instrukcja");

  	        Dimension buttonSize = new Dimension(250, 50);
  	        JButton[] buttons = {changeButton, levelButton, manButton};
  	        for (JButton button : buttons) {
  	            button.setPreferredSize(buttonSize);
  	            button.setMaximumSize(buttonSize);
  	            button.setFont(new Font("Arial", Font.BOLD, 18));
  	            button.addActionListener(this);
  	            bottom.add(Box.createHorizontalStrut(15));
  	            bottom.add(button);
  	        }
  	        bottom.add(Box.createVerticalStrut(975));
  	        buttonPanel.add(bottom,BorderLayout.SOUTH);
  	        
  	        JButton music = new MusicButton("Music");
  	        bottom.add(Box.createHorizontalStrut(15));
  	        bottom.add(music);
  		// Instruction Listener
	    
	    
	    bgPanel.add(buttonPanel);
	    
	    
	    
	    
	    setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton sourceButton = (JButton) e.getSource();
        
        if (sourceButton == manButton) {
          //  instructionPanel = new InstructionPanel();
           // ChangePanel(instructionPanel);
            
        } else if (sourceButton == changeButton) {
        //	changeFrame = new ChangePanel();
        	
        } else if (sourceButton == levelButton) {
        //    levelFrame = new LevelPanel();
        }
		
	}
	public static void main(String[] args) {

		new MainInterfejs();
	}

	
	
}
