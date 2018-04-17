package com.riley.testapp.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.riley.testapp.customview.activitys.PaintActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.main_button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button:
                Intent intent = new Intent(MainActivity.this, PaintActivity.class);
                startActivity(intent);
        }
    }
}
