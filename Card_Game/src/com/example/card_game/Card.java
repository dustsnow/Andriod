package com.example.card_game;

public class Card {
	private Value val;
	private Suit suit;
	
	public Card(Suit s, Value v){
		setVal(v);
		setSuit(s);
	}

	public Value getVal() {
		return val;
	}

	private void setVal(Value val) {
		this.val = val;
	}

	public Suit getSuit() {
		return suit;
	}

	private void setSuit(Suit suit) {
		this.suit = suit;
	}
}

