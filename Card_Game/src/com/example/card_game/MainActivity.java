package com.example.card_game;

import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener{

    private SeekBar bar;
    private TextView textProgress;
    private TextView stat;
    private Deck a;
    private Player t;
    private int pot;
    private int potVal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ADebugTag","test" );
		a = new Deck();
		pot=0;
		potVal=0;
		Collections.shuffle(a.deck);
		
		t = new Player();
		t.hand.add(a.deck.remove());
		Log.d("Init","Player t added card "+t.hand.getLast().getSuit()+ t.hand.getLast().getSuit());
		t.hand.add(a.deck.remove());
		Log.d("Init","Player t added card "+t.hand.getLast().getSuit()+ t.hand.getLast().getSuit());
		
		bar = (SeekBar)findViewById(R.id.seekBar1);
		bar.setOnSeekBarChangeListener(this);
		textProgress = (TextView)findViewById(R.id.textViewProgress);
		stat = (TextView)findViewById(R.id.stat);
		Button hit = (Button) findViewById(R.id.hit);
		Button stay = (Button) findViewById(R.id.stay);
		stay.setOnClickListener(this);
		hit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
        case R.id.hit: 
        	if(potVal!=0){
        		t.setAmount(t.getAmount()-potVal);
        		Log.d("Game","Player t added the amount of  "+potVal+" to the pot");
        		t.hand.add(a.deck.remove());
        		stat.setText("Amount Added Card Given");
        	}
        	else{
        		stat.setText("Please set the pot");
        		//display error
        	}
         // do something
        	
         break;
        case R.id.stay:
         // do something else
         break;
     }
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		// TODO Auto-generated method stub
		textProgress.setText("The value is: "+progress);
    	
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		seekBar.setSecondaryProgress(seekBar.getProgress());
		potVal=seekBar.getProgress();
		
	} 
}

