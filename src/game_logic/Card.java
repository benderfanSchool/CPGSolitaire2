package game_logic;

/**
 * public class Card
 * <p>
 * This class represents a playing card. The values of suit and value have specific meanings.
 * <p>
 * suit: 1 = hearts, 2 = spades, 3 = diamonds, 4 = clubs
 * <p>
 * value: 1 = ace,2-10 = what you'd expect, 11 = jack, 12 = queen, 13 = king
 * <p>
 * @author gallalex111
 * @version 1.0
 */
public class Card
{
	int suit;
	int value;
	
	public Card(int suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
}
