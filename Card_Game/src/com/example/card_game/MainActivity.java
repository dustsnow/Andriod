package com.example.card_game;

import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
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
    private Player t,comp;
    private int pot;
    private int potVal;
    private TextView CardDis;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ADebugTag","test" );
		a = new Deck();
		pot=0;
		potVal=0;
		Collections.shuffle(a.deck);
		
		t = new Player();
		comp = new Player();
		//t.hand.add(a.deck.remove());
		//Log.d("Init","Player t added card "+t.hand.getLast().getSuit()+ t.hand.getLast().getSuit());
		//t.hand.add(a.deck.remove());
		//Log.d("Init","Player t added card "+t.hand.getLast().getSuit()+ t.hand.getLast().getSuit());
		
		bar = (SeekBar)findViewById(R.id.seekBar1);
		bar.setMax(t.getAmount());
		bar.setOnSeekBarChangeListener(this);
		textProgress = (TextView)findViewById(R.id.textViewProgress);
		stat = (TextView)findViewById(R.id.stat);
		CardDis = (TextView)findViewById(R.id.CardDis);
		Button hit = (Button) findViewById(R.id.hit);
		Button stay = (Button) findViewById(R.id.stay);
		Button reset = (Button) findViewById(R.id.Reset);
		stay.setOnClickListener(this);
		hit.setOnClickListener(this);
		reset.setOnClickListener(this);
		stat.setMovementMethod(new ScrollingMovementMethod());
		CardDis.setMovementMethod(new ScrollingMovementMethod());
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
		case R.id.Reset:
			t = new Player();
			comp=new Player();
			a = new Deck();
			pot=0;
			potVal=0;
			Collections.shuffle(a.deck);
			bar.setMax(t.getAmount());
			bar.setOnSeekBarChangeListener(this);
			stat.setText("");
			CardDis.setText("");
			break;
        case R.id.hit: 
        	if(potVal!=0){
        		t.setAmount(t.getAmount()-potVal);
        		Log.d("Game","Player t added the amount of  "+potVal+" to the pot");
        		Card temp =a.deck.remove(); 
        		Card compTemp = a.deck.remove(); 
        		t.hand.add(temp);
        		comp.hand.add(compTemp);
        		pot+=potVal;
        		if(t.getHandPoints()>21){
        			stat.setText(stat.getText()+"\nyou got busted");
        			pot=0;
        			t.hand.clear();
        			comp.hand.clear();
        		}
        		if(t.getHandPoints()==21){
        			stat.setText(stat.getText()+"\n Blackjack!!!!!");
        			t.setAmount(t.getAmount()+(int) ((2*pot)*1.5));
        			t.hand.clear();
        			comp.hand.clear();
        		}
        		if(comp.getHandPoints()==21){
        			stat.setText("Comp have won");
        			pot = 0; 
        			t.hand.clear();
        			comp.hand.clear();
        		}
        		if(comp.getHandPoints()>=21){
        			stat.setText("Comp busted");
        			t.setAmount( t.getAmount()+2*(pot));
        			pot=0;
        			t.hand.clear();
        			comp.hand.clear();
        		}
        		stat.setText("Amount of "+potVal+" Added to pot Card Given\nThe pot is now"+pot+"");
        		bar.setMax(t.getAmount());
        		CardDis.setText(temp+" your point val is "+t.getHandPoints()+"\n"+CardDis.getText());
        		if(bar.getMax()==0) potVal=0;
            		
        	}
        	else{
        		stat.setText("Please set the pot");
        	}
        
         break;
        case R.id.stay:
         // do something else
        	if(comp.getHandPoints()>t.getHandPoints()){
        		stat.setText("Comp have won");
    			pot = 0; 
    			t.hand.clear();
    			comp.hand.clear();        		
        	}
        	else{
        		stat.setText("You have won");
        		t.setAmount( t.getAmount()+(pot));
    			pot=0;
    			t.hand.clear();
    			comp.hand.clear();
        	}
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

