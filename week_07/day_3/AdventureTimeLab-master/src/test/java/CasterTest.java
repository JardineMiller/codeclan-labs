import Characters.Behaviours.ICast;
import Characters.Casters.Cleric;
import Characters.Casters.Summoner;
import Characters.Melee.Barbarian;
import Characters.Melee.Knight;
import Spells.Spell;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CasterTest {
    ArrayList<Weapon> weapons;
    ArrayList<ICast> spells;
    Spell fireball;
    Spell bolt;
    Spell bless;
    Barbarian barbarian;
    Knight knight;
    Summoner wizard;
    Weapon sword;
    Weapon zveihander;
    Cleric cleric;

    @Before
    public void before() {
        sword = new Weapon("Sword of Truth", 50);
        zveihander = new Weapon("Zveihander", 150);
        fireball = new Spell("Fireball", 100);
        bolt = new Spell("Bolt", 90);
        bless = new Spell("Bless", 100);
        weapons = new ArrayList<>();
        spells = new ArrayList<>();
        weapons.add(sword);
        weapons.add(zveihander);
        spells.add(fireball);
        spells.add(bolt);
        spells.add(bless);
        barbarian = new Barbarian("Wulfgar", 250, 200, weapons);
        knight = new Knight("Lancelot", 400, 200, weapons, 10);
        wizard = new Summoner("Fiztrix", 175, 200, spells);
        cleric = new Cleric("Justicar", 200, 200, spells);

    }

    @Test
    public void canAttack() {
        wizard.attack(knight, fireball);
        assertEquals(110, knight.getHealth());
        assertEquals(true, knight.isAlive());
    }

    @Test
    public void canKill() {
        wizard.attack(knight, fireball);
        wizard.attack(knight, fireball);
        assertEquals(false, knight.isAlive());
    }

    @Test
    public void canHeal() {
        wizard.attack(knight, fireball);
        assertEquals(110, knight.getHealth());
        cleric.heal(knight, bless);
        assertEquals(400, knight.getHealth());
    }

    @Test
    public void canSummonMinion() {
        wizard.summon();
        assertEquals(true, wizard.hasPet());
    }

    @Test
    public void petTakesDamage() {
        wizard.summon();
        barbarian.attack(wizard, sword);
        assertEquals(false, wizard.hasPet());
        assertEquals(175, wizard.getHealth());
    }
}
