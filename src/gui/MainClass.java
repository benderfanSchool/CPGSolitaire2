package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import hsa2.*;

public class MainClass implements MouseListener
{
	private static final int PLAYINGCARDHEIGHT = 25;
	private static final int PLAYINGCARDWIDTH = 35;
	
	private static final int BUTTONFONTSIZE = 70;
	
	private static int screenState = 0;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private static final Rectangle PLAYBUTTON = new Rectangle((screenSize.width/2) - 250, (screenSize.height/3) - 175, 500, 250); //Centered Play Button
	private static final Rectangle EXITBUTTON = new Rectangle((screenSize.width/2) - 250, (2*screenSize.height/3) - 175, 500, 250); //Centered Exit button
	private static final Rectangle KLONDIKEBUTTON = new Rectangle(0, 0, 500, 250); //Top left corner Klondike Button
	private static final Rectangle BACKBUTTON = new Rectangle(0, (int)screenSize.getHeight()-250, 500, 250); //Bottom right corner back button
	private static Rectangle DECK = new Rectangle(screenSize.width - (PLAYINGCARDWIDTH + 10), screenSize.height - (PLAYINGCARDHEIGHT + 10), PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
	
	private static GraphicsConsole gc = new GraphicsConsole(true, screenSize.width, screenSize.height);
	
	private MainClass()//Constructor
	{
		gc.addMouseListener(this);
		gc.setAntiAlias(true);
	}
	
	public static void main(String[] args)//main
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		
		new MainClass();
		
		while(true)
		{
			if(screenState == 0) //Initial screen    Play or exit Menu
			{
				//Draw buttons
				gc.setColor(Color.CYAN);
				gc.fillRect(PLAYBUTTON.x, PLAYBUTTON.y, PLAYBUTTON.width, PLAYBUTTON.height);
				gc.setColor(Color.RED);
				gc.fillRect(EXITBUTTON.x, EXITBUTTON.y, EXITBUTTON.width, EXITBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.setFont(defaultFont);
				gc.drawString("Play", PLAYBUTTON.x+BUTTONFONTSIZE, PLAYBUTTON.y+(BUTTONFONTSIZE*2));
				gc.drawString("Exit", EXITBUTTON.x+BUTTONFONTSIZE, EXITBUTTON.y+(BUTTONFONTSIZE*2));
				System.out.println("Drawn");
				
				while(screenState == 0)
				{
					//delay
					gc.sleep(1);
				}
				
				//clear screen
				gc.clear();
			}
			
			if(screenState == 1) //Game modes screen    Klondike and back
			{
				gc.setColor(Color.BLUE);
				gc.fillRect(KLONDIKEBUTTON.x, KLONDIKEBUTTON.y, KLONDIKEBUTTON.width, KLONDIKEBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.setFont(defaultFont);
				gc.drawString("Klondike", KLONDIKEBUTTON.x+BUTTONFONTSIZE, KLONDIKEBUTTON.y+(BUTTONFONTSIZE*2));
				
				gc.setColor(Color.RED);
				gc.fillRect(BACKBUTTON.x, BACKBUTTON.y, BACKBUTTON.width, BACKBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.drawString("Back", BACKBUTTON.x+BUTTONFONTSIZE, BACKBUTTON.y+(BUTTONFONTSIZE*2));
				
				while(screenState == 1)
				{
					gc.sleep(1);
				}
				
				gc.clear();
			}
			if(screenState == 2)
			{
				gc.setColor(Color.GREEN);
				gc.fillRect(DECK.x, DECK.y, DECK.width, DECK.height);
				
				gc.setColor(Color.RED);
				gc.fillRect(BACKBUTTON.x, BACKBUTTON.y, BACKBUTTON.width, BACKBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.drawString("Back", BACKBUTTON.x+BUTTONFONTSIZE, BACKBUTTON.y+(BUTTONFONTSIZE*2));
				
				while(screenState == 2)
				{
					gc.sleep(1);
				}
				
				gc.clear();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) //clicking buttons
	{
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("Click");
		if(screenState == 0) //Initial menu
		{	
			if(PLAYBUTTON.contains(e.getPoint()))
			{
				screenState = 1;
			}
			else if(EXITBUTTON.contains(e.getPoint()))
			{
				System.exit(0);
			}
		}
		else if(screenState == 1) //Game Select
		{
			if(KLONDIKEBUTTON.contains(e.getPoint()))
			{
				screenState = 2;
			}
			else if(BACKBUTTON.contains(e.getPoint()))
			{
				screenState = 0;
			}
		}
		else if(screenState == 2) //Klondike Game
		{
			if(BACKBUTTON.contains(e.getPoint()))
			{
				screenState = 1;
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(screenState == 2)
		{
			if(DECK.contains(e.getPoint())){
				
				gc.drawString("DRAG", 250, 250);
				
				DECK.x = e.getX();
				DECK.y = e.getY();
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
