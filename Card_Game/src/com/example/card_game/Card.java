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
	public String toString(){
		return val+" "+suit;
	}
	public int getPoint(){
		switch (val){
			//A,two,three,four,five,six,seven,eight,nine,ten,J,Q,K
		case ten: case J: case Q: case K:
			return 10;
		case two: return 2;
		case three: return 3;
		case four: return 4;
		case five: return 5;
		case six: return 6;
		case seven: return 7;
		case eight: return 8;
		case nine: return 9;
		case A: return 11;
		}
		return 0;
		
	}
}

