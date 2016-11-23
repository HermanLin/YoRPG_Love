/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Archer extends Character {
    public Archer () {
	//super ();
	name = "";
	life = 70;
	strength = 130;
	defense = 30;
	attackRating = .65;

	specDef = 10;
	specAttRate = .90;
	normDef = 30;
	normAttRate = .65;
    }
    public Archer (String names) {
	this ();
	name = names;
    }
    
    public void specialize (){
	defense = 10;
	attackRating = .90;
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
