package Characters;

public abstract class Adventurer {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected int power;
    protected int purse;



    public Adventurer(String name, int maxHealth, int power) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.power = power;
        this.purse = 0;

    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getPurse() {
        return purse;
    }

    public void increasePurse(int purse) {
        this.purse = purse;
    }

    public void increaseHealth(int increaseValue){
        this.health += increaseValue;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public void takeDamage(int damageAmount){
        this.health -= damageAmount;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

}
