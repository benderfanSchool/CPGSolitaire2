package game_logic;

import java.io.RandomAccessFile;

import hsa2.GraphicsConsole;

public class Klondike
{
	private CardStack deck = new CardStack();
	private CardStack[] tableau = new CardStack[7]; //The cards in play
	private CardStack[] foundations = new CardStack[4]; //The foundations, ordered from left to right
	private CardStack talon = new CardStack(); //The cards in play that aren't on the tableau and aren't in the foundations
	
	public Klondike()
	{
		init();
	}
	
	private void init()
	{
		Card[] newDeck = new Card[52];
		Card tmp;
		RandomAccessFile deckInput;
		int swapOne;
		int swapTwo;
		
		try
		{
			deckInput = new RandomAccessFile("resources\\deck\\deck.dat", "r");
			
			for(int i = 0; i < newDeck.length; i++)
			{
				newDeck[i] = new Card(deckInput.readInt(), deckInput.readInt());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < newDeck.length; i++)
		{
			System.out.println("Card: " + (i+1) + "\tSuit: " + newDeck[i].suit + "\tValue: " + newDeck[i].value);
		}
		
		for(int i = 0; i < newDeck.length; i++)
		{
			swapOne = rand(newDeck.length-1, 0);
			swapTwo = rand(newDeck.length-1, 0);
			
			while(swapTwo == swapOne)
			{
				swapTwo = rand(newDeck.length-1, 0);
			}
			
			tmp = newDeck[swapOne];
			newDeck[swapOne] = newDeck[swapTwo];
			newDeck[swapTwo] = tmp;
		}
		
		for(int i = 0; i < newDeck.length; i++)
		{
			deck.push(newDeck[i]);
		}
		
		for(int i = 1; i < tableau.length+1; i++)
		{
			tableau[i-1] = new CardStack();
			for(int j = 0; j < i; j++)
			{
				tableau[i-1].push(deck.pop());
			}
		}
		
		foundations[0] = new CardStack();
		foundations[1] = new CardStack();
		foundations[2] = new CardStack();
		foundations[3] = new CardStack();
	}
	
	private int rand(int high, int low)
	{
		return (int)((Math.random()*(high-low))+low);
	}
}
