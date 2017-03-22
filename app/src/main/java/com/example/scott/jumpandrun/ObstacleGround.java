package com.example.scott.jumpandrun;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

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
        x = 1400;
        y = 1700;
        this.xVelocity = -10;

        setBackgroundResource(R.drawable.greenrectangle);
        refreshHandler.post(update);
    }

    private Runnable update = new Runnable(){       //"listener" for an abstract function
        @Override                                   //This thread runs its own alternate execution path
        public void run(){
            move();
            invalidate();
            refreshHandler.postDelayed(update, delay);
        }};

    public void move() {

        //need to include code for upping the score when x hits certain value
        //probably need a function to get next value to account for collisions

        if (!(x + xVelocity < -300)) {
            x = x + xVelocity;
            setX(x);
        }
        else {
            //needs to delete the old ones.
        }
    }
}
