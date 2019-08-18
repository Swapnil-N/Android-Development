package com.example.swapn.dodgegame;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class FallingThing{

    private int x;
    private int y;
    private Bitmap img;
    private int incremun = 10;

    public FallingThing(Bitmap img, int x, int y){
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public Bitmap getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRect(){
        return new Rect(x, y, x+img.getWidth()-10, y+img.getHeight()-10);
    }

    public void incrementY(){
        y+=incremun;
    }

    public void stop(){
        incremun = 0;
    }

    public void resetY(){
        y = 200;
    }

    public void resetX(){
        x = (int)(Math.random()*800)+50;
    }

    public void setIncremun(int inputasdf){
        incremun = inputasdf;
    }
}
