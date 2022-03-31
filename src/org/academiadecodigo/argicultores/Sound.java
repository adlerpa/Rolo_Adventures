package org.academiadecodigo.argicultores;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class Sound {

    URL wavFile;
    Clip clip;
    public Sound(String filePath){
        this.wavFile = getClass().getClassLoader().getResource(filePath);
        Clip clip = null;
        {
            try {
                clip = AudioSystem.getClip();
                this.clip = clip;
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            try {
                clip.open(AudioSystem.getAudioInputStream(wavFile));
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            clip.start();
        }
    }

    public void stop(){
        clip.stop();
    }
}