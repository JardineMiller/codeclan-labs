package Characters.Melee;

import Characters.Adventurer;
import Characters.Casters.Summoner;
import Weapons.Weapon;

import java.util.ArrayList;

public class Enemy extends Melee {

    private Weapon weapon;

    public Enemy(String name, int maxHealth, int power, ArrayList<Weapon> weapons, Weapon weapon, int purse) {
        super(name, maxHealth, power, weapons);
        this.weapon = weapon;
        this.purse = purse;
    }

    public void attack(Adventurer target) {
        int damage = this.weapon.getDmgModifier() + this.getPower();
        target.takeDamage(damage);
        if(target instanceof Summoner) {
            if (((Summoner) target).hasPet()) {
                System.out.println(getName() + " thumps " + target.getName() + "'s  pet, " + ((Summoner) target).getPet().getName() + " with a " + weapon.getName().toLowerCase() + " for " + damage + " damage.");
                System.out.println(((Summoner) target).getPet().getName() + " has " + ((Summoner) target).getPet().getHealth() + "hp remaining.");
            } else {
                System.out.println(getName() + " thumps " + target.getName() + " with a " + weapon.getName().toLowerCase() + " for " + damage + " damage.");
                System.out.println(target.getName() + " has " + target.getHealth() + "hp remaining.");
            }
        } else {
            System.out.println(getName() + " thumps " + target.getName() + " with a " + weapon.getName().toLowerCase() + " for " + damage + " damage.");
            System.out.println(target.getName() + " has " + target.getHealth() + "hp remaining.");
        }
    }

}
