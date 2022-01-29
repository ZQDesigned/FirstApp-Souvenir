package designed.zq2jsr.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

public class LaunchActivity extends Activity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载启动图片
        setContentView(R.layout.activity_launch);
        animationLaunch();
    }
    private void animationLaunch() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(2000);
        linearLayout = findViewById(R.id.launchImg);
        linearLayout.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                linearLayout.setVisibility(View.GONE);
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                //结束当前的 Activity
                LaunchActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        }
        );
    }
}
