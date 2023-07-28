package com.himedia.proj46;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View {

    private Paint paint;

    public CustomView(Context context) {
        super(context);

        init(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(10, 10, 100, 100, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0F);
        paint.setColor(Color.GREEN);
        canvas.drawRect(10, 10, 100, 100, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(128, 0, 0, 255);
        canvas.drawRect(120, 10, 210, 100, paint);

        DashPathEffect dashEffect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0F);
        paint.setPathEffect(dashEffect);
        paint.setColor(Color.GREEN);
        canvas.drawRect(120, 10, 210, 100, paint);

        paint = new Paint();

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(50, 160, 40, paint);

        paint.setAntiAlias(true);
        canvas.drawCircle(160, 160, 40, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(50);
        canvas.drawText("Text (Stroke)", 20, 260, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(50);
        canvas.drawText("Text", 20, 320, paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(super.getContext(), "MotionEvent.ACTION_DOWN : " +
                    event.getX() + ", " + event.getY(), Toast.LENGTH_LONG).show();
        }

        return super.onTouchEvent(event);
    }
}
