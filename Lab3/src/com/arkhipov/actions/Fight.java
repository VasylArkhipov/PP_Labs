package com.arkhipov.actions;

import com.arkhipov.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.arkhipov.model.Characteristic.*;

public abstract class Fight {
    protected static boolean isDroidsCreated;//змінна для перевірки чи створені дроїди

    public static List<Droid> allDroidLists(){
        List<Droid> allDroidList=new ArrayList<>();
        allDroidList.add(new DroidSniper(SNIPER.getName(), SNIPER.getDamage(), SNIPER.getHealth(), SNIPER.getCoolDown(), SNIPER.getCurrentCoolDown()));
        allDroidList.add(new DroidUniversal(UNIVERSAL.getName(), UNIVERSAL.getDamage(), UNIVERSAL.getHealth(), UNIVERSAL.getCoolDown(), UNIVERSAL.getCurrentCoolDown()));
        allDroidList.add(new DroidVanguard(VANGUARD.getName(), VANGUARD.getDamage(), VANGUARD.getHealth(), VANGUARD.getCoolDown(), VANGUARD.getCurrentCoolDown()));
        allDroidList.add(new DroidLifeStealer(LIFE_STEALER.getName(),LIFE_STEALER.getDamage(),LIFE_STEALER.getHealth(),LIFE_STEALER.getCoolDown(),LIFE_STEALER.getCurrentCoolDown()));
        return allDroidList;
    }

    public static void outInfoAboutDroids(){
        System.out.println("\tDroids: \n" +
                "\t\t1 - " + SNIPER.getName()+
                "\n\t\t2 - " + UNIVERSAL.getName()+
                "\n\t\t3 - " + VANGUARD.getName()+
                "\n\t\t4 - " + LIFE_STEALER.getName());
    }
    public static Droid getDroidFromList(int numberOfDroid){
        return allDroidLists().get(numberOfDroid);
    }
    public boolean userAttack(){
        return new Random().nextBoolean();
    }
    public abstract boolean isDroidsReady();
    public abstract void outWinnerAndLoser();
    public abstract void startFight();

}
