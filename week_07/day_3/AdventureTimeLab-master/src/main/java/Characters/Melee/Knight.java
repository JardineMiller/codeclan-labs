package Characters.Melee;
import Weapons.Weapon;

import java.util.ArrayList;

public class Knight extends Melee {

    private double armour;

    public Knight(String name, int maxHealth, int power, ArrayList<Weapon> weapons, double armour) {
        super(name, maxHealth, power, weapons);
        this.armour = armour;
    }

    public void takeDamage(int amount) {
        this.health -= (amount - armour);
    }
}
