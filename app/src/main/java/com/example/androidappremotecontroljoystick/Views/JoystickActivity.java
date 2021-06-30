package com.example.androidappremotecontroljoystick.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class JoystickActivity extends View {

    private final Paint paint;
    private float x;
    private float y;
    private final float r;
    public TouchEvent myOnChange;

    //constructor
    public JoystickActivity(Context context, AttributeSet attr) {
        super(context, attr);
        paint = new Paint();
        paint.setColor(Color.GRAY);
        x = 250;
        y = 250;
        r = 100;

    }

    // the function draw 2 circles which represents a joystick
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, r, paint);
    }


    // the function is called when there is a touch event on the joystick
    // and according to the event change the joystick
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

            case MotionEvent.ACTION_DOWN:
                //check it's in the borders
                if(event.getX()>70&&event.getX()<430){
                    this.x = event.getX();
                }
                //check it's in the borders
                if(event.getY()>70&&event.getY()<430){
                    this.y = event.getY();
                }
                break;

            case MotionEvent.ACTION_UP:
                //return back the joystick to the center
                x = 250;
                y = 250;
                break;
            default:
        }
        myOnChange.update(x,y);
        invalidate();
        return true;
    }
}

