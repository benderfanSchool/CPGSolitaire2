package game_logic;

import hsa2.GraphicsConsole;

/**
 * public class Klondike
 * <p>
 * Contains all the logic required for playing Klondike solitaire
 * <p>
 * @author gallalex111
 * @version 0.1
 */
public class Klondike
{
	private CardStack deck = new CardStack(); //The deck
	private CardStack[] tableau = new CardStack[7]; //The cards in play
	private CardStack[] foundations = new CardStack[4]; //The foundations, ordered from left to right
	private CardStack talon = new CardStack(); //The cards in play that aren't on the tableau and aren't in the foundations
	private long score = 0;
	
	public Klondike()
	{
		init();
	}
	
	private void init()
	{
		Card[] newDeck = new Card[52];
		Card tmp;
		int swapOne;
		int swapTwo;
		
		for(int i = 1; i <= 4; i++)
		{
			for(int j = 1; j <= 13; j++)
			{
				newDeck[(i*j)-1] = new Card(i, j);
			}
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
		
		tableau[0] = new CardStack();
		tableau[1] = new CardStack();
		tableau[2] = new CardStack();
		tableau[3] = new CardStack();
		tableau[4] = new CardStack();
		tableau[5] = new CardStack();
		tableau[6] = new CardStack();
		
		foundations[0] = new CardStack();
		foundations[1] = new CardStack();
		foundations[2] = new CardStack();
		foundations[3] = new CardStack();
		
		for(int i = 0; i < tableau.length; i++)
		{
			initTableau(tableau[i], i+1);
		}
	}
	
	public CardStack getTalon()
	{
		return talon;
	}
	
	public CardStack getDeck()
	{
		return deck;
	}
	
	public CardStack getTableauCol(int col)
	{
		return tableau[col];
	}
	
	public CardStack getFoundation(int col)
	{
		return foundations[col];
	}
	
	public long getScore()
	{
		return score;
	}
	
	public void draw()
	{
		talon.push(deck.pop());
	}
	
	private int rand(int high, int low)
	{
		return (int)((Math.random()*(high-low))+low);
	}
	
	private void initTableau(CardStack col, int colNum)
	{
		for(int i = 0; i < colNum; i++)
		{
			col.push(deck.pop());
		}
	}
}
