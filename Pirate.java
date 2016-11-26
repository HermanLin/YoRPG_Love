/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW35 -- Ye Olde Role Playing Game, Realized
2016-11-25*/

public class Pirate extends Character {
    //INSTANTIATE CHARACTER STATS
    public Pirate () {
	//super ();
	name = "";
	life = 80;
	strength = 100;
	defense = 40;
	attackRating = .6;
	initLife = 80;
	money = 10;
	potions = 0;
    }

    //SET CHARACTER NAME
    public Pirate (String names) {
	this ();
	name = names;
    }

    //SPECIALIZED ATTACK FOR CHARACTER
    public void specialize (){
	defense = 5;
	attackRating = 1;
    }
    public void normalize()  {
	defense = 40;
	attackRating = .6;
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
