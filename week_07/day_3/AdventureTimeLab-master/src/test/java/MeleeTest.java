import Characters.Melee.Barbarian;
import Characters.Melee.Knight;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MeleeTest {
    ArrayList<Weapon> weapons;
    Barbarian barbarian;
    Knight knight;
    Weapon sword;

    @Before
    public void before() {
        sword = new Weapon("Sword of Truth", 50);
        weapons = new ArrayList<>();
        weapons.add(sword);
        barbarian = new Barbarian("Wulfgar", 250, 200, weapons);
        knight = new Knight("Lancelot", 400, 200, weapons, 10);

    }

    @Test
    public void canAttack() {
        barbarian.attack(knight, sword);
        assertEquals(160, knight.getHealth());
        assertEquals(true, knight.isAlive());
    }

    @Test
    public void canKill() {
        barbarian.attack(knight, sword);
        barbarian.attack(knight, sword);
        assertEquals(false, knight.isAlive());
    }
}
