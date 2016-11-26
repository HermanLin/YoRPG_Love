/*Herman Lin, Jenny Han (Team Love)
  APCS1 - pd4
  HW35 -- Ye Olde Role Playing Game, Realized
  2016-11-25*/

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat;
    private Monster smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int characterTypeNum;
    private int storeLoop = 0;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String name = "";
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
	
	//==========CHARACTER SELECTION==========
	
	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	//=========CLASS SELECTION=============
	
	s = "Choose your character: \n";
	s += "\t1: Warrior\n";
	s += "\t2: Mage\n";
	s += "\t3: Rogue\n";
	s += "\t4: Pirate\n";
	s += "\t5: Archer\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    characterTypeNum = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	//============NAME SELECTION==============
	
	s = "Intrepid player, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//=========INSTANTIATION OF PLAYER CHARACTER=========

	if (characterTypeNum == 1) {
	    pat = new Warrior (name);
	}
	else if (characterTypeNum == 2) {
	    pat = new Mage (name);
	}
	else if (characterTypeNum == 3) {
	    pat = new Rogue (name);
	}
	else if (characterTypeNum == 4) {
	    pat = new Pirate (name);
	}
	else if (characterTypeNum == 5) {
	    pat = new Archer (name);
	}

	//print player's character stats
	System.out.print(pat.about());
    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {
		
		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		System.out.println( pat.getLife() );
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    System.out.println( "\t3: Use Potion! Potions Available: " + pat.getPotion());
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		//=======SPECIALIZED ATTACK========
		
		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();

		//===========USING POTION==========
		
		if ( i == 3 ) {
		    if ( pat.getPotion() > 0 ) {
			pat.subPotion( 1 );
			pat.usePotion( pat );
			System.out.println( "50 HP restored!" );
		    }
		    else {
			System.out.println( "You don't have a potion!" );
		    }
		}

		//=========NORMAL ATTACK==========
		
		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		pat.addMoney(20);
		System.out.println( " " );

		//===========POTION STORE===========
		
		System.out.println( "Welcome to the Potion Shoppe" );
		while (storeLoop != 2) {
		    System.out.println( "\tGold Pouch: " + pat.getMoney() );
		    try {
			System.out.println( "\t1: Potion of Healing - 30 Gold" );
			System.out.println( "\t2: Exit Shop" );
			i = Integer.parseInt( in.readLine() );
		    }
		    catch ( IOException e) { }

		    if ( i == 1 ) {
			if ( pat.getMoney() >= 30 ) {
			    System.out.println( "Here's your Potion of Healing!" );
			    pat.subMoney(30);
			    pat.addPotion(1);
			    storeLoop = i;
			}
			else {
			    System.out.println( "You don't have enough gold." );
			}
		    }
		    if ( i == 2 ) {
			storeLoop = i;
			System.out.println( "Good luck on your adventure!" );
		    }
		}
		storeLoop = 0;
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void bossTurn () {

	int i = 1;
	int d1, d2;
	
	Boss morgan = new Boss();

	System.out.println ("Lo, boss monster approacheth");

	while (morgan.isAlive () & pat.isAlive ()) {
	    System.out.println( pat.getLife() );
	    try {
		System.out.println( "\nDo you feel lucky?" );
		System.out.println( "\t1: Nay.\n\t2: Aye!" );
		System.out.println( "\t3: Use Potion! Potions Available: " + pat.getPotion());
		i = Integer.parseInt( in.readLine() );
	    }
	    catch ( IOException e ) { }

	    //==========SPECIALIZED ATTACK===========
	    
	    if ( i == 2 )
		pat.specialize();
	    else
		pat.normalize();

	    //===========USING POTION===========
	    
	    if ( i == 3 ) {
		if ( pat.getPotion() > 0 ) {
		    pat.subPotion( 1 );
		    pat.usePotion( pat );
		    System.out.println( "50 HP restored!" );
		}
		else {
		    System.out.println( "You don't have a potion!" );
		}
	    }

	    //===========NORMAL ATTACK===========
	    
	    d1 = pat.attack( morgan );
	    d2 = morgan.attack( pat );

	    System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				" points of damage.");

	    System.out.println( "\n" + "Ye Boss Monster smacked " + pat.getName() +
				" for " + d2 + " points of damage.");
	}
        
	if ( !morgan.isAlive() && !pat.isAlive() ) {
	    System.out.println( "'Twas an epic battle, to be sure... " + 
				"You cut ye boss monster down, but " +
				"with its dying breath ye boss monster. " +
				"laid a fatal blow upon thy skull." );

	}

	else if ( !morgan.isAlive() ) {
	    System.out.println( "HuzzaaH! Ye boss monster hath been slain!" );

	}
	    
	else if ( !pat.isAlive() ) {
	    System.out.println( "Ye olde self hath expired. You got dead." );
        
	}
    }

    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	
	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	if (game.playTurn()){
	    game.bossTurn ();
	}



	System.out.println( "Thy game doth be over." );
    }//end main

}//end class YoRPG

