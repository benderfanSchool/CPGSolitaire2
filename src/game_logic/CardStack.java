package game_logic;

/**
 * public class CardStack
 * <p>
 * This class represents a stack of playing cards, like a deck or a column in klondike solitaire
 * <p>
 * @author gallalex111
 * @version 1.0
 */

public class CardStack 
{
	public CardStack(Card card)
	{
		header = new Node(card, 0);
	}
	
	public CardStack()
	{
		header = null;
	}
	
	private class Node
	{
		Node link;
		Card card;
		int stackPos;
		
		public Node(Card card, int stackPos)
		{
			this.card = card;
			this.stackPos = stackPos;
		}
	}
	
	Node header;
	
	/**
	 * public Card pop()
	 * <p>
	 * Pops the top card off the stack
	 * <p>
	 * @param node The node currently being worked on (when calling it, always call it using header)
	 * @return The top card on the stack or null if the stack is empty.
	 */
	public Card pop()
	{
		if(header != null)
		{
			return pop(header);
		}
		else
		{
			return null;
		}
	}
	
	private Card pop(Node node)
	{
		Card tmp; //Temporary storage for the value of the node being returned
		
		if(node.link == null)
		{
			tmp = node.card;
			node = null;
			return tmp;
		}
		else
		{
			return pop(node.link);
		}
	}
	
	/**
	 * public void push(Card card)
	 * <p>
	 * Puts the specified card onto the top of the stack
	 * <p>
	 * @param card The card to be placed on top of the stack
	 */
	public void push(Card card)
	{
		push(card, header, 0);
	}
	
	/**
	 * public void push(Card card, Node node)
	 * <p>
	 * Places the specified card on top of the stack
	 * <p>
	 * @param card the card being placed
	 * @param node the node currently being worked on
	 */
	private void push(Card card, Node node, int stackPos)
	{
		if(node == null)
		{
			node = new Node(card, stackPos);
		}
		else
		{
			push(card, node.link, stackPos++);
		}
	}
	
	/**
	 * public Card peek()
	 * <p>
	 * Allows you to see the top card of the stack without removing it from the stack
	 * <p>
	 * @return The top card on the stack
	 */
	public Card peek()
	{
		return peek(header);
	}
	
	private Card peek(Node node)
	{
		if(node.link == null)
		{
			return node.card;
		}
		else
		{
			return peek(node.link);
		}
			
	}
	
	/**
	 * public boolean isEmpty()
	 * <p>
	 * Allows you to check if the stack is empty
	 * <p>
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if(header == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
