package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Card {


  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }
  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();


    for (Suit suit: Suit.values()) {
      for (Rank rank : Rank.values()) {
      Card card = new Card(rank, suit);
      deck.add(card);
      }
    }

    Collections.shuffle(deck);

  }

}
