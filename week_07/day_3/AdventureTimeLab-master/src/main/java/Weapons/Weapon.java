package Weapons;

import Characters.Behaviours.IAttack;

public class Weapon implements IAttack{

    protected String name;
    protected int dmgModifier;

    public Weapon(String name, int dmgModifier) {
        this.name = name;
        this.dmgModifier = dmgModifier;
    }

    public String getName() {
        return name;
    }

    public int getDmgModifier() {
        return dmgModifier;
    }
}
