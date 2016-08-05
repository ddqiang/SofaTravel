package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zly on 16/7/28.
 */
public class SelectLetterView extends View {
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private SelectCityBean bean;
    private String[] letters;
    private int choose = -1;
    private boolean showBkg = false;

    public void setBean(SelectCityBean bean) {
        this.bean = bean;
        // 初始化数组
        letters = new String[bean.getData().getSearchCity().size()];
        for (int i = 0; i < bean.getData().getSearchCity().size(); i++) {
            letters[i] = bean.getData().getSearchCity().get(i).getWord();
            Log.d("SelectLetterView", bean.getData().getSearchCity().get(i).getWord());
        }
        invalidate();
    }

    public SelectLetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectLetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (letters != null) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            int height = getHeight();
            int width = getWidth();
            int singleHeight = height / letters.length;
            for (int i = 0; i < letters.length; i++) {
                paint.setColor(Color.parseColor("#515151"));
                paint.setTextSize(40);
                paint.setTypeface(Typeface.DEFAULT_BOLD);
                paint.setAntiAlias(true);
                if (i == choose) {
                    paint.setColor(Color.parseColor("#3399ff"));
                    paint.setFakeBoldText(true);
                }
                float xPos = width / 2 - paint.measureText(letters[i]) / 2;
                float yPos = singleHeight * i + singleHeight;
                canvas.drawText(letters[i], xPos, yPos, paint);
                paint.reset();
            }
        }


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * letters.length);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBkg = true;
                if (oldChoose != c && listener != null) {
                    if (c >= 0 && c <= letters.length) {
                        listener.onTouchingLetterChanged(c);
                        choose = c;
                        invalidate();
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c >= 0 && c <= letters.length) {
                        listener.onTouchingLetterChanged(c);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                showBkg = false;
                choose = -1;
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnTouchingLetterChangedListener(
            OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener {
        public void onTouchingLetterChanged(int s);
    }
}
