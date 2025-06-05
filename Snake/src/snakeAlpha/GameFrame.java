package snakeAlpha;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GameFrame(MainInterfejs mainInter,SnakeParameters snakeParameters){
		GamePanel gPanel = new GamePanel(mainInter,snakeParameters);
		this.add(gPanel);
		
		this.setTitle("SNAKE");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent e) {
				mainInter.setVisible(true);
			}
		});
	}
}
