package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class CardTrick {


  public static void main(String[] args) {
    Random rng = new Random();
    Stack<Card> deck = new Stack<>();
    Stack<Card> redPile = new Stack<>();
    Stack<Card> blackPile = new Stack<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.push(new Card(rank, suit));
      }
    }
    Collections.shuffle(deck, rng);
    while (!deck.isEmpty()) {
      Card selector = deck.pop();
      Card card = deck.pop();
      if (selector.getSuit().getColor() == Suit.Color.RED) {
        redPile.push(card);
      } else {
        blackPile.push(card);
      }
    }
    assert 2 * (redPile.size() + blackPile.size()) == Suit.values().length * Rank.values().length;
    Collections.shuffle(redPile, rng); //Not strictly necessary
    Collections.shuffle(blackPile, rng); //Not strictly necessary
    int n = rng.nextInt(Math.min(redPile.size(), blackPile.size()) + 1);
    Stack<Card> redExtract = new Stack<>();
    Stack<Card> blackExtract = new Stack<>();
    for (int i = 0; i < n; i++) {
      redExtract.push(redPile.pop());
      redExtract.push(blackPile.pop());
    }
    redPile.addAll(blackExtract);
    blackPile.addAll(redExtract);
    System.out.printf("Red Ple: %s%n", redPile);
    System.out.printf("Black Pile: %s%n", blackPile);

    long redCount = redPile.parallelStream()
        .filter((c) -> c.getSuit().getColor() == Color.RED)
        .count();
    long blackCount = blackPile.parallelStream()
        .filter((c) -> c.getSuit().getColor() == Color.BLACK)
        .count();
    assert redCount == blackCount;
  }

}
