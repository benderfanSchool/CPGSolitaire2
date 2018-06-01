package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
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
	
	private static boolean DRAGGING = false;
	private static int previousX = 100;
	private static int previousY = 100;
	
	private static final int REFRESHTIME = 10;
	
	private static final Rectangle STACK = new Rectangle(100, 100, 100, 100);
	
	private MainClass()//Constructor
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		gc.addMouseListener(this);
		gc.setAntiAlias(true);
		
		while(true)
		{
			switch(screenState){ //Initial screen    Play or exit Menu
			case 0:
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
//				
//				//clear screen
//				gc.clear();
				//gc.sleep(REFRESHTIME);
				break;
			
			case 1: //Game modes screen Klondike and back
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
//				
//				gc.clear();
				//gc.sleep(REFRESHTIME);
				break;
			
			case 2: //Game Screen
				gc.setColor(Color.GREEN);
				gc.fillRect(DECK.x, DECK.y, DECK.width, DECK.height);
				
				gc.setColor(Color.RED);
				gc.fillRect(BACKBUTTON.x, BACKBUTTON.y, BACKBUTTON.width, BACKBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.drawString("Back", BACKBUTTON.x+BUTTONFONTSIZE, BACKBUTTON.y+(BUTTONFONTSIZE*2));
				
				gc.fillRect(STACK.x, STACK.y, STACK.width, STACK.height);
				
				gc.setColor(Color.GREEN);
				gc.fillRect(DECK.x, DECK.y, DECK.width, DECK.height);
				
//				if(DRAGGING){ //if something is being dragged
//					gc.drawString("DRAG", 200, 200);
//					
//					//
//					DECK.x = MouseInfo.getPointerInfo().getLocation().x;
//					DECK.y = MouseInfo.getPointerInfo().getLocation().y;
//				}
				
				//while(screenState == 2)
				//{
					if(DRAGGING){ //if something is being dragged
						gc.setColor(Color.BLACK);
						gc.drawString("DRAG", 200, 200);
						
						//
						DECK.x = MouseInfo.getPointerInfo().getLocation().x;
						DECK.y = MouseInfo.getPointerInfo().getLocation().y;
					}
					gc.sleep(REFRESHTIME);
				//}
//				
//				gc.clear();
				//gc.sleep(REFRESHTIME);
				break;
			}
			
			gc.sleep(REFRESHTIME);
			gc.clear();
		}
	}
	
	public static void main(String[] args)//main
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		
		new MainClass();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) //clicking buttons
	{
		
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
		
		gc.sleep(REFRESHTIME);
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		gc.sleep(REFRESHTIME);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		gc.sleep(REFRESHTIME);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(screenState == 2)
		{
			if(DECK.contains(e.getPoint())){
				
				DRAGGING = true;
				
				previousX = DECK.x;
				previousY = DECK.y;
			}
		}
		
		gc.sleep(REFRESHTIME);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(screenState == 2)
		{
			DRAGGING = false;
			if(STACK.contains(e.getPoint())){
				
				DECK.x = STACK.x;
				DECK.y = STACK.y;
			}
			else{
				DECK.x = previousX;
				DECK.y = previousY;
			}
		}
		gc.sleep(REFRESHTIME);
	}
	
}
