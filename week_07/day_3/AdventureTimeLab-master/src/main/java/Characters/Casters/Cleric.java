package Characters.Casters;

import Characters.Adventurer;
import Characters.Behaviours.ICast;
import Spells.Spell;

import java.util.ArrayList;

public class Cleric extends Adventurer{

    private ArrayList<ICast> spells;

    public Cleric(String name, int maxHealth, int power, ArrayList<ICast> spells) {
        super(name, maxHealth, power);
        this.spells = spells;
    }

    public ICast equipSpell(ICast spell) {
        int index = spells.indexOf(spell);
        return spells.get(index);
    }

    public ArrayList<ICast> getSpells() {
        return spells;
    }

    public void heal(Adventurer target, ICast spell) {
        ICast equippedSpell = equipSpell(spell);
        int health = equippedSpell.getSpellModifier() + this.getPower();
        target.increaseHealth(health);
        System.out.println(getName() + " " + ((Spell) spell).getName() + "es " + target.getName() + ", healing them for " + health + " hp.");
    }

}

