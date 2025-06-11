package snakeAlpha;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameFrame extends JFrame{
	
	 private int dx = 3; // ruch w poziomie
	 private int dy = 3; // ruch w pionie

	 private Timer timer;
	
	GameFrame(MainInterfejs mainInter,SnakeParameters snakeParameters){
		GamePanel gPanel = new GamePanel(mainInter,snakeParameters,this);
		this.add(gPanel);
		
		this.setTitle("SNAKE");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		if (gPanel.LevelType == "Extreme")
		{
		timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveWindow();
            }
        });
		timer.start();
		}
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent e) {
				mainInter.setVisible(true);
				if (gPanel.LevelType == "Extreme") {
				timer.stop();}
			}
		});
	}
	private void moveWindow() {
	    Point p = getLocation();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	    int nextX = p.x + dx;
	    int nextY = p.y + dy;

	    // Sprawdź poziomą krawędź
	    if (nextX <= 75) {
	        nextX = 76;        // ustaw na lewą krawędź
	        dx = -dx;         // odbij w prawo
	    } else if (nextX + getWidth() > screenSize.width) {
	        nextX = screenSize.width - getWidth();  // ustaw na prawą krawędź
	        dx = -dx;         // odbij w lewo
	    }

	    // Sprawdź pionową krawędź
	    if (nextY <= 50) {
	        nextY = 51;        // ustaw na górną krawędź
	        dy = -dy;         // odbij w dół
	    } else if (nextY + getHeight() > screenSize.height) {
	        nextY = screenSize.height - getHeight(); // ustaw na dolną krawędź
	        dy = -dy;         // odbij w górę
	    }


	    setLocation(nextX, nextY);
	}
}
