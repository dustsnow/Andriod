package com.example.card_game;
import java.util.*;

public class Deck{
	
	/**
	 * @param args
	 */
	public LinkedList<Card> deck=new LinkedList<Card>();
	public Deck(){
		for(Suit s: Suit.values()){
			for(Value v: Value.values()){
				deck.add(new Card(s,v));
			}
		}
	}

}