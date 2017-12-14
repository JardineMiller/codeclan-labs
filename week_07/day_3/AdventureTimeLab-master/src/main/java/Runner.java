import Characters.Adventurer;
import Characters.Behaviours.ICast;
import Rooms.Room;
import Weapons.*;
import Spells.*;
import Characters.Melee.*;
import Characters.Casters.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Runner {




    public static void main(String[] args) {
        Spell fireball = new Spell("Fireball", 50);
        Spell lightning = new Spell("Lightning Bolt", 45);
        ArrayList<ICast> summonerSpells = new ArrayList<>();
        summonerSpells.add(fireball);
        summonerSpells.add(lightning);

        Spell bless = new Spell("Bless", 50);
        ArrayList<ICast> clericSpells = new ArrayList<>();
        clericSpells.add(bless);

        Weapon sword = new Weapon("Sword", 25);
        Weapon club = new Weapon("Club", 5);
        Weapon axe = new Weapon("Axe", 30);
        Weapon hammer = new Weapon("Hammer", 35);
        Weapon zweihander = new Weapon("Zweihander", 35);
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(sword);
        weapons.add(axe);
        weapons.add(hammer);
        weapons.add(zweihander);

        Enemy troll;
        Enemy ogre;

        ogre = new Enemy("Ogre", 600, 30,  weapons, club, 200);
        troll = new Enemy("Troll", 800, 40, weapons, club, 200);

        ArrayList<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(ogre);
        room1Enemies.add(troll);

        ArrayList<Adventurer> players = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // game.createPlayers(num)
        int playerCount = 1;
        for (int x = 0; x < 2; x++) {

            System.out.println(String.format("Player %s, what is your name?", playerCount));
            String name = scanner.nextLine();
            playerCount++;

            ArrayList<String> chars;
            chars = new ArrayList<>();
            chars.add("1 Cleric \n");
            chars.add("2 Summoner \n");
            chars.add("3 Knight \n");
            chars.add("4 Barbarian \n");
            chars.add("5 Dwarf \n");

            System.out.println("Please choose a class:");
            System.out.println(String.join("", chars));
            String i = scanner.nextLine();



            switch (i) {
                case "1":
                    Cleric newCleric = new Cleric(name, 500, 50, clericSpells);
                    players.add(newCleric);
                    break;

                case "2":
                    Summoner newSummoner = new Summoner(name, 400, 50, summonerSpells);
                    players.add(newSummoner);
                    break;

                case "3":
                    Knight newKnight = new Knight(name, 400, 50, weapons, 20);
                    players.add(newKnight);
                    break;

                case "4":
                    Barbarian newBarbarian = new Barbarian(name, 400, 50, weapons);
                    players.add(newBarbarian);
                    break;

                case "5":
                    Dwarf newDwarf = new Dwarf(name, 400, 50, weapons);
                    players.add(newDwarf);
                    break;
            }

        }

        Room room1 = new Room("Spooky Library", players, room1Enemies);
        room1.setRoomTreasure();

        ArrayList<String> monsters = new ArrayList<>();
        ArrayList<String> heroes = new ArrayList<>();
        ArrayList<String> weaponsnames = new ArrayList<>();
        ArrayList<String> clericSpellNames = new ArrayList<>();
        ArrayList<String> summonerSpellNames = new ArrayList<>();

        int count = 1;
        for(Enemy enemy : room1.getEnemies()){
            monsters.add(String.format("%s %s - %shp \n", count, enemy.getName(), enemy.getHealth() ) );
            count++;
        }

        int heroCount = 1;
        for(Adventurer hero : room1.getHeroes()){
            heroes.add(String.format("%s %s - %shp \n", heroCount, hero.getName(), hero.getHealth() ) );
            heroCount++;
        }

        int countweapons = 1;
        for(Weapon weapon: weapons){
            weaponsnames.add(String.format("%s %s \n", countweapons, weapon.getName() ) );
            countweapons++;
        }

        int clericSpellCount = 1;
        for(ICast spell: clericSpells){
            clericSpellNames.add(String.format("%s %s \n", clericSpellCount, ((Spell) spell).getName()) );
            clericSpellCount++;
        }

        int summonerSpellCount = 1;
        for(ICast spell: summonerSpells){
            summonerSpellNames.add(String.format("%s %s \n", summonerSpellCount, ((Spell) spell).getName()) );
            summonerSpellCount++;
        }

        // Players Turns
        for(Adventurer player : room1.getHeroes()) {
            if (player instanceof Melee) {
                System.out.println(player.getName() + ": Who do you want to attack?");
                System.out.println(String.join("", monsters)); // Replace with game.printEnemies(room)
                String target = scanner.nextLine();
                int targetnum = parseInt(target) - 1;
                System.out.println(player.getName() + ": What weapon do you want to use?");
                System.out.println(String.join("", weaponsnames));
                String weaponchoice = scanner.nextLine();
                int weaponnum = parseInt(weaponchoice) - 1;
                Enemy targetEnemy = room1.getEnemies().get(targetnum);
                ((Melee) player).attack(targetEnemy, ((Melee) player).getWeapons().get(weaponnum));
                if(targetEnemy.isAlive()) {
                    System.out.println(targetEnemy.getName() + " has " + targetEnemy.getHealth() + "hp remaining");
                } else {
                    System.out.println(targetEnemy.getName() + " is dead!");
                    room1.removeDead();
                }
            }
            if (player instanceof Cleric) {
                System.out.println(player.getName() + ": Who do you want to heal?");
                System.out.println(String.join("", heroes));
                String target = scanner.nextLine();
                int targetnum = parseInt(target) - 1;
                System.out.println(player.getName() + ": Which spell do you want to use?");
                System.out.println(String.join("", clericSpellNames));
                String spellChoice = scanner.nextLine();
                int spellChoiceNum = parseInt(spellChoice) - 1;
                ((Cleric) player).heal(room1.getHeroes().get(targetnum), ((Cleric) player).getSpells().get(spellChoiceNum));
            }
            if(player instanceof Summoner) {
                System.out.println(player.getName() + ": What do you want to do?");
                System.out.println("1 Attack\n2 Summon");
                String optionInput = scanner.nextLine();
                int optionNum = parseInt(optionInput);
                if (optionNum == 1) {
                    System.out.println(player.getName() + ": Who do you want to attack?");
                    System.out.println(String.join("", monsters));
                    String target = scanner.nextLine();
                    int targetnum = parseInt(target) - 1;
                    System.out.println(player.getName() + ": What spell would you like to cast?");
                    System.out.println(String.join("", summonerSpellNames));
                    String spellChoice = scanner.nextLine();
                    int spellNum = parseInt(spellChoice) - 1;
                    Enemy targetEnemy = room1.getEnemies().get(targetnum);
                    ((Summoner) player).attack(room1.getEnemies().get(targetnum), ((Summoner) player).getSpells().get(spellNum));
                    System.out.println(targetEnemy.getName() + " has " + targetEnemy.getHealth() + "hp remaining");
                    if(targetEnemy.isAlive()) {
                        System.out.println(targetEnemy.getName() + " has " + targetEnemy.getHealth() + "hp remaining");
                    } else {
                        System.out.println(targetEnemy.getName() + " is dead!");
                        room1.removeDead();
                    }
                }
                if (optionNum == 2) {
                    ((Summoner) player).summon();
                }

            }
        }

        System.out.println("\n Counter attack!!! \n");

        // Monsters turn
        for(Enemy enemy : room1.getEnemies()) {
            Collections.shuffle(room1.getHeroes());
            Adventurer target = room1.getHeroes().get(0);
            enemy.attack(target);
        }



    }


}
