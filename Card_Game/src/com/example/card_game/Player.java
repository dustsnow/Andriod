package com.example.card_game;
import java.util.*;

import android.util.Log;
public class Player {
	private int amount;
	public LinkedList<Card> hand;
	public Player(){
		setAmount(1000);
		hand = new LinkedList<Card> ();
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getHandPoints(){
		int ret = 0;
		int numA =0;
		for(Card t : hand){
			
			int temp = t.getPoint();
			Log.d("Player","card t "+t+" temp val ="+temp);
			if (temp==11) numA++;
			else ret += temp;
			Log.d("Player","numA "+numA+" ret ="+ret);
		}
		while(numA>0){
			if(ret+11>21) ret+=1;
			else ret+=11;
			numA--;
		}
		return ret;
	}
	
}
