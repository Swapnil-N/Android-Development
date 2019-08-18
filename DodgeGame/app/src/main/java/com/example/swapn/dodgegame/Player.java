package com.example.swapn.dodgegame;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by swapn on 4/12/2018.
 */

public class Player {
    private int x;
    private int y;
    private Bitmap img;

    public Player(Bitmap img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
    public Rect getRect(){
        return new Rect(x, y, x+img.getWidth()-10, y+img.getHeight()-10);
    }

    public void incrementX(int num){
        x+=num;
    }
}
