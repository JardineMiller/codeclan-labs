import Characters.Adventurer;
import Characters.Behaviours.ICast;
import Characters.Casters.Cleric;
import Characters.Casters.Summoner;
import Characters.Melee.Barbarian;
import Characters.Melee.Enemy;
import Characters.Melee.Knight;
import Rooms.Room;
import Spells.Spell;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoomTest {
    ArrayList<Weapon> weapons;
    ArrayList<ICast> spells;
    ArrayList<Adventurer> heroes;
    ArrayList<Enemy> enemies;
    Spell fireball;
    Spell bolt;
    Spell bless;
    Barbarian barbarian;
    Knight knight;
    Summoner wizard;
    Enemy troll;
    Enemy ogre;
    Weapon sword;
    Weapon zveihander;
    Cleric cleric;
    Room room;

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
        heroes = new ArrayList<>();
        enemies = new ArrayList<>();
        ogre = new Enemy("Ogre", 600, 30,  weapons, sword, 200);
        troll = new Enemy("Troll", 800, 40, weapons, sword, 200);
        enemies.add(ogre);
        enemies.add(troll);
        heroes.add(cleric);
        heroes.add(barbarian);
        heroes.add(wizard);
        heroes.add(knight);
        room = new Room("Spooky Library", heroes, enemies);
    }


    @Test
    public void playersAndEnemiesInRoom(){
        assertEquals(2, room.enemyCount());
        assertEquals(4, room.heroCount());
    }

    @Test
    public void canSetRoomTreasure(){
        room.setRoomTreasure();
        assertEquals(400, room.getLoot());
    }

    @Test
    public void canDistributeLoot(){
        room.setRoomTreasure();
        room.distributeLoot();
        assertEquals(100, wizard.getPurse());
    }

    @Test
    public void canRemoveDeadEnemy(){
        knight.attack(ogre, zveihander);
        knight.attack(ogre, zveihander);
        room.removeDead();
        assertEquals(1, room.enemyCount());
    }

}
