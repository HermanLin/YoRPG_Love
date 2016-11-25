/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Mage extends Character {
    public Mage () {
	//super();
	name = "";
	life = 50;
	strength = 150;
	defense = 30;
	attackRating = .65;

    }
    public Mage (String names) {
	this ();
	name = names;
    }
    
    public void specialize (){
	defense = 15;
	attackRating = .85;
    }

    public void normalize()  {
	defense = 30;
	attackRating = .65;
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
