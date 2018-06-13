package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import game_logic.Card;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import game_logic.CardStack;
>>>>>>> pr/9
=======
import game_logic.CardStack;
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
import game_logic.Klondike;
import networking.Leaderboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;

import hsa2.*;

public class MainClass implements MouseListener
{
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
	//    SIZES OF THINGS
	
>>>>>>> pr/9
=======
	
	//    SIZES OF THINGS
	
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
	private static final int PLAYINGCARDHEIGHT = 105;
	private static final int PLAYINGCARDWIDTH = 75;
	
	private static final int BUTTONFONTSIZE = 70;
	private static final int SMALLBUTTONFONTSIZE = 30;
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
	//	  BUTTONS
	
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
	private static final Rectangle PLAYBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(screenSize.height/4) - 87, 500, 125); //Centered Play Button
	private static final Rectangle EXITBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(int)(1.5*screenSize.height/4) - 87, 500, 125); //Centered Exit button
	private static final Rectangle KLONDIKEBUTTON = new Rectangle(0, 0, 500, 125); //Top left corner Klondike Button
	private static final Rectangle BACKBUTTON = new Rectangle(0, (int)screenSize.getHeight()-80, 160, 80); //Bottom right corner back button
	private static final Rectangle SIGNINBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(2*screenSize.height/4) - 87, 500, 125); //Centered Sign In button
	private static final Rectangle DRAWBUTTON = new Rectangle(screenSize.width - 160, 
			PLAYINGCARDHEIGHT + 10, 160, 80);
	private static final Rectangle SIGNINCONFIRMBUTTON = new Rectangle(0, 0, 0, 0);
	private static final Rectangle SIGNUPBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(int)(2.5*screenSize.height/4), 500, 125);
	
	//      IMAGES
	
	private static Image CARDBACK;
	private static Image[] HEART = new Image[13];
	private static Image[] SPADE = new Image[13];
	private static Image[] DIAMOND = new Image[13];
	private static Image[] CLUB = new Image[13];
