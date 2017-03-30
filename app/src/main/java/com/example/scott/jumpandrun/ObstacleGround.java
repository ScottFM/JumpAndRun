package com.example.scott.jumpandrun;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Scott on 3/21/2017.
 */

public class ObstacleGround extends View {

    private int x;
    private int y;
    private int width, height;
    private int xVelocity;
    private Handler refreshHandler = new Handler();
    private long delay = 10;

    FrameLayout mFrameLayout;

    public ObstacleGround(Context context) {
        super(context);
        initializeView();
    }

    public ObstacleGround(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public ObstacleGround(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public void initializeView() {

        mFrameLayout = (FrameLayout)findViewById(R.id.content);

        x = 2000;
        y = 1700;
        this.xVelocity = -10;


        Random rand = new Random();
        int x = rand.nextInt(3);

        switch(x) {
            case 0:
                setBackgroundResource(R.drawable.greenrectangle);
                break;
            case 1:
                setBackgroundResource(R.drawable.bluerectangle);
                break;
            case 2:
                setBackgroundResource(R.drawable.blackrectangle);
                break;
            /*case 3:
                setBackgroundResource(R.drawable.bluerectangle);
                break;
            case 4:
                setBackgroundResource(R.drawable.yellowrectangle);
                break;*/
        }
    }

    public void move() {
        x = x + xVelocity;
        setX(x);
    }

    public void setxVelocity(int xv) {
        this.xVelocity = xv;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public float getCornerX() {
        return (this.getX() + this.width);
    }

    public float getCornerY() {
        return (this.getY() + this.height);
    }

    public int changeWidth() {
        Random rand = new Random();
        int x = rand.nextInt(300);

        width = x+200;
        return width;
    }

    public int changeHeight() {
        Random rand = new Random();
        int x = rand.nextInt(250);

        height = x + 150;
        return height;
    }

    public int changeVelocity(int objectsCreated) {
        Random rand = new Random();
        int x = rand.nextInt(7);
        int scale = objectsCreated/3;

        return -15-x-scale;
    }


}
