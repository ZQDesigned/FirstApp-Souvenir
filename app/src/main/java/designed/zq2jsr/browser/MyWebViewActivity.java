package designed.zq2jsr.browser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MyWebViewActivity extends AppCompatActivity {


    private WebView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //初始化浏览器
        initWebView();

        //获取url，这个参数从MainActivity传过来
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        //访问url
        LoadUrl(url);
    }

    //初始化浏览器
    @SuppressWarnings("deprecation")
    @SuppressLint("ClickableViewAccessibility")
    private void initWebView() {
        webView = findViewById(R.id.mywebview);
        WebSettings webSettings = webView.getSettings();

        webView.setVerticalScrollBarEnabled(true);
        //设置缓存
        webSettings.setSaveFormData(true);
        webSettings.setSavePassword(true);
        //设置支持缩放变焦
        webSettings.setBuiltInZoomControls(false);
        //设置是否支持缩放
        webSettings.setSupportZoom(false);
        //设置是否允许JS打开新窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 修复一些机型webview无法点击
        webView.requestFocus(View.FOCUS_DOWN);

        webView.setOnTouchListener((v, event) -> {
            // TODO Auto-generated method stub
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_UP:
                    if (!v.hasFocus()) {
                        v.requestFocus();
                    }
                    break;
            }
            return false;
        });

        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:") ) {
                    view.loadUrl(url);
                    return false;
                }else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            }
        });
    }

    //访问url
    private void LoadUrl(String url)
    {
        webView.loadUrl(url);
    }
}
