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
	private static final Rectangle PLAYBUTTON = new Rectangle(0, 0, 500, 250);
	private static final Rectangle EXITBUTTON = new Rectangle(0, 260, 500, 250);
	private static final Rectangle KLONDIKEBUTTON = new Rectangle(0, 0, 500, 250);
	private static final Rectangle BACKBUTTON = new Rectangle(0, (int)screenSize.getHeight()-250, 500, 250);
	private static GraphicsConsole gc = new GraphicsConsole(true, screenSize.width, screenSize.height);
	
	private MainClass()
	{
		gc.addMouseListener(this);
		gc.setAntiAlias(true);
	}
	
	public static void main(String[] args) 
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		
		new MainClass();
		
		while(true)
		{
			if(screenState == 0)
			{
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
					gc.sleep(1);
				}
				
				gc.clear();
			}
			
			if(screenState == 1)
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
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("Click");
		if(screenState == 0)
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
		else if(screenState == 1)
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
