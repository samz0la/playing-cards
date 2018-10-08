package edu.cnm.deepdive;


import java.util.LinkedList;
import java.util.List;

public class BlackjackHand implements Comparable<BlackjackHand> {

  private List<Card> cards = new LinkedList<>();
  private int rawValue = 0;
  private int aces = 0;

  public void add(Card card) {
    cards.add(card);
    rawValue += Math.min(10, card.getRank().getValue());
    if (card.getRank() == Rank.ACE) {
      aces++;
    }
  }

  private int getValue() {
    int value = rawValue;
    if (rawValue > 21) {
      value = 0;
    } else if (rawValue <= 11 && aces > 0) {
      value += 10;
    }
    if (value == 21 && cards.size() ==2) {
      value++;
    }
    return value;
  }

  @Override
  public int compareTo(BlackjackHand other) {
    return getValue() - other.getValue();
  }
}


