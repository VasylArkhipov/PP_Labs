package com.arkhipov.model;

public class DroidUniversal extends Droid{
    public DroidUniversal(String name,int damage,int health,int coolDown,int currentCoolDown){
        super(name,damage,health,coolDown,currentCoolDown);
    }
    public int droidTurn(Droid enemyDroid){
        enemyDroid.health -=this.damage;
        return this.damage;
    }
}
