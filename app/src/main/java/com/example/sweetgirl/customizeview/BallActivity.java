package com.example.sweetgirl.customizeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sweetgirl.customizeview.ball.BounceBallView;

public class BallActivity extends AppCompatActivity {

    private BounceBallView bounceBallView;
    private EditText bounceCount;
    private EditText ballCount;
    private EditText ballDelay;
    private EditText duration;
    private EditText radius;
    private CheckBox physicMode;
    private CheckBox randomPath;
    private CheckBox randomColor;
    private CheckBox randomRadius;
    private Button b1;
    private Button b2;
    private BallDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        dialog = new BallDialog();

        bounceBallView = (BounceBallView) findViewById(R.id.bbv1);
        ballCount = (EditText) findViewById(R.id.ball_count);
        ballDelay = (EditText) findViewById(R.id.ball_delay);
        bounceCount = (EditText) findViewById(R.id.bounce_count);
        radius = (EditText) findViewById(R.id.radius);
        duration = (EditText) findViewById(R.id.duration);
        physicMode = (CheckBox) findViewById(R.id.physic_mode);
        randomColor = (CheckBox) findViewById(R.id.random_color);
        randomPath = (CheckBox) findViewById(R.id.random_path);
        randomRadius = (CheckBox) findViewById(R.id.random_radius);

        bounceBallView.post(new Runnable() {
            @Override
            public void run() {
                initText();
            }
        });
        bounceBallView.start();

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apply(bounceBallView);
                initText();
                bounceBallView.start();
            }
        });

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getFragmentManager(),"1");
            }
        });
    }
    private void initText(){
        ballCount.setText(bounceBallView.getBallCount()+"");
        ballDelay.setText(bounceBallView.getBallDelay()+"");
        bounceCount.setText(bounceBallView.getBounceCount()+"");
        duration.setText(bounceBallView.getDefaultDuration()+"");
        radius.setText(bounceBallView.getRadius()+"");
        physicMode.setChecked(bounceBallView.isPhysicsMode());
        randomRadius.setChecked(bounceBallView.isRandomRadius());
        randomPath.setChecked(bounceBallView.isRandomBallPath());
        randomColor.setChecked(bounceBallView.isRandomColor());
    }

    public void apply(BounceBallView bbv){
        if(bbv == null){
            Toast.makeText(this,"BounceBallView is null",Toast.LENGTH_LONG).show();
            return;
        }
        try{
            bbv.config()
                    .ballCount(Integer.parseInt(ballCount.getText().toString()))
                    .bounceCount(Integer.parseInt(bounceCount.getText().toString()))
                    .ballDelay(Integer.parseInt(ballDelay.getText().toString()))
                    .duration(Integer.parseInt(duration.getText().toString()))
                    .radius(Float.parseFloat(radius.getText().toString()))
                    .isPhysicMode(physicMode.isChecked())
                    .isRamdomPath(randomPath.isChecked())
                    .isRandomColor(randomColor.isChecked())
                    .isRandomRadius(randomRadius.isChecked())
                    .apply();
        }catch (Exception e){
            Toast.makeText(this,"错误",Toast.LENGTH_LONG).show();
        }
    }

}
