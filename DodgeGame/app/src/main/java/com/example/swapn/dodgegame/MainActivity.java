package com.example.swapn.dodgegame;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    //Code from this program has been used from "Beginning Android Games" by Mario Zechner
    //Review SurfaceView, Canvas, continue

    double accelx;
    GameSurface gameSurface;

    Player player;
    FallingThing myFallingThing;
    int scorept;

    String timeString;

    boolean finalStringbool = false;
    String finalString;

    boolean touchthing = true;

    SoundPool soundPool;
    int mysound;

    //MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.explosion);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);

        gameSurface = new GameSurface(this);
        setContentView(gameSurface);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeString = "Time remaining: " +millisUntilFinished/1000;
            }

            public void onFinish() {
                myFallingThing.stop();
                finalString = "Congrats you scored "+scorept+" points.";
                finalStringbool = true;
            }
        }.start();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelx=event.values[0];
        }
        if (accelx > 0.4 && accelx <= 3 && player.getX() > 10){
            player.incrementX(-1);
        }else if (accelx > 3 && player.getX() > 10){
            player.incrementX(-2);
        }else if (accelx < -0.4 && accelx >= -3 && player.getX() < 900){
            player.incrementX(1);
        }else if (accelx < -3 && player.getX() < 900){
            player.incrementX(2);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

    @Override
    protected void onPause(){
        super.onPause();
        gameSurface.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        gameSurface.resume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {



        return super.onTouchEvent(event);
    }

    //----------------------------GameSurface Below This Line--------------------------
    public class GameSurface extends SurfaceView implements Runnable {

        Thread gameThread;
        SurfaceHolder holder;
        volatile boolean running = false;
        Paint paintProperty;

        int screenWidth;
        int screenHeight;

        boolean randbool = true;

        public GameSurface(Context context) {
            super(context);

            holder=getHolder();

            Display screenDisplay = getWindowManager().getDefaultDisplay();
            Point sizeOfScreen = new Point();
            screenDisplay.getSize(sizeOfScreen);
            screenWidth=sizeOfScreen.x;
            screenHeight=sizeOfScreen.y;

            paintProperty= new Paint();
            paintProperty.setTextSize(80);

            myFallingThing = new FallingThing(BitmapFactory.decodeResource(getResources(),R.drawable.topcar), screenWidth/2, 200);
            player = new Player(BitmapFactory.decodeResource(getResources(),R.drawable.car), screenWidth/2, 1500);

            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
            mysound = soundPool.load(context, R.raw.explosion, 1);

        }

        @Override
        public void run() {
            while (running){

                if (!holder.getSurface().isValid())
                    continue;

                final Canvas canvas= holder.lockCanvas();
                canvas.drawRGB(0,255,0);
                canvas.drawText("Score: "+scorept,50,100,paintProperty);
                canvas.drawText(timeString,50,200,paintProperty);
                canvas.drawBitmap( player.getImg(),player.getX(),player.getY(),null);
                canvas.drawBitmap( myFallingThing.getImg(),myFallingThing.getX(),myFallingThing.getY(),null);

                if (finalStringbool){
                    canvas.drawRGB(0,255,0);
                    canvas.drawText(finalString,10,screenHeight/2-50,paintProperty);
                    myFallingThing.stop();
                    //canvas.drawRect(new Rect(0,0,screenWidth,screenHeight),paintProperty);
                }

                if (touchthing){
                    myFallingThing.setIncremun(10);
                }else if(!touchthing){
                    myFallingThing.setIncremun(20);
                }
                myFallingThing.incrementY();

                if (player.getRect().intersect(myFallingThing.getRect()) && randbool){
                    player.setImg(BitmapFactory.decodeResource(getResources(),R.drawable.fire));
                    scorept--;
                    randbool = false;
                    //mediaPlayer.start();
                    if (!finalStringbool)
                        soundPool.play(mysound, 1.0f,1.0f,0,0,1.5f);
                }

                if (myFallingThing.getY() > screenHeight){
                    myFallingThing.resetX();
                    myFallingThing.resetY();
                    if (randbool)
                        scorept++;
                    randbool = true;
                    player.setImg(BitmapFactory.decodeResource(getResources(),R.drawable.car));
                }

                gameSurface.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        touchthing = !touchthing;
                        return false;
                    }
                });

                holder.unlockCanvasAndPost(canvas);
            }
        }

        public void resume(){
            running=true;
            gameThread=new Thread(this);
            gameThread.start();
        }

        public void pause() {
            running = false;
            while (true) {
                try {
                    gameThread.join();
                } catch (InterruptedException e) {
                    Log.d("Error","Error");
                }
            }
        }


    }//GameSurface

}

