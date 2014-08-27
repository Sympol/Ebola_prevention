package com.symdev.healdthdocv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class AboutActivity extends Activity  {
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_activity);
		
		 WebView webView = (WebView) findViewById(R.id.webView1);		 
		 webView.loadDataWithBaseURL(null, getString(R.string.html_content), "text/html", "utf-8", null);

			/*final Activity activity = this;
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
			 
			 String pageBody = "<html><head><meta http-equiv='Content-Type' content='text/html' charset='iso-8859-1' /></head><body>" +
			 						"<h2>A propos</h2>" +		 						
			 						"<p>Ebola prevention (EP) est une application de sensibilisation sur La fièvre Ebola qui sevit actuellement en Afrique.</p>" +
			 						"<p>EP a été developée au cours d'une session de code \"Code Party\" dirigée par <a href=\"http:\\www.sympliceboni.com>Symplice BONI</a>\n La carte interactive et l'image du splach screen sont la proprieté de monsieur YOUZAN Florent</p>"+
			 						"<ul><li>Le code source de cette application sera disponible sur github.</li>"+
			 						"<li>Elle est entierement gratuite et totalement libre. Vous pouvez la recuperez, modifiez...</li></ul>"+	
			 						"<p>Merci à tous ceux qui était présent et aussi à ceux qui n'ont pas pu venu.</p>"+
			 				   "</body></html>";
			 webview.loadData(pageBody, "text/html", null);*/
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
	    	Toast.makeText(getApplicationContext(), "Vous êtes deja sur la page à propos",
	    	Toast.LENGTH_LONG).show();
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
}
