package snakeAlpha;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	  private Image backgroundImage;

      public ImagePanel(String filePath) {
          try {
          	backgroundImage = new ImageIcon(getClass().getResource(filePath)).getImage();
          } catch (Exception e) {
              System.out.println("Błąd ładowania obrazu: " + e.getMessage());
          }
      }

      @Override
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
          if (backgroundImage != null) {
              g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
          }
      }
  }