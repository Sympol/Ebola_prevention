package com.symdev.healdthdocv1;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class IntActivity extends Activity implements OnInitListener {

	private TextToSpeech tts;
	private ImageButton btnSpeak;
	private TextView txtText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intactivity);

		TextView tv = (TextView) findViewById(R.id.textdef);
		tv.setText(Html.fromHtml(getString(R.string.my_text))); 

		//Initialize the tts object
		tts = new TextToSpeech(this, this);
		//Refer 'Speak' button
		btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
		//Refer 'Text' control
		txtText = (TextView) findViewById(R.id.textdef);
		//Handle onClick event for button 'Speak'
		btnSpeak.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				//Method yet to be defined 
				speakOut();
			}

			private void speakOut() {
				String text = txtText.getText().toString();
				if (text.length() == 0) {
					tts.speak("Lecture impossible", TextToSpeech.QUEUE_FLUSH, null);
				} else {
					tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);     }

			}

		});
	}

	//Menu /***********************************************/
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
	// Menu end //

	@Override
	public void onInit(int status) {
		//TTS is successfully initialized
		if (status == TextToSpeech.SUCCESS) {
			//Setting speech language
			int result = tts.setLanguage(Locale.FRANCE);
			//If your device doesn't support language you set above
			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				//Cook simple toast message with message
				Toast.makeText(this, "Langue non supporté", Toast.LENGTH_LONG).show();
				Log.e("TTS", "Language is not supported");
			} 
			//Enable the button - It was disabled in main.xml (Go back and Check it)
			else {
				btnSpeak.setEnabled(true);
			}
			//TTS is not initialized properly
		} else {
			Toast.makeText(this, "Echec de l'initialisation du TTS", Toast.LENGTH_LONG).show();
			Log.e("TTS", "Initilization Failed");
		}
	}

	public void onDestroy() {
		// shutdown!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

}
