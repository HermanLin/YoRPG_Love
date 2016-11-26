/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW35 -- Ye Olde Role Playing Game, Realized
2016-11-25*/

public class Archer extends Character {
    //INSTANTIATE CHARACTER STATS
    public Archer () {
	//super ();
	name = "";
	life = 70;
	strength = 130;
	defense = 30;
	attackRating = .65;
	initLife = 70;
	money = 10;
	potions = 0;
    }

    //SET CHARACTER NAME
    public Archer (String names) {
	this ();
	name = names;
    }

    //SPECIALIZED ATTACK FOR CHARACTER
    public void specialize (){
	defense = 10;
	attackRating = .90;
    }
    public void normalize()  {
	defense = 30;
	attackRating = .65;
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
