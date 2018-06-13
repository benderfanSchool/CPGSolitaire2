package game_logic;

import java.io.RandomAccessFile;

import hsa2.GraphicsConsole;

public class Klondike
{
	private CardStack deck = new CardStack();
	private CardStack[] tableau = new CardStack[7]; //The cards in play
	private CardStack[] foundations = new CardStack[4]; //The foundations, ordered from left to right
	private CardStack talon = new CardStack(); //The cards in play that aren't on the tableau and aren't in the foundations
	private CardStack hand = new CardStack();
	private long score;
	
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
		
		score = 0;
		
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
	
	public void draw()
	{
		Card tmp = deck.pop();
		
		tmp.revealed = true;
		
		talon.push(tmp);
	}
	
	private int rand(int high, int low)
	{
		return (int)((Math.random()*(high-low))+low);
	}
	
	public CardStack getFoundation(int index)
	{
		return foundations[index];
	}
	
	public void setFoundation(int index, CardStack foundation)
	{
		foundations[index] = foundation;
	}
	
	public CardStack[] getFoundations()
	{
		return foundations;
	}
	
	public void setFoundations(CardStack[] newFoundations)
	{
		foundations = newFoundations;
	}
	
	public CardStack getTableauColumn(int index)
	{
		return tableau[index];
	}
	
	public void setTableauColumn(int index, CardStack tableauCol)
	{
		tableau[index] = tableauCol;
	}
	
	public CardStack[] getTableau()
	{
		return tableau;
	}
	
	public void setTableau(CardStack[] newTableau)
	{
		tableau = newTableau;
	}
	
	public CardStack getDeck()
	{
		return deck;
	}
	
	public void setDeck(CardStack newDeck)
	{
		deck = newDeck;
	}
	
	public CardStack getTalon()
	{
		return talon;
	}
	
	public void setTalon(CardStack newTalon)
	{
		talon = newTalon;
	}
	
	public CardStack getHand()
	{
		return hand;
	}
	
	public void setHand(CardStack newHand)
	{
		hand = newHand;
	}
	
	public long getScore()
	{
		return score;
	}
	
	public void setScore(long newScore)
	{
		score = newScore;
	}
	
	public boolean hasWon()
	{
		boolean won = false;
		CardStack tmp = new CardStack();
		
		for(int i = 0; i < foundations.length; i++)
		{
			for(int j = 13; j >= 1; j--)
			{
				if(foundations[i].peek().value == j)
				{
					won = true;
				}
				else
				{
					return false;
				}
				tmp.push(foundations[i].pop());
			}
			
			for(int j = 0; j < 13; j++)
			{
				foundations[i].push(tmp.pop());
			}
		}
		
		return won;
	}
}
