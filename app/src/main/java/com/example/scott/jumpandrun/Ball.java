package com.example.scott.jumpandrun;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Scott on 3/14/2017.
 */

public class Ball extends View{

    private float y;
    private float x;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    private boolean up = false;
    private boolean down = false;

    private float yVelocity;
    private Handler refreshHandler = new Handler();
    private long delay = 10;

    private float direction;
    private double dirRad;

    public Ball(Context context) {
        super(context);
        initializeBall();
    }

    public Ball(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeBall();
    }

    public Ball(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeBall();
    }

    public void initializeBall() {
        maxX= 1000;
        maxY = 3400;
        minX = 0;
        minY= 0;
        x = 400;
        y = (maxY + minY)/2;
        this.yVelocity = 0;

        setBackgroundResource(R.drawable.ball);
    }

    public void startJump() {
        if (!down && !up) {
            yVelocity = -50;
            up = true;
        }
    }

    public void move() {
        if (up || down) {
            if (up){
                if (!(yVelocity < 0 && yVelocity >= -2)) {
                    yVelocity*=0.92;
                    this.y = y+yVelocity;
                    setY(y);
                }
                else {
                    yVelocity*=-1;
                    up = false;
                    down = true;
                }
            }

            if (down) {
                if (yVelocity < 50) {
                    if(!(y+(yVelocity*(1/.92)) > 1700)) {
                        yVelocity *= 1/.92;
                        this.y = y+yVelocity;
                        setY(y);
                    }
                     else {
                        setY(1700);
                        yVelocity = 0;
                        down = false;
                    }

                }
            }

        }
        else {
            setY(1700);
        }
    }

    public float getCornerX() {
        return (this.getX()+250);
    }
    public float getCornerY() {
        return (this.getY()+250);
    }

    public void rotate() {
        direction = (direction + 8) % 360;
        //dirRad = direction * Math.PI /180;
        setRotation(direction);
    }
}
