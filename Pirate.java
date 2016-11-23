/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Pirate extends Character {
    public Pirate () {
	//super ();
	name = "";
	life = 80;
	strength = 100;
	defense = 40;
	attackRating = .6;

	specDef = 5;
	specAttRate = 1;
	normDef = 40;
	normAttRate = .6;
    }
    public Pirate (String names) {
	this ();
	name = names;
    }
    
    public void specialize (){
	defense = 5;
	attackRating = 1;
    }

    public void normalize()  {
	defense = 40;
	attackRating = .6;
    }

    public String about () {
	String retStr = "";
	retStr += "Name         : " + name + "\n";
	retStr += "HP           : " + life + "\n";
	retStr += "Strength     : " + strength + "\n";
	retStr += "Defense      : " + defense + "\n";
	retStr += "Attack Rating: " + attackRating + "\n";
	return retStr;
    }
} 
