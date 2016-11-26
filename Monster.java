/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public class Monster extends Character{

    //=========INSTANTIATE MONSTER STATS=========
    
    public Monster () {
	name = "monster";
	strength = (int) ((Math.random() * 45) + 20);
	life = 150;
	defense = 20;
	attackRating = 1;
    }
    public void specialize() {}
    public void normalize(){}

    //==========ABOUT THE MONSTER==========
    
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
