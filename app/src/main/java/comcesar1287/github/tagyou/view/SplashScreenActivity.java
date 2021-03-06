package comcesar1287.github.tagyou.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import comcesar1287.github.tagyou.R;

public class SplashScreenActivity extends AppCompatActivity {

    LinearLayout logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null) {
            actionBar.hide();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.logo_move);

        logo = (LinearLayout) findViewById(R.id.logo);
        logo.startAnimation(animation);

    }

}
