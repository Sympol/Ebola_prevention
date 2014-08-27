package com.symdev.healdthdocv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnInt, btnSym, btnMdt, btnMdp, btnCu, btnCi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		btnInt = (Button) findViewById(R.id.btnInt);
		btnSym = (Button) findViewById(R.id.btnSym);
		btnMdt = (Button) findViewById(R.id.btnMdt);
		btnMdp = (Button) findViewById(R.id.btnMdp);
		btnCu = (Button) findViewById(R.id.btnCu);
		btnCi = (Button) findViewById(R.id.btnCi);

		/*
		 * Buttons click events
		 */

		// intro
		btnInt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, IntActivity.class);
				startActivity(i);
			}
		});

		// sym

		btnSym.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, SymActivity.class);
				startActivity(i);
			}
		});


		// mdt

		btnMdt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ModeTransmission.class);
				startActivity(i);
			}
		});

		// mdp

		btnMdp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Prevention.class);
				startActivity(i);
			}
		});



		// cu
		btnCu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, CentreUrgence.class);
				startActivity(i);
			}
		});

		// ci
		btnCi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, CarteInteractive.class);
				startActivity(i);
			}
		});
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
			Toast.makeText(getApplicationContext(), "Vous êtes deja sur la page d'accueil",
					Toast.LENGTH_LONG).show();
			return true;

		case R.id.apropos:
			Intent a = new Intent(this, AboutActivity.class);
			startActivity(a);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
