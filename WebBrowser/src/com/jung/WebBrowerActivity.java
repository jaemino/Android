package com.jung;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class WebBrowerActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

	EditText url;
	RadioGroup command1;
	Button load;
	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		url = (EditText)findViewById(R.id.url);
		command1 = (RadioGroup)findViewById(R.id.command1);
		load = (Button)findViewById(R.id.load);
		webView = (WebView)findViewById(R.id.webView);
		
		WebSettings webSettings = webView.getSettings();      // WebView를 셋팅 할 수 있는 객체를 WebView에서 추출
	    webSettings.setJavaScriptEnabled(true);               // 자바 스크립트 가능하도록 설정
	 
	    webView.setWebViewClient(new CustomWebClient());      // WebView 위젯으로 들어가는 요청이 안드로이드 내장 브러우저로 가지 않도록 합니다.
	    
	    command1.setOnCheckedChangeListener(this);
	    load.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String address = url.getText().toString();
				if(address.toLowerCase().startsWith("http://")){
					webView.loadUrl(address);
				} else{
					webView.loadUrl("http://" + address);
				}
			}
		});

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_brower, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId){
		case R.id.back2:
			if(webView.canGoBackOrForward(-2)){
				webView.goBackOrForward(-2);
			}
			break;
		case R.id.back:
			if(webView.canGoBack()){
				webView.goBack();
			}
			break;
		case R.id.forward:
			if(webView.canGoForward()){
				webView.goForward();
			}
			break;
		case R.id.forward2:
			if(webView.canGoBackOrForward(2)){
				webView.goBackOrForward(2);
			}
			break;
		}
	}
	class CustomWebClient extends WebViewClient {
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	      view.loadUrl(url);
	      return true;
	    }
	 
	    @Override
	    public void onPageFinished(WebView view, String address) {
	      url.setText(address);
	    }
	  }
}
