package com.example.scott.jumpandrun;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Scott on 3/22/2017.
 */

public class Background extends View {

    private int x;
    private int xVelocity;

    public Background(Context context) {
        super(context);
        initializeView();
    }

    public Background(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public Background(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public void initializeView() {
        x = 0;
        setX(x);
        xVelocity = -2;
    }

    public void move() {
        if (!(x + xVelocity < -776)) {
            x = x + xVelocity;
            setX(x);
        }
        else {
            x = 0;
            setX(x);
        }
    }
}
