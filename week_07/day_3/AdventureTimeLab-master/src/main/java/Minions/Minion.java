package Minions;

public class Minion {
    private int health;
    private int maxHealth;
    private String name;

    public Minion(int maxHealth, String name) {
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
}
