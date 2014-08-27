package com.symdev.healdthdocv1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CentreUrgence extends Activity implements View.OnClickListener,DialogInterface.OnClickListener{

	private Button b;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cu);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		AlertDialog ad = new AlertDialog.Builder(this)
		.setMessage("Vous êtes sur le point d'appeler le numero d'urgence mise place pour la prevention de cas de la fièvre Ebola. \nEtes vous sur de votre geste? \nSvp n'abusez pas!")
		.setIcon(R.drawable.ic_launcher)
		.setTitle("Numero d'urgence")
		.setPositiveButton("Oui", this)
		.setNegativeButton("Annuler", this)
		.setCancelable(false)
		.create();
		ad.show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch(which){
		case DialogInterface.BUTTON_POSITIVE: // yes
			Intent call = new Intent(Intent.ACTION_DIAL);
			call.setData(Uri.parse("tel:" + b.getText().toString()));
			startActivity(call);
			break;
		case DialogInterface.BUTTON_NEGATIVE: // no
			//nothing
			break;
		default:
			// nothing
			break;
		}
		
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