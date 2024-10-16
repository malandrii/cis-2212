// Andrii Malakhovtsev
// Game Character Project

import java.util.Random;

public class GameCharacter {
    private String name;
    private double health;
    private double strength;
    private int agility;
    private int speed;
    private double defenceCoefficient;

    public GameCharacter(String name, double health, double strength, int agility, int speed) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.speed = speed;
        defenceCoefficient = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDefenceCoefficient() {
        return defenceCoefficient;
    }

    public void setDefenceCoefficient(double defenceСoefficient) {
        this.defenceCoefficient = defenceСoefficient;
    }

    public double attack() {
        Random rand = new Random();
        double damage = strength * rand.nextDouble(1, 2.5);
        printAttack(damage);
        return damage;
    }

    private void printAttack(double attack) {
        System.out.println(name + " attacked: " + attack + " damage");
    }

    public void defend(double damage) {
        Random rand = new Random();
        setDefenceCoefficient(rand.nextDouble(0, 0.3));
        health -= damage * (1 - defenceCoefficient);
    }

    public String toString(){
        return getName() + " Health: " + health + "\n";
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void printLifeStatus() {
        if (isDead()) {
            System.out.println(name + " is done... (" + health + " hp)");
        }
        else {
            System.out.println(name + " is fine! (" + health + " hp)");
        }
    }
}
