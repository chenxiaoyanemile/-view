package com.example.sweetgirl.customizeview;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetgirl.customizeview.ball.BounceBallView;

/**
 * Created by sweetgirl on 2017/9/17
 */

public class BallDialog extends DialogFragment{

    BounceBallView bounceBallView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,R.style.custom_dialog);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bounce_ball_view,container);
        bounceBallView = (BounceBallView) v.findViewById(R.id.ball);
        bounceBallView.start();
        return v;
    }

    public BounceBallView getBBV(){
        return bounceBallView;
    }


    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }


}
