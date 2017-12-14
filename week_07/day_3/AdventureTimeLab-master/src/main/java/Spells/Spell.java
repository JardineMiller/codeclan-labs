package Spells;

import Characters.Behaviours.ICast;

public class Spell implements ICast {
    protected String name;
    protected int spellModifier;

    public Spell(String name, int spellModifier) {
        this.name = name;
        this.spellModifier = spellModifier;
    }

    public String getName() {
        return name;
    }

    public int getSpellModifier() {
        return spellModifier;
    }
}
