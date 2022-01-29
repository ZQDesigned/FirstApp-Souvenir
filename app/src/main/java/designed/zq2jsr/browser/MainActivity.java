package designed.zq2jsr.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button1);
        btn.setOnClickListener(v -> {
            //url参数通过Intent 传递过去
            String url = "http://www.baidu.com";
            Intent intent=new Intent(MainActivity.this,MyWebViewActivity.class);
            intent.putExtra("url", url);
            //启动MyWebViewActivity
            startActivity(intent);
        });

        btn = findViewById(R.id.button2);
        btn.setOnClickListener(v -> {
            //url参数通过Intent 传递过去
            String url = "http://ot.wap.sogou.com";
            Intent intent=new Intent(MainActivity.this,MyWebViewActivity.class);
            intent.putExtra("url", url);
            //启动MyWebViewActivity
            startActivity(intent);
        });

        btn = findViewById(R.id.button3);
        btn.setOnClickListener(v -> {
            //url参数通过Intent 传递过去
            String url = "https://www.google.com";
            Intent intent=new Intent(MainActivity.this,MyWebViewActivity.class);
            intent.putExtra("url", url);
            //启动MyWebViewActivity
            startActivity(intent);
        });
    }
}
