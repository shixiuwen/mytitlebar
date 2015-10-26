package com.example.shixiuwen.mytitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shixiuwen on 15-10-26.
 */
public class MyTitleBar extends RelativeLayout {

    private String leftText;
    private Drawable leftColor;
    private float leftTextSize;

    private String rightText;
    private Drawable rightColor;
    private float rightTextSize;

    private String titleText;
    private Drawable titleColor;
    private float titleTextSize;

    private Button btnLeft, btnRight;

    private LayoutParams leftParams, rightParams, titleParams;

    private Mylistener listener;

    public interface Mylistener {
        public void leftClick();

        public void rightClick();
    }

    public void mylistenerImpl(Mylistener listener) {
        this.listener = listener;
    }

    public MyTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTitleBar);

        leftText = typedArray.getString(R.styleable.MyTitleBar_leftButtonText);
        leftTextSize = typedArray.getDimension(R.styleable.MyTitleBar_leftButtonTextSize, 0);
        leftColor = typedArray.getDrawable(R.styleable.MyTitleBar_leftButtonBackground);

        rightText = typedArray.getString(R.styleable.MyTitleBar_rightButtonText);
        rightTextSize = typedArray.getDimension(R.styleable.MyTitleBar_rightButtonTextSize, 0);
        rightColor = typedArray.getDrawable(R.styleable.MyTitleBar_rightButtonBackground);

        titleText = typedArray.getString(R.styleable.MyTitleBar_titleText);
        titleTextSize = typedArray.getDimension(R.styleable.MyTitleBar_titleTextSize, 0);
        titleColor = typedArray.getDrawable(R.styleable.MyTitleBar_titleBackground);

        typedArray.recycle();

        btnLeft = new Button(context);
        btnLeft.setText(leftText);
        btnLeft.setTextSize(leftTextSize);
        btnLeft.setBackgroundDrawable(leftColor);

        btnRight = new Button(context);
        btnRight.setText(rightText);
        btnRight.setTextSize(rightTextSize);
        btnRight.setBackgroundDrawable(rightColor);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(btnLeft, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(btnRight, rightParams);

        TextView tvTitle = new TextView(context);
        tvTitle.setText(titleText);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setBackgroundDrawable(titleColor);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(CENTER_IN_PARENT);
        addView(tvTitle, titleParams);

        //为两个按钮设置监听事件
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });

    }
}
