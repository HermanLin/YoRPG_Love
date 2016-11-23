/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW32 -- Ye Olde Role Playing Game, Expanded
2016-11-20*/

public abstract class Character {

    protected int life;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected String name;
    protected int money;
    protected int potions;
    /*
    protected int specDef;
    protected double specAttRate;
    protected int normDef;
    protected double normAttRate;
    */
    public Character () {
	name = "";
      	life = 125;
	strength = 100;
	defense = 40;
	attackRating = .4;

	specDef = 20;
	specAttRate = .75;
	normDef = 40;
	normAttRate = .4;
    }

    public boolean isAlive() {
	if ( life > 0) {
	    return true; }
	return false;
    }

    public String getName () {
	return name;
    }

    public int getDefense (){
	return defense;
    }
    
    public int getMoney (){
	return money;
    }

    public int getPotion (){
	return potions;
    }

    public void lowerHP (int decrease) {
	life -= decrease;
    }

    public int  attack (Character characterz) {
        int damage = (int) ((strength * attackRating) - characterz.defense);

	if (damage < 0) {
	    damage = 0; }

	characterz.lowerHP (damage);
	return damage; 
    }

    public abstract void specialize();

    public abstract void normalize();

    public abstract String about();
    /*
    public void specialize (){
	defense = specDef;
	attackRating = specAttRate;
    }

    public void normalize()  {
	defense = normDef;
	attackRating = normAttRate;
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
    */
}
