package com.arkhipov.model;

public class DroidLifeStealer extends Droid{
    public DroidLifeStealer(String name,int damage,int health,int coolDown,int currentCoolDown){
        super(name,damage,health,coolDown,currentCoolDown);
    }
    public int droidTurn(Droid enemyDroid){
        enemyDroid.health -=this.damage;
        this.health+=5;
        return this.damage;
    }
}
