package snakeAlpha;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel extends JFrame {

	
	ChangePanel()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);  // Rozmiar okna
        this.setLocationRelativeTo(null);  // Wycentrowanie okna na ekranie

        // Dodanie prostego panelu do okna instrukcji
        JPanel levelPanel = new JPanel();
        levelPanel.add(new JButton("Tu będzie wybór węża"));

        this.add(levelPanel);
        this.setVisible(true);  // Pokazanie okna
		
	}
	
}