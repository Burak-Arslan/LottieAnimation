package com.example.user.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Events();
    }

    private void Events() {
        try {
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lottieAnimationView.isAnimating()) {
                        Toast.makeText(MainActivity.this, "Zaten oynatılıyor.", Toast.LENGTH_SHORT).show();
                    } else {
                        lottieAnimationView.setVisibility(View.VISIBLE);
                        lottieAnimationView.playAnimation();
                    }
                }
            });
            
            lottieAnimationView.addAnimatorUpdateListener(animation -> {

            });
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void Init() {
        try {
            lottieAnimationView = findViewById(R.id.animation_view);
            btnStart = findViewById(R.id.btnStart);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
