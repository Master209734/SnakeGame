package snakeAlpha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainInterfejs extends JFrame {
	JPanel bgPanel,instruction, buttonPanel;
	
	
	MainInterfejs()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(1165, 835);
	    setTitle("Snake Game Menu");
	    
	    bgPanel = new ImagePanel("/IMG_0602.JPG");	
	    bgPanel.setPreferredSize(new Dimension(1165, 300));
	    this.add(bgPanel);
	    
	    buttonPanel = new buttonPanel();
	    bgPanel.add(buttonPanel);
	    
	    
	    
		
	}
	
	public static void main(String[] args) {

		new MainInterfejs();
	}
	
	
}
