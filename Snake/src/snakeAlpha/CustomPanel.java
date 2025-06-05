package snakeAlpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {

	JPanel CustomSnakePanel;
	CustomPanel(SnakeParameters par)
	{
		this.setLayout(new BorderLayout());
		
		JPanel ButtonPanel = new JPanel(new GridLayout(1,3));
		JButton button1 = new JButton("Zielony");
		JButton button2 = new JButton("Czerwony");
		JButton button3 = new JButton("Kolorowy");
		
		button1.addActionListener(e->{
			par.SnakeColor = "Zielony";
		});
		button2.addActionListener(e->{
			par.SnakeColor = "Czerwony";
		});
		button3.addActionListener(e->{
			par.SnakeColor = "Kolorowy";
		});
		
		
		
		ButtonPanel.add(button1);
		ButtonPanel.add(button2);
		ButtonPanel.add(button3);
		
		CustomSnakePanel = new JPanel(new BorderLayout());
		CustomSnakePanel.setBackground(Color.RED);
		
		JPanel pa = new JPanel();
		pa.setBackground(Color.red);
		this.add(pa,BorderLayout.CENTER);
		
		this.add(ButtonPanel, BorderLayout.SOUTH);
		this.add(CustomSnakePanel, BorderLayout.NORTH);
		
	}
	public JPanel GetCustomSnakePanel() {
		return CustomSnakePanel;
	}
	
}