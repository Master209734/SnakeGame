package snakeAlpha;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GameFrame(){
		GamePanel gPanel = new GamePanel();
		this.add(gPanel);
		
		this.setTitle("SNAKE");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
