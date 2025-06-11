package snakeAlpha;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*; 
import java.util.Random; 

public class GamePanel extends JPanel implements ActionListener{
	int screen_width;
	static int screen_height;
	static int unit_size = 25; 
	static int game_units;
	static int delay;
    int x[];
	int y[];
	int bodyParts;
	int applesEaten = 0;
	int appleX;
	int appleY;
	int peachX;
	int peachY;
	int bombX;
	int bombY;
	boolean PeachExsist = false;
	boolean BombExsist = false;
	char direction = 'R';
	boolean running = false;
	String SnakeColor;
	Timer timer;
	Timer peachTimer;
	int peachTime = 2000;
	Timer bombTimer;
	int bombTime = 5000;
	Random random;
	int Score = 0;
	String LevelType;
	JButton Rbutton;
	boolean buttonAdded;
	GameFrame gf;

	
	GamePanel(MainInterfejs mainInter,SnakeParameters snakeParameters,GameFrame gf){
		
		// Ustawienie Parametrów
		this.screen_width = snakeParameters.GetWidth();
		this.screen_height = snakeParameters.GetHeight();
		this.delay = snakeParameters.GetDelay();
		this.bodyParts = snakeParameters.GetParts();
		
		this.LevelType = snakeParameters.GetLevel();
		this.SnakeColor = snakeParameters.GetSnakeColor();
		
		//LevelType = "fancy"; // classic, fancy, extreme
		
		game_units = (screen_width * screen_height) / unit_size;
		
		x = new int[game_units];
		y = new int[game_units];
		
	
		random = new Random();
		this.setPreferredSize(new Dimension(screen_width,screen_height));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();	
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.gf = gf;
	}
	public void startGame() {
		Apple();
		running = true;
		timer = new Timer(delay,this);
		timer.start();
		requestFocusInWindow();
	}
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 draw(g); 
	}
	public void draw(Graphics g) {
		if (running) {
			// Siatka
			for(int i = 0; i < screen_width/unit_size; i++) {
				g.drawLine(i*unit_size, 0, i*unit_size, screen_height);
			g.drawLine(0,i*unit_size, screen_width, i*unit_size);
			}
			//Jablka
			g.setColor(Color.RED);
			g.fillOval(appleX, appleY, unit_size, unit_size);
			// Gruszki
			if(PeachExsist) {
				g.setColor(Color.BLUE);
				g.fillOval(peachX, peachY, unit_size, unit_size);
			}
			// Bomby
			if(BombExsist) {
				g.setColor(Color.WHITE);
				g.fillOval(bombX, bombY, unit_size, unit_size);
			}
			
			//Rysowanie weza
			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					g.setColor(HeadColor(this.SnakeColor));
					g.fillRect(x[i], y[i], unit_size, unit_size);
				}
				else {
					g.setColor(BodyColor(this.SnakeColor));
					g.fillRect(x[i], y[i], unit_size, unit_size);
				}
			}
			// Przeszkody
				g.setColor(Color.WHITE);
				
				if (LevelType == "Fancy" || LevelType == "Extreme") {
				for(int i = screen_height/(2*unit_size) -4; i < screen_height/(2*unit_size) +4;i++) {
					g.fillRect(5*unit_size, i*unit_size, unit_size, unit_size);
					g.fillRect(screen_width - 6*unit_size, i*unit_size, unit_size, unit_size);
				}
				}
			
			// Wyswietlanie wyniku
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free",Font.BOLD,25));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+Score, (screen_width - metrics.stringWidth("Score: "+Score))/2,g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() {
		for(int i = bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(direction) {
		case 'U':
			y[0] = y[0] - unit_size;
			break;
		case 'D':
			y[0] = y[0] + unit_size;
			break;	
		case 'R':
			x[0] = x[0] + unit_size;
			break;
		case 'L':
			x[0] = x[0] - unit_size;
			break;
		}
	}
	public void Apple() {
	 appleX = random.nextInt((int)(screen_width/unit_size))*unit_size;
	 appleY = random.nextInt((int)(screen_height/unit_size))*unit_size;
	 if (LevelType == "Fancy" || LevelType == "Extreme") {
			// Czy nie pokrywa sie z przeszkodami
			for(int i = screen_height/(2*unit_size) -4; i < screen_height/(2*unit_size) +4;i++) {
			if(((appleX == 5*unit_size) && (appleY == i*unit_size) )
					|| ((appleX == screen_width - 6*unit_size) && (appleY == i*unit_size) )) {
					
				appleX = appleX + unit_size;
			}
			}
	 }
	 
	}
	public void Peach() {
		 peachX = random.nextInt((int)(screen_width/unit_size))*unit_size;
		 peachY = random.nextInt((int)(screen_height/unit_size))*unit_size;
	}
	public void Bomb() {
		 bombX = random.nextInt((int)(screen_width/unit_size))*unit_size;
		 bombY = random.nextInt((int)(screen_height/unit_size))*unit_size;
	}
	public void checkApple() {
		if((appleX == x[0]) && (appleY == y[0])) {
			bodyParts++;
			applesEaten++;
			Score++;
			Apple(); 
			playSound("Eat.wav");
			
			if (LevelType == "Fancy" || LevelType == "Extreme") {
			if (applesEaten % 2 == 0) {
				Peach();
				PeachExsist = true;
				
				if (peachTimer != null) {
					peachTimer.stop(); // zatrzymaj poprzedni jeśli był
				}

				// Peach istnieje tylko 2 sekundy
				peachTimer = new Timer(peachTime, new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PeachExsist = false;
						peachTimer.stop(); // zatrzymaj timer po wykonaniu
					}
				});
				peachTimer.setRepeats(false); // tylko raz
				peachTimer.start();
			}
			
			Random rand = new Random();
			if ( (rand.nextInt(10) + 1) <= 2) {
				Bomb();
				BombExsist = true;
				if (bombTimer != null) {
					bombTimer.stop(); // zatrzymaj poprzedni jeśli był
				}

				// Peach istnieje tylko 2 sekundy
				bombTimer = new Timer(bombTime, new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						BombExsist = false;
						bombTimer.stop(); // zatrzymaj timer po wykonaniu
					}
				});
				bombTimer.setRepeats(false); // tylko raz
				bombTimer.start();
			}		
			
		}}
	}
	public void checkPeach() {
		if((peachX == x[0]) && (peachY == y[0])) {
			Score +=2;
			PeachExsist = false;
			playSound("Eat.wav");
		}
	}
	public void checkBomb() {
		if((bombX == x[0]) && (bombY == y[0])) {
			Score = Score - 5;
			
			if(bodyParts%2 == 0) {
				bodyParts = bodyParts/2;
			}
			else {
				bodyParts = (int)bodyParts/2 + 1;
			}
			BombExsist = false;
			playSound("Eat.wav");
		}
	}
	public void checkCollisions() {
		// Colisions with snake itself
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		// Collisions with walls
		if (x[0] < 0) running = false;
		if (x[0] > screen_width) running = false;
		if (y[0] < 0) running = false;
		if (y[0] > screen_height-unit_size) running = false;
		
		if (LevelType == "Fancy" || LevelType == "Extreme") {
		// Collisions with przeszkody
		for(int i = screen_height/(2*unit_size) -4; i < screen_height/(2*unit_size) +4;i++) {
		if(((x[0] == 5*unit_size) && (y[0] == i*unit_size) )
				|| ((x[0] == screen_width - 6*unit_size) && (y[0] == i*unit_size) )) {
			running = false;
		}
		}
		}
	
		
		
		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,25));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+Score, (screen_width - metrics1.stringWidth("Score: "+Score))/2,g.getFont().getSize());
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (screen_width - metrics2.stringWidth("Game Over"))/2, screen_height/2);
		AddButton();
		playSound("GameDIE.wav");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move();
			
			checkCollisions(); 
			checkApple(); 
			if(PeachExsist) {
				checkPeach();
			}
			if(BombExsist) {
				checkBomb();
			}
			}
			
		repaint();
	}
	public class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (direction != 'R') {
						direction = 'L';
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (direction != 'L') {
						direction = 'R';
					}
					break; 	
				case KeyEvent.VK_UP:
					if (direction != 'D') {
						direction = 'U';
					}
					break;	
				case KeyEvent.VK_DOWN:
					if (direction != 'U') {
						direction = 'D';
					}
					break;	
			}
			 
		}
		 
	}
	public Color BodyColor(String type){
		if(this.LevelType != "Extreme") {
		if(type == "Zielony")
		{
			return Color.green;
		}
		else if(type == "Czerwony")
		{
			return Color.red;
		}
		else if(type == "Niebieski"){
			return Color.BLUE;
		}
		else {
			return Color.black;
		}
		}
		else {
			random = new Random();
			Color k = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
			return k;
		}
		
	}
	public Color HeadColor(String type){
		if(this.LevelType != "Extreme") {
		if(type == "Zielony")
		{
			Color k = new Color(5, 97, 29);
			return k;
		}
		else if(type == "Czerwony")
		{
			Color k = new Color(245, 66, 66);
			return k;
		}
		else if(type == "Niebieski"){
			Color k = new Color(34, 5, 97);
			return k;
		}
		else {
			return Color.black;
		}
		}
		else {
			random = new Random();
			Color k = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
			return k;
		}
	}
	public void AddButton() {
		Rbutton = new JButton("Menu");
        Rbutton.setBounds(screen_width/2 - 75, screen_height/2 + 50, 150, 40); // ustaw pozycję
        this.add(Rbutton);
        Rbutton.setFocusable(false);
        Rbutton.addActionListener(e->{
        	gf.dispose();
        });
	}
	public void playSound(String fileName) {
	    try {
	        // Załaduj plik dźwiękowy z zasobów
	        URL soundURL = getClass().getResource("/" + fileName);
	        if (soundURL == null) {
	            System.err.println("Nie znaleziono pliku dźwiękowego: " + fileName);
	            return;
	        }

	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioIn);
	        clip.start();
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}
	
	

	

}
