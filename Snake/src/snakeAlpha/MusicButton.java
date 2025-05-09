package snakeAlpha;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.sound.sampled.*;
import java.net.URL;

public class MusicButton extends JButton implements ActionListener {
    private Clip backgroundMusic;
    private boolean isMusicPlaying = false;

    public MusicButton(String text) {
        super(text);
        this.setBackground(Color.RED);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toggleMusic();
    }

    private void toggleMusic() {
        if (isMusicPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    private void playMusic() {
        try {
            if (backgroundMusic == null) {
                URL soundURL = getClass().getResource("/music.wav");
                if (soundURL == null) {
                    System.out.println("Nie znaleziono pliku muzycznego.");
                    return;
                }

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audioInputStream);
            }

            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            isMusicPlaying = true;
            this.setBackground(Color.GREEN);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Błąd odtwarzania muzyki.");
        }
    }

    private void stopMusic() {
        if (backgroundMusic != null && isMusicPlaying) {
            backgroundMusic.stop();
            isMusicPlaying = false;
            this.setBackground(Color.RED);
        }
    }
}