package com.example.paulliu.guesturetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GestureLockViewGroup mGestureLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureLockView = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGroup);
        mGestureLockView.setAnswer(new int[]{1, 2, 3, 4, 5});
        mGestureLockView
                .setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener() {

                    @Override
                    public void onUnmatchedExceedBoundary() {
                        Toast.makeText(MainActivity.this, "錯誤5次..",
                                Toast.LENGTH_LONG).show();
                        mGestureLockView.setUnMatchExceedBoundary(5);
                    }

                    @Override
                    public void onGestureEvent(boolean matched) {
                        Toast.makeText(MainActivity.this, matched + "",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBlockSelected(int cId) {
                    }
                });
    }
}
