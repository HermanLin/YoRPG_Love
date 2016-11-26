/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW35 -- Ye Olde Role Playing Game, Realized
2016-11-25*/

public class Warrior extends Character{
    //INSTANTIATE CHARACTER STATS
    public Warrior () {
	super ();
    }

    //SET CHARACTER NAME
    public Warrior (String names) {
	this ();
	name = names;
    }

    //SPECIALIZED ATTACK FOR CHARACTER
    public void specialize (){
	defense = 20;
	attackRating = .75;
    }
    public void normalize()  {
	defense = 40;
	attackRating = .4;
    }

    //GET CHARACTER STATS
    public String about () {
	String retStr = "";
	retStr += "Name         : " + name + "\n";
	retStr += "HP           : " + life + "\n";
	retStr += "Strength     : " + strength + "\n";
	retStr += "Defense      : " + defense + "\n";
	retStr += "Attack Rating: " + attackRating + "\n";
	retStr += "Gold Pouch   : " + money + "\n";
	retStr += "Potion Bag   : " + potions + "\n";
	return retStr;
    }
}
