package com.example.card_game;
import java.util.*;
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
	
	
}
