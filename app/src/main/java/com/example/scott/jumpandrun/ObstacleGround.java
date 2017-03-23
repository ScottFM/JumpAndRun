package com.example.scott.jumpandrun;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Scott on 3/21/2017.
 */

public class ObstacleGround extends View {

    private int x;
    private int y;
    private int xVelocity;
    private Handler refreshHandler = new Handler();
    private long delay = 10;

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

        x = 2000;
        y = 1700;
        this.xVelocity = -10;

        setBackgroundResource(R.drawable.greenrectangle);
        //refreshHandler.post(update);
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
        return (this.getX() + 250);
    }

    public float getCornerY() {
        return (this.getY() + 200);
    }

    public int changeWidth() {
        Random rand = new Random();
        int x = rand.nextInt(100);

        return x+200;
    }

    public int changeHeight() {
        Random rand = new Random();
        int x = rand.nextInt(100);

        return x+150;
    }

    public int changeVelocity() {
        Random rand = new Random();
        int x = rand.nextInt(10);

        return -x-10;
    }
}
