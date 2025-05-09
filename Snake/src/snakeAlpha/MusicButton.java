package snakeAlpha;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MusicButton extends JButton implements ActionListener {
    private Clip backgroundMusic;
    private boolean isMusicPlaying = false;  // Flaga kontrolująca stan muzyki

    public MusicButton(String text) {
        super(text);  // Przekazujemy tekst przycisku do konstruktora JButton
        this.addActionListener(this);  // Dodajemy nasłuchiwacza do akcji przycisku
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toggleMusic();  // Przełączanie stanu muzyki
    }

    // Metoda do odtwarzania i zatrzymywania muzyki
    private void toggleMusic() {
        if (isMusicPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    // Metoda do rozpoczęcia odtwarzania muzyki
    private void playMusic() {
        try {
            // Załaduj plik muzyczny z folderu resources
            InputStream musicStream = getClass().getResourceAsStream("/music.mp3");
            if (musicStream == null) {
                System.out.println("Nie można znaleźć pliku muzycznego");
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicStream);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);  // Odtwarzanie w pętli
            isMusicPlaying = true;
            System.out.println("Muzyka jest włączona");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Błąd podczas odtwarzania muzyki");
        }
    }

    // Metoda do zatrzymywania muzyki
    private void stopMusic() {
        if (backgroundMusic != null && isMusicPlaying) {
            backgroundMusic.stop();
            isMusicPlaying = false;
            System.out.println("Muzyka została zatrzymana");
        }
    }
}
