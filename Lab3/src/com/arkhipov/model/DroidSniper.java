package com.arkhipov.model;

public class DroidSniper extends Droid{
    public DroidSniper(String name,int damage,int health,int coolDown,int currentCoolDown){
        super(name,damage,health,coolDown,currentCoolDown);
    }
    public int droidTurn(Droid enemyDroid){
        enemyDroid.health -=this.damage;
        return this.damage;
    }
}
