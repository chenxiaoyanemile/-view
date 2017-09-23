package com.example.sweetgirl.customizeview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sweetgirl.customizeview.timeline.TimeLineMakerView;

public class MainActivity extends AppCompatActivity {

    private TimeLineMakerView timeLineMakerView1;
    private TimeLineMakerView timeLineMakerView2;
    private TimeLineMakerView timeLineMakerView3;
    private TimeLineMakerView timeLineMakerView4;
    private TimeLineMakerView timeLineMakerView5;

    private TextView tv_five;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeLineMakerView1 = (TimeLineMakerView)findViewById(R.id.time1);
        timeLineMakerView2 = (TimeLineMakerView)findViewById(R.id.time2);
        timeLineMakerView3 = (TimeLineMakerView)findViewById(R.id.time3);
        timeLineMakerView4 = (TimeLineMakerView)findViewById(R.id.time4);
        timeLineMakerView5 = (TimeLineMakerView)findViewById(R.id.time5);

        tv_five = (TextView)findViewById(R.id.tv_five);

        Resources resources =getBaseContext().getResources();
        timeLineMakerView1.setBeginLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView1.setEndLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView1.setMarkerDrawable(resources.getDrawable(R.drawable.timeline_bg_bule));

        timeLineMakerView2.setBeginLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView2.setEndLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView2.setMarkerDrawable(resources.getDrawable(R.drawable.timeline_bg_bule));

        timeLineMakerView3.setBeginLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView3.setEndLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView3.setMarkerDrawable(resources.getDrawable(R.drawable.timeline_bg_bule));

        timeLineMakerView4.setBeginLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView4.setEndLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView4.setMarkerDrawable(resources.getDrawable(R.drawable.timeline_bg_bule));

        timeLineMakerView5.setBeginLine(resources.getDrawable(R.color.blue_sky));
        timeLineMakerView5.setEndLine(resources.getDrawable(R.color.colorAccent));
        timeLineMakerView5.setMarkerDrawable(resources.getDrawable(R.drawable.timeline_bg_red));

        tv_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BallActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
