package com.example.shixiuwen.mytitlebar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private MyTitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titleBar = (MyTitleBar) findViewById(R.id.myTitlebar);
        titleBar.mylistenerImpl(new MyTitleBar.Mylistener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"左按键被点击了……",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"右按键被点击了……",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
