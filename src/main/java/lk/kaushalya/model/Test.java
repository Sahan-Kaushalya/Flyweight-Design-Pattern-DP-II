package lk.kaushalya.model;

import java.util.ArrayList;

abstract class Zombie {
    public abstract void displayInfo();
}

// Shared attributes for all zombies (Intrinsic)
class SharedZombie extends Zombie{

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

    @Override
    public void displayInfo() {

    }
}

// Unique attributes for each zombie (Extrinsic)
class UniqueZombie{

    private int x;
    private int y;
    private int health;

    private Zombie zombie;

    public UniqueZombie(int x, int y, int health,Zombie zombie) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.zombie = zombie;
    }
}

class ZombiePool{

    private static final ArrayList<SharedZombie> sharedZombieArrayList = new ArrayList<>();

    public static Zombie getZombie(String type, int attackPower, String texture){

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
            return sharedZombie;
        }

        return sharedZombie;
    }
}

public class Test {
    public static void main(String[] args) {
//        Zombie zombie1 = new Zombie("Ice Zombie", 10, "Blue", 250, 250, 100);
//        Zombie zombie2 = new Zombie("Fire Zombie", 20, "Red", 500, 250, 100);
//        Zombie zombie3 = new Zombie("Ice Zombie", 10, "Blue", 750, 250, 90);
//        Zombie zombie4 = new Zombie("Ice Zombie", 10, "Blue", 750, 250, 100);


    }
}
