public class Boss extends Monster {
    public Boss () {
	name = "boss";
	strength = (int) ((Math.random() * 45 ) + 40);
	life = 175;
	defense = 30;
	attackRating = 1.5;
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
    
