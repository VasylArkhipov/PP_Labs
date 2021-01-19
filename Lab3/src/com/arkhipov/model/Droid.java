package com.arkhipov.model;


abstract public class Droid {
    protected String name;//назва дроїда
    protected int damage;//шкода дроїда
    protected int health;//кількість здоров'я дроїда
    protected int coolDown;//скільки потрібно чекати перед атакою дроїда
    protected int currentCoolDown;
    public Droid(String name,int damage,int health,int coolDown,int currentCoolDown){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coolDown = coolDown;
        this.currentCoolDown = currentCoolDown;
    }

    public int getCurrentCoolDown() {
        return currentCoolDown;
    }

    public void setCurrentCoolDown(int currentCoolDown) {
        this.currentCoolDown = currentCoolDown;
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

    public int getCoolDown(){
        return coolDown;
    }

    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", health=" + health +
                ", coolDown=" + coolDown +
                '}';
    }


    //перевірка чи дроїд досі живий
    public boolean isAlive(){
        return this.health>0;
    }
    //перевірка чи дроїд готовий атакувати
    public boolean isReady(){
        return this.currentCoolDown>=this.coolDown;
    }
    //хід дроїда
    public abstract int droidTurn(Droid enemyDroid);
}
