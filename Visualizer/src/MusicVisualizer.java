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

        au = m.loadFile("03 Key.mp3", 4096);

        au.loop();

        fft = new FFT(au.bufferSize(), au.sampleRate());
    }

    public void draw() {
    	frameRate(120);
        background(0);
        stroke(255);
        strokeWeight(6);
        fft.forward(au.mix);
        for(int i = 30; i < fft.specSize()+50; i+=15) {
        	//rectMode(CENTER);
          ellipse((float)i, (float)(height-250), (float)5, (float)(height - fft.getBand(i)*10*Math.log(i*100000)));
        }
       
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
