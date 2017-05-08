package com.dudwo.gyrocounter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class CountRunActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_run);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CountRunActivity.this,WhileRunActivity.class);
                startActivity(intent);

                finish();
            }
        }, 2950);

        viewFlipper = (ViewFlipper) this.findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(this);
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(1000);
    }

    @Override
    public void onClick(View v) {
    }
}
