package snakeAlpha;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel {
	JPanel BotPanel;
	InstructionPanel()
	{
		this.setSize(1165,835);
		BotPanel = new ImagePanel("/instr.png");
		BotPanel.setPreferredSize(new Dimension(1165,835));
        this.add(BotPanel);        
	}
	public JPanel GetInstructionPanel() {
		return BotPanel;
	}
	
}
