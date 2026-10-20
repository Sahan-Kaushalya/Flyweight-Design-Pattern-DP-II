package lk.kaushalya.model;

import java.util.ArrayList;

abstract class AbstractZombie {
    public abstract void displayInfo();
}

// Shared attributes for all zombies (Intrinsic)
class SharedZombie {

    private String type;
    private int attackPower;
    private String texture;

    public SharedZombie(String type, int attackPower, String texture) {

        this.type = type;
        this.attackPower = attackPower;
        this.texture = texture;
    }

    public String getType() {
        return type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getTexture() {
        return texture;
    }

}

// Unique attributes for each zombie (Extrinsic)
class Zombie extends AbstractZombie{

    private int x;
    private int y;
    private int health;

    private SharedZombie sharedZombie;

    public Zombie(String type, int attackPower, String texture,int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.sharedZombie = SharedZombiePool.getZombie(type,attackPower,texture);
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("Zombie Type: "+this.sharedZombie.getType());
        System.out.println("Zombie Attack Power: "+this.sharedZombie.getAttackPower());
        System.out.println("Zombie Texture: "+this.sharedZombie.getTexture());
        System.out.println("Zombie X: "+this.x);
        System.out.println("Zombie Y: "+this.y);
        System.out.println("Zombie Health: "+this.health);
        System.out.println("Shared Zombie Object: "+this.sharedZombie);
        System.out.println("-----------------------------------");
    }
}

class SharedZombiePool{

    private static final ArrayList<SharedZombie> sharedZombieArrayList = new ArrayList<>();

    public static SharedZombie getZombie(String type, int attackPower, String texture){

        SharedZombie sharedZombie = null;

        for(SharedZombie zombieItem : sharedZombieArrayList){
            if(zombieItem.getType().equals(type) && zombieItem.getAttackPower() == attackPower && zombieItem.getTexture().equals(texture)){
                sharedZombie = zombieItem;
                break;
            }
        }

        if(sharedZombie == null){
            sharedZombie = new SharedZombie(type, attackPower, texture);
            sharedZombieArrayList.add(sharedZombie);
        }

        System.out.println("Shared Zombie Pool ArrayList Size: "+SharedZombiePool.sharedZombieArrayList.size());
        return sharedZombie;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("Testing Flyweight Design Pattern");
        System.out.println();
        System.out.println("Creating Zombies...");
        System.out.println();

        Zombie zombie1 = new Zombie("Ice Zombie", 10, "Blue", 250, 250, 100);
        Zombie zombie2 = new Zombie("Fire Zombie", 20, "Red", 500, 250, 100);
        Zombie zombie3 = new Zombie("Ice Zombie", 10, "Blue", 750, 250, 90);
        Zombie zombie4 = new Zombie("Ice Zombie", 10, "Blue", 750, 250, 100);

        zombie1.displayInfo();
        zombie2.displayInfo();
        zombie3.displayInfo();
        zombie4.displayInfo();

        System.out.println("Testing Complete");


    }
}
