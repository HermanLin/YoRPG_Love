/*Herman Lin, Jenny Han (Team Love)
APCS1 - pd4
HW35 -- Ye Olde Role Playing Game, Realized
2016-11-25*/

public abstract class Character {

    //==========VARIABLES FOR CHARACTER SUBCLASSES===========
    
    protected int initLife;
    protected int life;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected String name;
    protected int money;
    protected int potions;

    //==========INSTANTIATE BASIC CHARACTER STATS===========
    
    public Character () {
	name = "";
      	life = 125;
	strength = 100;
	defense = 40;
	attackRating = .4;
	initLife = 125;
	money = 10;
	potions = 0;
    }

    //===========CHARACTER isAlive?============
    
    public boolean isAlive() {
	if ( life > 0) {
	    return true; }
	return false;
    }

    //===========GET NAME OF CHARACTER============
    
    public String getName () {
	return name;
    }

    //=========GET CHARACTER DEFENSE STAT=========
    
    public int getDefense (){
	return defense;
    }

    //==========GET CHARACTER MONEY STAT==========
    
    public int getMoney (){
	return money;
    }

    //=========GET CHARACTER POTIONS STAT==========
    
    public int getPotion (){
	return potions;
    }

    //==========GET CHARACTER LIFE STAT==========
    
    public String getLife(){
	return "\nHP: " + life;
    }

    //===========ADD/SUBTRACT TO CHARACTER POTION STAT===========
    
    public void addPotion (int increase) {
	potions += increase;
    }
    public void subPotion (int decrease) {
	potions -= decrease;
    }

    //==========ADD/SUBTRACT TO CHARACTER MONEY STAT=========== 
    
    public void addMoney (int increase) {
	money += increase;
    }
    public void subMoney (int decrease) {
	money -= decrease;
    }

    //===========LOWER THE LIFE STAT===========
    
    public void lowerHP (int decrease) {
	life -= decrease;
    }

    //============ATTACKING METHOD BETWEEN CHARACTERS===========
    
    public int attack (Character characterz) {
        int damage = (int) ((strength * attackRating) - characterz.defense);

	if (damage < 0) {
	    damage = 0; }

	characterz.lowerHP (damage);
	return damage; 
    }

    //=============USING POTION FOR CHARACTER===============
    
    public void usePotion (Character characterz) {
	life += 50;
	if ( life > initLife ) {
	    life = initLife;
	}
    }

    //==========ABSTRACT METHODS==========
    
    public abstract void specialize();
    public abstract void normalize();
    public abstract String about();
   
}
