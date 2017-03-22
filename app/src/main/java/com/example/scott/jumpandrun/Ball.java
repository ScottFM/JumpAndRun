package com.example.scott.jumpandrun;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static android.R.attr.delay;
import static android.R.attr.layout;
import static com.example.scott.jumpandrun.R.drawable.ball;

/**
 * Created by Scott on 3/14/2017.
 */

public class Ball extends View{

    private int y;
    private int x;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    int yVelocity;
    private Handler refreshHandler = new Handler();
    private long delay = 20;

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
        maxX= 1200;
        //maxY = 3000;
        minX = 0;
        minY= 0;
        x = (maxX+minX) /2;
        y = 1800;
        this.yVelocity = 0;

       // FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(250, 250);

        //layoutParams.gravity = Gravity.CENTER;
        //.leftMargin = getWidth()/2;
        //layoutParams.bottomMargin = getHeight()/2;
        //layoutParams.setMargins(0,layoutParams.FILL_PARENT,Gravity.CENTER | Gravity.BOTTOM));
        //layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, FrameLayout.TRUE);
        //layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, R.id.greenPlatform);
        //setLayoutParams(layoutParams);

        setBackgroundResource(R.drawable.ball);
        refreshHandler.post(update);
    }

    private Runnable update = new Runnable(){       //"listener" for an abstract function
        @Override                                   //This thread runs its own alternate execution path
        public void run(){                          //This thread moves the snake, updates the screen, and does it again every 50 ms.
            //(this is an example of multi-threading)
            move();                           //Multi-threading can be used as: one thread for user, one for computer opponent
            setY(y);
            invalidate();
            refreshHandler.postDelayed(update, delay);
        }};

    public void startJump() {
        yVelocity = -50;
    }

    public void move() {
        if (yVelocity != 0) {
            if (yVelocity < -2){
                yVelocity*=0.95;
                this.y = y+yVelocity;
                setY(y);
            }
            else if (yVelocity < 0 && yVelocity >= -2) {
                yVelocity*=-1;
                setY(y);
            }
            else if (yVelocity >= 0 && yVelocity < 50) {
                yVelocity*=1.5;
                this.y = y+yVelocity;
                setY(y);
            }
            else if (yVelocity >= 50) {
                yVelocity=0;
            }

        }
    }
}
