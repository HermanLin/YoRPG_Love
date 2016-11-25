/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Rogue extends Character {
    public Rogue () {
	//super ();
	name = "";
	life = 60;
	strength = 140;
	defense = 30;
	attackRating = .6;

    }
    public Rogue (String names) {
	this ();
	name = names;
    }
    
    public void specialize (){
	defense = 15;
	attackRating = .80;
    }

    public void normalize()  {
	defense = 30;
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
