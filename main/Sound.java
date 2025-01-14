package main;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class Sound {
    // enter the game, each move, check, checkmate, stalemate
    public static void playSound(String fileName) {
        try {
            // fileName must be .wav
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();

                // analogy: give the CD to the CD player
                clip.open(audioInput);
                clip.start();

                // pauses the program for the duration of the sound
                // ensures that the sound is played completely before the program terminates
                //Thread.sleep(clip.getMicrosecondLength() / 1000);
            }
            else {
                return;
            }


        } catch (Exception e) {
            // Catch UnsupportedAudioFileException, LineUnavailableException, IOException
            System.out.println(e);
            // e.printStackTrace();
        }
    }

}