<<<<<<< HEAD
	private static Rectangle DECK = new Rectangle(screenSize.width - (PLAYINGCARDWIDTH + 10), 0, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
=======
	//	  BUTTONS
>>>>>>> pr/9
	
	private static final Rectangle PLAYBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(screenSize.height/4) - 87, 500, 125); //Centered Play Button
	private static final Rectangle EXITBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(int)(1.5*screenSize.height/4) - 87, 500, 125); //Centered Exit button
	private static final Rectangle KLONDIKEBUTTON = new Rectangle(0, 0, 500, 125); //Top left corner Klondike Button
	private static final Rectangle BACKBUTTON = new Rectangle(0, (int)screenSize.getHeight()-80, 160, 80); //Bottom right corner back button
	private static final Rectangle SIGNINBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(2*screenSize.height/4) - 87, 500, 125); //Centered Sign In button
	private static final Rectangle DRAWBUTTON = new Rectangle(screenSize.width - 160, 
			PLAYINGCARDHEIGHT + 10, 160, 80);
	private static final Rectangle SIGNINCONFIRMBUTTON = new Rectangle(0, 0, 0, 0);
	private static final Rectangle SIGNUPBUTTON = new Rectangle((screenSize.width/2) - 125, 
			(int)(2.5*screenSize.height/4), 500, 125);
	
	//      IMAGES
	
	private static Image CARDBACK;
	private static Image[] HEART = new Image[13];
	private static Image[] SPADE = new Image[13];
	private static Image[] DIAMOND = new Image[13];
	private static Image[] CLUB = new Image[13];
	
	//      ENTITIES
	
	private static final Rectangle TALON = new Rectangle(0, 0, 0, 0);
	
	private static Rectangle DECK = new Rectangle(screenSize.width - (PLAYINGCARDWIDTH + 10), 200, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
	
	private static final Rectangle FOUNDATION1 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION2 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION3 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION4 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	
=======
	
	//      ENTITIES
	
	private static final Rectangle TALON = new Rectangle(0, 0, 0, 0);
	
	private static Rectangle DECK = new Rectangle(screenSize.width - (PLAYINGCARDWIDTH + 10), 200, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
	
	private static final Rectangle FOUNDATION1 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION2 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION3 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static final Rectangle FOUNDATION4 = new Rectangle(screenSize.width - 100, 0, 100, 100);
	
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
	//      UTILITIES
	
	private static GraphicsConsole gc = new GraphicsConsole(true, screenSize.width, screenSize.height);
	private static int screenState = 0;
	private static boolean DRAGGING = false;
	private static int previousX = 100;
	private static int previousY = 100;
	private static final int REFRESHTIME = 10;
<<<<<<< HEAD
<<<<<<< HEAD
	
	private static final Rectangle STACK = new Rectangle(screenSize.width - 100, 0, 100, 100);
	private static Rectangle[] STACKS = new Rectangle[7];
=======
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
	private String skin = "PixelRed";
	private static Klondike game = new Klondike();
	private static Leaderboard leaderboard = new Leaderboard();
	private static boolean signedIn = false;
	
	private MainClass()//Constructor
	{
<<<<<<< HEAD
=======
	private String skin = "PixelRed";
	private static Klondike game = new Klondike();
	private static Leaderboard leaderboard = new Leaderboard();
	
	private MainClass()//Constructor
	{
		// initialize gc
>>>>>>> pr/9
=======
		// initialize gc
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
		gc.addMouseListener(this);
		gc.setAntiAlias(true);
		
		//load pictures
//		for(int i = 0; i<13; i++){
//			HEART[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			SPADE[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			CLUB[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			DIAMOND[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}
		
//		CARDBACK = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\cardback.png");
		
		HEART[0] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (1) + ".png");
		CARDBACK = Toolkit.getDefaultToolkit().createImage("resources\\PixelRed\\cardback.png");
		
	}
	
	private static String imageCard(Card card){
		return card.suit + " " + card.value;
		
//		switch(card.suit){
//		case 1:
//			return HEART[card.value];
//			break;
//		case 2:
//			return SPADE[card.value];
//			break;
//		case 3:
//			return CLUB[card.value];
//			break;
//		case 4:
//			return DIAMOND[card.value];
//			break;
//		}
//		
//		return null;
	}
	
	private static void drawCardStack(CardStack stack, Rectangle entity){
		int vShift = 0;
		while(!stack.isEmpty()){
			//gc.drawImage(imageCard(stack.pop()), entity.x, y + 10*vShift);
			vShift++;
		}
	}
	
	public static void main(String[] args)//main
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		Font smallFont = new Font("Monospaced", Font.BOLD, SMALLBUTTONFONTSIZE);
		
		new MainClass();
		
		//load pictures
//		for(int i = 0; i<13; i++){
//			HEART[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			SPADE[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			CLUB[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}

//		for(int i = 0; i<13; i++){
//			DIAMOND[i] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (i) + ".png");
//		}
		
//		CARDBACK = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\cardback.png");
		
		HEART[0] = Toolkit.getDefaultToolkit().createImage("resources\\" + skin + "\\1 " + (1) + ".png");
		CARDBACK = Toolkit.getDefaultToolkit().createImage("resources\\PixelRed\\cardback.png");
		
	}
	
	private static String imageCard(Card card){
		return card.suit + " " + card.value;
		
//		switch(card.suit){
//		case 1:
//			return HEART[card.value];
//			break;
//		case 2:
//			return SPADE[card.value];
//			break;
//		case 3:
//			return CLUB[card.value];
//			break;
//		case 4:
//			return DIAMOND[card.value];
//			break;
//		}
//		
//		return null;
	}
	
	private static void drawCardStack(CardStack stack, Rectangle entity){
		int vShift = 0;
		while(!stack.isEmpty()){
			//gc.drawImage(imageCard(stack.pop()), entity.x, y + 10*vShift);
			vShift++;
		}
	}
	
	public static void main(String[] args)//main
	{
		Font defaultFont = new Font("Monospaced", Font.BOLD, BUTTONFONTSIZE);
		Font smallFont = new Font("Monospaced", Font.BOLD, SMALLBUTTONFONTSIZE);
		
		new MainClass();
		
		while(true)
		{
			switch(screenState){ //Initial screen    Play or exit Menu
			case 0:
				//Draw buttons
				gc.setBackgroundColor(Color.BLUE);
				gc.setColor(Color.CYAN);
				gc.fillRect(PLAYBUTTON.x, PLAYBUTTON.y, PLAYBUTTON.width, PLAYBUTTON.height);
				gc.setColor(Color.RED);
				gc.fillRect(EXITBUTTON.x, EXITBUTTON.y, EXITBUTTON.width, EXITBUTTON.height);
				gc.setColor(Color.MAGENTA);
				gc.fillRect(SIGNINBUTTON.x, SIGNINBUTTON.y, SIGNINBUTTON.width, SIGNINBUTTON.height);
				gc.setColor(Color.YELLOW);
				gc.fillRect(SIGNUPBUTTON.x, SIGNUPBUTTON.y, SIGNUPBUTTON.width, SIGNUPBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.setFont(defaultFont);
				gc.drawString("Play", PLAYBUTTON.x+BUTTONFONTSIZE, PLAYBUTTON.y+(BUTTONFONTSIZE));
				gc.drawString("Exit", EXITBUTTON.x+BUTTONFONTSIZE, EXITBUTTON.y+(BUTTONFONTSIZE));
				gc.drawString("Sign In", SIGNINBUTTON.x+BUTTONFONTSIZE, SIGNINBUTTON.y+(BUTTONFONTSIZE));
				gc.drawString("Sign Up", SIGNUPBUTTON.x+BUTTONFONTSIZE, SIGNUPBUTTON.y+(BUTTONFONTSIZE));
				//System.out.println("Drawn");
				
//				while(screenState == 0)
//				{
//					//delay
//					gc.sleep(1);
//				}
//				
//				//clear screen
//				gc.clear();
				gc.sleep(REFRESHTIME);
				break;
			
			case 1: //Game modes screen Klondike and back
				gc.setColor(Color.GREEN);
				gc.fillRect(KLONDIKEBUTTON.x, KLONDIKEBUTTON.y, KLONDIKEBUTTON.width, KLONDIKEBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.setFont(defaultFont);
				gc.drawString("Klondike", KLONDIKEBUTTON.x+BUTTONFONTSIZE, KLONDIKEBUTTON.y+(BUTTONFONTSIZE));
				
				gc.setColor(Color.RED);
				gc.fillRect(BACKBUTTON.x, BACKBUTTON.y, BACKBUTTON.width, BACKBUTTON.height);
				gc.setFont(smallFont);
				gc.setColor(Color.BLACK);
				gc.drawString("Back", BACKBUTTON.x+SMALLBUTTONFONTSIZE, BACKBUTTON.y+(SMALLBUTTONFONTSIZE*2));
				
//				while(screenState == 1)
//				{
//					gc.sleep(1);
//				}
//				
//				gc.clear();
				gc.sleep(REFRESHTIME);
				break;
			
			case 2: //Game Screen
<<<<<<< HEAD
<<<<<<< HEAD
			//	gc.setColor(Color.GREEN);
			//	gc.fillRect(DECK.x, DECK.y, DECK.width, DECK.height);
=======
				
				CardStack copyTableau[] = game.getTableau().clone(); //copy of the game tableau
				CardStack copyFoundation[] = game.getFoundations().clone(); //copy of the game foundations
				CardStack copyTalon = game.getTalon();//copy of the game talon
				
				//set background
				gc.setBackgroundColor(Color.GREEN);
				
				//Draw deck
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				gc.drawImage(CARDBACK, DECK.x, DECK.y, DECK.width, DECK.height);
=======
>>>>>>> pr/9
				
				CardStack copyTableau[] = game.tableau.clone(); //copy of the game tableau
				CardStack copyFoundation[] = game.foundations.clone(); //copy of the game foundations
				CardStack copyTalon = game.talon;//copy of the game talon
				
				//set background
				gc.setBackgroundColor(Color.GREEN);
				
				//Draw deck
				gc.drawImage(CARDBACK, DECK.x, DECK.y, DECK.width, DECK.height);
				
				//Draw back button
				gc.setColor(Color.RED);
				gc.fillRect(BACKBUTTON.x, BACKBUTTON.y, BACKBUTTON.width, BACKBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.drawString("Back", BACKBUTTON.x+SMALLBUTTONFONTSIZE, BACKBUTTON.y+(SMALLBUTTONFONTSIZE*2));
<<<<<<< HEAD
<<<<<<< HEAD
=======
				
				//Draw draw button
>>>>>>> pr/9
=======
				
				//Draw draw button
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				gc.setColor(Color.ORANGE);
				gc.fillRect(DRAWBUTTON.x, DRAWBUTTON.y, DRAWBUTTON.width, DRAWBUTTON.height);
				gc.setColor(Color.BLACK);
				gc.drawString("Draw", DRAWBUTTON.x+SMALLBUTTONFONTSIZE, DRAWBUTTON.y+SMALLBUTTONFONTSIZE);
<<<<<<< HEAD
<<<<<<< HEAD
				//gc.fillRect(STACK.x, STACK.y, STACK.width, STACK.height);
=======
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				
				
				//Draw foundations
				for(int i = 0; i<copyFoundation.length;i++){
					
					//Draws blank rectangle
					gc.setColor(Color.white);
					gc.drawRect((i*100) + 200, 100, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
					int Vshift = 0;
					Card tmp;
					
					//Draws cards the individual tableau
					while(!copyFoundation[i].isEmpty()){
						Vshift ++;
						tmp = copyFoundation[i].pop();
						gc.drawString(tmp.suit + " " + tmp.value, (i*100) + 200, 300 + 10*Vshift);
						System.out.println("Foundation popped");
					}
				}
				
				//Draws all Tableaux
				for(int i = 0; i<copyTableau.length;i++){
					
					//Draws blank rectangle
					gc.setColor(Color.white);
					gc.drawRect((i*100) + 200, 300, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
					int Vshift = 0;
					Card tmp;
					
					//Draws cards the individual tableau
					while(!copyTableau[i].isEmpty()){
						Vshift ++;
						tmp = copyTableau[i].pop();
						gc.drawString(tmp.suit + " " + tmp.value, (i*100) + 200, 300 + 10*Vshift);
						System.out.println("Tableau popped");
					}
				}
				
<<<<<<< HEAD
=======
				
				
				//Draw foundations
				for(int i = 0; i<copyFoundation.length;i++){
					
					//Draws blank rectangle
					gc.setColor(Color.white);
					gc.drawRect((i*100) + 200, 100, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
					int Vshift = 0;
					Card tmp;
					
					//Draws cards the individual tableau
					while(!copyFoundation[i].isEmpty()){
						Vshift ++;
						tmp = copyFoundation[i].pop();
						gc.drawString(tmp.suit + " " + tmp.value, (i*100) + 200, 300 + 10*Vshift);
						System.out.println("Foundation popped");
					}
				}
				
				//Draws all Tableaux
				for(int i = 0; i<copyTableau.length;i++){
					
					//Draws blank rectangle
					gc.setColor(Color.white);
					gc.drawRect((i*100) + 200, 300, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
					int Vshift = 0;
					Card tmp;
					
					//Draws cards the individual tableau
					while(!copyTableau[i].isEmpty()){
						Vshift ++;
						tmp = copyTableau[i].pop();
						gc.drawString(tmp.suit + " " + tmp.value, (i*100) + 200, 300 + 10*Vshift);
						System.out.println("Tableau popped");
					}
				}
				
=======
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				//Draw Talon
				
				//Draw Blank
				gc.setColor(Color.white);
				gc.drawRect(800, 500, PLAYINGCARDWIDTH, PLAYINGCARDHEIGHT);
				
				//Draw cards in talon
				while(!copyTalon.isEmpty()){
					gc.drawString(imageCard(copyTalon.pop()), 800, 500);
					System.out.println("Talon popped");
				}
				
				
<<<<<<< HEAD
>>>>>>> pr/9
=======
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				if(DRAGGING){ //if something is being dragged
					gc.drawString("DRAG", 200, 200);
					
					//
					DECK.x = MouseInfo.getPointerInfo().getLocation().x;
					DECK.y = MouseInfo.getPointerInfo().getLocation().y;
				}
				
//				while(screenState == 2)
//				{
//					gc.sleep(1);
//				}
//				
//				gc.clear();
				gc.sleep(REFRESHTIME);
				break;
			}
			
			gc.clear();
		}
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
			else if(SIGNINBUTTON.contains(e.getPoint()))
			{
<<<<<<< HEAD
				if(signedIn)
				{
					
				}
				else
				{
					SignUpAndInDialog signInDialog = new SignUpAndInDialog("Sign In");
					String[] userCredentials = signInDialog.getCredentials();
					
					try
					{
						leaderboard.signIn(userCredentials[0], userCredentials[1]);
					}
					catch(NullPointerException ex)
					{
						
					}
					catch(Exception ex)
					{
						System.out.println(ex.toString());
					}
				}
			}
			else if(SIGNUPBUTTON.contains(e.getPoint()))
			{
<<<<<<< HEAD
				SignUpAndInDialog signUpDialog = new SignUpAndInDialog("Sign Up");
				String[] userCredentials = signUpDialog.getCredentials();
				
				try
				{
					leaderboard.signUp(userCredentials[0], userCredentials[1]);
=======
				
			}
			else if(SIGNUPBUTTON.contains(e.getPoint()))
			{
				//SignUpDialog signUpDialog = new SignUpDialog();
				//String[] userCredentials = signUpDialog.getCredentials();
				
				try
				{
					//leaderboard.signUp(userCredentials[0], userCredentials[1]);
>>>>>>> pr/9
=======
				//SignUpDialog signUpDialog = new SignUpDialog();
				//String[] userCredentials = signUpDialog.getCredentials();
				
				try
				{
					//leaderboard.signUp(userCredentials[0], userCredentials[1]);
>>>>>>> 6cd63ac26c611a659daa180c8473df12c9fd94ec
				}
				catch(NullPointerException ex)
				{
					
				}
				catch(Exception ex)
				{
					System.out.println(ex.toString());
				}
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
			else if(DRAWBUTTON.contains(e.getPoint()))
			{
				game.draw();
			}
		}
		
		//gc.sleep(REFRESHTIME);
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//gc.sleep(REFRESHTIME);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//gc.sleep(REFRESHTIME);
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
		
		//gc.sleep(REFRESHTIME);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(screenState == 2)
		{
			DRAGGING = false;
			if(FOUNDATION1.contains(e.getPoint())){
				
			}
			else{
				
			}
		}
		//gc.sleep(REFRESHTIME);
	}
	
}
