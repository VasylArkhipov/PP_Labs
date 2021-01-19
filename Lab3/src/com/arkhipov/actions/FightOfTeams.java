package com.arkhipov.actions;

import com.arkhipov.model.Droid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FightOfTeams extends Fight{
    private static List<Droid> userTeam;//лист команди користувача
    private static List<Droid> enemyTeam;//лист команди суперника
    private static Droid currentAttacker;//тимчасовий нападник
    private static Droid currentTarget;//тимчасова ціль
    private static boolean isUserAttack;//змінна для перевірки чи користувач нападник

    public static void setCurrentAttacker(Droid currentAttacker) {
        FightOfTeams.currentAttacker = currentAttacker;
    }

    public static void setCurrentTarget(Droid currentTarget) {
        FightOfTeams.currentTarget = currentTarget;
    }

    public void setUserTeam(List<Droid> userTeam) {
        this.userTeam = userTeam;
    }

    public void setEnemyTeam(List<Droid> enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public static boolean isUserAttack() {
        return isUserAttack;
    }

    public static void setUserAttack(boolean userAttack) {
        isUserAttack = userAttack;
    }

    public static List<Droid> getUserTeam() {
        return userTeam;
    }
    //функція повертає ворожу команду
    public static List<Droid> getEnemyTeam() {
        return enemyTeam;
    }
    //перевірка чи команда створена
    public static boolean isTeamsCreated(){
        if(getUserTeam()==null || getEnemyTeam()==null){
            return false;
        }else {
            return true;
        }
    }
    //перевірка чи команда повна
    public static boolean isTeamFull(List<Droid> currentTeam){
        if(currentTeam.size()==0) {
            return false;
        }
        return true;
    }
    //перевірка готовності дроїдів
    @Override
    public boolean isDroidsReady() {
        if(!isTeamsCreated()){
            System.out.println("\n\t\t!!!FIRSTLY CREATE A TEAM!!!");
            return false;
        }else if(!isTeamFull(getUserTeam()) || !isTeamFull(getEnemyTeam())){
            System.out.println("\n\t\t!!!Your droids died,recreate a team!!!");
            return false;
        }
        return true;
    }
    //вибір дроїдів для користувача
    public static List<Droid> currentSelectedTeam(List<Droid> currentTeam){
        currentTeam = new ArrayList<>();
        Scanner scannerForDroidChoice = new Scanner(System.in);
        int numberOfDroid;
        for(int numberOfSelectedDroid=0;numberOfSelectedDroid<4;numberOfSelectedDroid++){

            System.out.printf("\n\t %d - ",(numberOfSelectedDroid+1));
            numberOfDroid=scannerForDroidChoice.nextInt();
            if(numberOfDroid>4 || numberOfDroid<1){
                System.out.println("\n\t\tWRONG INPUT");
                return null;
            }
            currentTeam.add(Fight.getDroidFromList((numberOfDroid-1)));

        }
        return currentTeam;
    }
    //вибір рандомного дроїда з списку дроїдів
    public void setOpponents(List<Droid> attackerList,List<Droid> targetList){
        int start = 0;
        int randomAttacker = start + (int) (Math.random() * attackerList.size());
        int randomTarget = (start + (int) (Math.random() * targetList.size()));
        setCurrentAttacker(attackerList.get(randomAttacker));
        setCurrentTarget(targetList.get(randomTarget));
    }
    //початок битви команд
    public void startFight(){
        setUserAttack(userAttack());
        String userTeamDroid = "Your droid - ";
        String enemyTeamDroid = "Enemy droid -";
        System.out.println("\n\t\t!!!Let's fight!!!");
        do{
            if(isUserAttack()){
                turnInstruction(userTeam,enemyTeam,userTeamDroid,enemyTeamDroid);
                setUserAttack(false);
            }else {
                turnInstruction(enemyTeam, userTeam, enemyTeamDroid, userTeamDroid);
                setUserAttack(true);
            }
        }while(userTeam.size()>0 && enemyTeam.size()>0);
        outWinnerAndLoser();
    }

    public void turnInstruction(List<Droid> attackerList,List<Droid> targetList,String userDroidStr,String enemyDroidStr){
        setOpponents(attackerList,targetList);
        int currentAttackerCoolDown=currentAttacker.getCurrentCoolDown()+1; // збільшуєм кд на 1 під час ходу
        int currentTargetCoolDown=currentTarget.getCurrentCoolDown()+1;
        if(currentAttacker.isReady()) {
            currentAttacker.droidTurn(currentTarget);
            if (!currentTarget.isAlive()) {
                System.out.printf("\n%s %s killed %s %s!", userDroidStr, currentAttacker.getName(), enemyDroidStr, currentTarget.getName());
                targetList.remove(currentTarget);
            }
        }
        currentAttacker.setCurrentCoolDown(currentAttackerCoolDown);
        currentTarget.setCurrentCoolDown(currentTargetCoolDown);
    }
    //вивід результатів бою
    public void outWinnerAndLoser(){
        if(userTeam.size()>0){
            System.out.println("\nYour team won!Congratulation!!!");
        }else{
            System.out.println("\nYour team lost...");
        }
    }
}
