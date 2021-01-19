package com.arkhipov.model;

public class DroidVanguard extends Droid{
    public DroidVanguard(String name,int damage,int health,int coolDown, int currentCoolDown){
        super(name,damage,health,coolDown,currentCoolDown);
    }
    public int droidTurn(Droid enemyDroid){
        int criticalDamage=1,chance;
        chance=1 + (int)(Math.random()*100);
        if(chance<36) {
            criticalDamage*=2;
        }
        enemyDroid.health -= criticalDamage * this.damage;
        return criticalDamage * this.damage;
    }
}
