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
	int suit; //The suit of the card
	int value; //The value of the card
	boolean revealed; //Whether or not the card is visible to the user
	int x; //The X position of the card on the screen
	int y; //The Y position of the card on the screen
	
	public Card(int suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
}
