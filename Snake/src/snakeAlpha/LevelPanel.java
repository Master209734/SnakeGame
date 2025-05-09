package snakeAlpha;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelPanel extends JFrame{

	LevelPanel()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);  // Rozmiar okna
        this.setLocationRelativeTo(null);  // Wycentrowanie okna na ekranie

        // Dodanie prostego panelu do okna instrukcji
        JPanel levelPanel = new JPanel();
        levelPanel.add(new JButton("Tu będzie wybór levla"));

        this.add(levelPanel);
        this.setVisible(true);  // Pokazanie okna
		
	}
}