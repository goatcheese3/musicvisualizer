import processing.core.PApplet;

import ddf.minim.*;
import ddf.minim.analysis.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicVisualizer extends PApplet{

    private Minim m;
    private FFT fft;
    private AudioPlayer au;

    public static void main(String[] args){
        PApplet.main("MusicVisualizer");
    }

    public void settings() {
        fullScreen();
    }

    public void setup() {

        m = new Minim(this);

        au = m.loadFile("khalid.mp3", 1024);

        au.loop();

        fft = new FFT(au.bufferSize(), au.sampleRate());
    }

    public void draw() {
        background(0);
        stroke(255);

        fft.forward(au.mix);
        for(int i = 0; i < fft.specSize(); i++) {
            line(i, height, i, height - fft.getBand(i)*8);
        }
        clear();
    }

//    public static void main(String[] args) {
//        MusicVisualizer mv = new MusicVisualizer();
//        File f = new File("khalid.mp3");
//        byte[] b = mv.convertByteArray(f);
//        System.out.println(b);
//    }
//
//    public byte[] convertByteArray(File file) {
//        byte[] b_array = new byte[(int) file.length()];
//        try {
//            FileInputStream f = new FileInputStream(file);
//            f.read(b_array);
//            f.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return b_array;
//    }


}
