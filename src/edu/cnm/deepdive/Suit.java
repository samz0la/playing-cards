package edu.cnm.deepdive;

public enum Suit {
  CLUBS(Color.BLACK, '\u2663'),
  DIAMONDS(Color.RED, '\u2662'),
  HEARTS(Color.RED, '\u2661'),
  SPADES (Color.BLACK, '\u2660');

  private Color color;
  private char symbol;

  public char getSymbol() {
    return symbol;
  }

  Suit(Color color, char symbol) {
    this.color=color;
    this.symbol=symbol;

  }


  public Color getColor() {
    return color;
  }

  public enum Color {
    BLACK, RED
  }

}
