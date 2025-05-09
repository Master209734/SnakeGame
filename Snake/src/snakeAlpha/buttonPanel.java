package snakeAlpha;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class buttonPanel extends JPanel implements ActionListener {
	private JButton startButton, changeButton, levelButton, manButton;
	private JPanel top,bottom;
	private JFrame instructionFrame, levelFrame, changeFrame;
	private JPanel instructionPanel;
	buttonPanel()
	{
		//this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(1165, 835));
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
		this.add(top,BorderLayout.NORTH);
		
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
	        this.add(bottom,BorderLayout.SOUTH);
	        
	        JButton music = new MusicButton("Music");
	        bottom.add(Box.createHorizontalStrut(15));
	        bottom.add(music);
		// Instruction Listener
	        
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 JButton sourceButton = (JButton) e.getSource();
	        
	        if (sourceButton == manButton) {
	            instructionPanel = new InstructionPanel();
	           // ChangePanel(instructionPanel);
	            
	        } else if (sourceButton == changeButton) {
	        	changeFrame = new ChangePanel();
	        	
	        } else if (sourceButton == levelButton) {
	            levelFrame = new LevelPanel();
	        }
		
	}
}
