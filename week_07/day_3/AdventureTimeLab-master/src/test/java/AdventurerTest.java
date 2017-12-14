import Characters.Behaviours.ICast;
import Characters.Casters.Cleric;
import Characters.Casters.Summoner;
import Characters.Melee.Barbarian;
import Characters.Melee.Dwarf;
import Characters.Melee.Knight;
import Spells.Spell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdventurerTest {

    ArrayList<ICast> spells;


    Cleric cleric;
    Summoner summoner;
    Barbarian barbarian;
    Dwarf dwarf;
    Knight knight;

    @Before
    public void before() {
        spells = new ArrayList<>();
        Spell spell = new Spell("Fireball", 100);
        spells.add(spell);
        cleric = new Cleric("Justicar", 200, 200, spells);
    }

    @Test
    public void getHealth() {
        assertEquals(200, cleric.getHealth());
    }


    @Test
    public void getPower() {
        assertEquals(200, cleric.getPower());
    }

    @Test
    public void getPurse() {
        assertEquals(0, cleric.getPurse());;
    }

    @Test
    public void increasePurse() {
        cleric.increasePurse(5);
        assertEquals(5, cleric.getPurse());
    }

    @Test
    public void increaseHealth() {
        cleric.takeDamage(10);
        cleric.increaseHealth(5);
        assertEquals(195, cleric.getHealth());
    }

    @Test
    public void takeDamage() {
        cleric.takeDamage(5);
        assertEquals(195, cleric.getHealth());
    }

    @Test
    public void isAlive() {
        assertEquals(true, cleric.isAlive());
    }



}
