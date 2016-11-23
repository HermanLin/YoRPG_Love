/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Warrior extends Character{
    public Warrior () {
	super ();
    }
    public Warrior (String names) {
	this ();
	name = names;
    }
    
    public void specialize (){
	defense = 20;
	attackRating = .75;
    }
    public void normalize()  {
	defense = 40;
	attackRating = .4;
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
