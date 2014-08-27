package com.symdev.healdthdocv1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class CarteInteractive extends Activity {
	
	@SuppressLint("SetJavaScriptEnabled")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.int_activity);
		
		Toast.makeText(getApplicationContext(), "Chargement des informations",
		Toast.LENGTH_LONG).show();
		
		
		WebView webview = (WebView) findViewById(R.id.webView1);
		webview.setWebChromeClient(new WebChromeClient() {
		});
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setPluginsEnabled(true);
		webview.getSettings().setLoadsImagesAutomatically(true);
		webview.getSettings().setPluginsEnabled(true);

		final Activity activity = this;
		 webview.setWebChromeClient(new WebChromeClient() {
		   public void onProgressChanged(WebView view, int progress) {
		     activity.setProgress(progress * 1000);
		   }
		 });
		 webview.setWebViewClient(new WebViewClient() {
		   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		     Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
		   }
		 });
		 
		/* String pageBody = "<html><head><meta http-equiv='Content-Type' content='text/html' charset='iso-8859-1' /></head><body>" +
		 						"<h2>La fièvre Ebola</h2>" +		 						
		 						"<p>La fièvre Ebola est une maladie infectieuse aigue qui provoque des épidemies chez l'homme.</p>" +
		 						"<p>C'est une maladie très grave car elle peut entraîner la mort dans 90% des cas</p>"+
		 						"<ul><li>Aucun* vaccin, ni traitement n’est disponible.</li>"+
		 						"<li>De nombreuses personnes peuvent très vite être contaminées.</li></ul>"+	
		 						"<p><img src=\"file:///assets/campagn_ebola.jpg\" /></p>"+
		 				   "</body></html>";
		 webview.loadData(pageBody, "text/html", null);*/
		 
		 ////webview.loadUrl("http://www.sympliceboni.com/android/projet/ebolaprevention/int.html");
		 
		 webview.loadUrl("http://umap.openstreetmap.fr/fr/map/ebola-en-cote-divoire-prevention-et-tracking_14290#6/4.839/-5.823");
		 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.principal:
	        Intent i = new Intent(this, MainActivity.class);
	        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        startActivity(i);
	        return true;
	    
	    case R.id.apropos:
	        Intent a = new Intent(this, AboutActivity.class);
	        startActivity(a);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

}