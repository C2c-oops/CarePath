package com.example.carepath.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class HoverButton extends AppCompatButton {
    public HoverButton(Context context) {
        super(context);
        init();
    }

    public HoverButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HoverButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    float x = (float) 1.5;
                    float y = (float) 1.5;

                    view.setScaleX(x);
                    view.setScaleY(y);
                }

                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    float x = 1;
                    float y = 1;

                    view.setScaleX(x);
                    view.setScaleY(y);

                }
                return false;
            }
        });
    }
}
