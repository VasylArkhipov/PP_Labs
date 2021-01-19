package com.arkhipov.model;

public enum Characteristic {
    SNIPER("Sniper",50,40,2,0),
    UNIVERSAL("Universal",30,100,1,0),
    VANGUARD("Vanguard",30,120,2,0),
    LIFE_STEALER("Life Stealer",20,90,1,0);
    private String name;
    private int damage;
    private int health;
    private int coolDown;
    private int currentCoolDown;
    Characteristic(String name, int damage, int health, int coolDown,int currentCoolDown) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coolDown = coolDown;
        this.currentCoolDown=currentCoolDown;
    }
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public int getCurrentCoolDown() {
        return currentCoolDown;
    }
}
