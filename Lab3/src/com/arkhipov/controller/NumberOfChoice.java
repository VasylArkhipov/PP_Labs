package com.arkhipov.controller;

import com.arkhipov.actions.Fight;
import com.arkhipov.actions.FightOfDuel;
import com.arkhipov.actions.FightOfTeams;
import com.arkhipov.model.Droid;

import java.util.List;
import java.util.Scanner;
//перечислення для вибору конкретного вибору користувача
public enum NumberOfChoice implements Choiceable{
    FIRST_CHOICE{
        //функція створює дроїдів для двобою
        public void actingUserChoice(){
            Fight.outInfoAboutDroids();
            int numberOfUserDroid,numberOfEnemyDroid;

            System.out.print("\tChoose your droid :");
            Scanner scannerForDroidChoice=new Scanner(System.in);
            numberOfUserDroid= scannerForDroidChoice.nextInt();
            System.out.print("\n\tChoose enemy droid :");
            numberOfEnemyDroid = scannerForDroidChoice.nextInt();
            if(numberOfEnemyDroid>4 || numberOfEnemyDroid<1 || numberOfUserDroid>4 || numberOfUserDroid<1){
                System.out.println("\n\t\tWRONG INPUT!!!");
                return;
            }
            FightOfDuel fightOfDuel = new FightOfDuel();
            fightOfDuel.setUserDroid(numberOfUserDroid-1);
            fightOfDuel.setEnemyDroid(numberOfEnemyDroid-1);
            fightOfDuel.setIsDroidsCreated(true);
        }
    },
    SECOND_CHOICE{
        //функція створює дроїдів для битви команд
        public void actingUserChoice(){
            Fight.outInfoAboutDroids();
            System.out.println("\tChoose your team :");
            FightOfTeams fightOfTeams = new FightOfTeams();
            List<Droid> currentList=fightOfTeams.currentSelectedTeam(fightOfTeams.getUserTeam());
            if(currentList==null){
                return;
            }
            fightOfTeams.setUserTeam(currentList);
            System.out.println("\tChoose enemy team :");
            fightOfTeams.setEnemyTeam(fightOfTeams.currentSelectedTeam(fightOfTeams.getEnemyTeam()));
        }
    },
    THIRD_CHOICE{
        //функція виводить створених дроїдів для двобою
        public void actingUserChoice(){
            FightOfDuel fightOfDuel = new FightOfDuel();
            if(fightOfDuel.isDroidsReady()){
                System.out.println("\nYour droid - " + fightOfDuel.getUserDroid());
                System.out.println("Enemy droid - " + fightOfDuel.getEnemyDroid());
            }
        }
    },
    FORTH_CHOICE{
        //функція виводить усіх дроїдів для команд двох команд
        public void actingUserChoice(){
            if(new FightOfTeams().isDroidsReady()) {
                System.out.println("\t\tYour team :");
                outDroidsList(FightOfTeams.getUserTeam());
                System.out.println("\t\tEnemy team :");
                outDroidsList(FightOfTeams.getEnemyTeam());
            }
        }
        //функція виводить усіх дроїдів для певної команди
        public void outDroidsList(List<Droid> currentTeam){
            for(Droid currentDroid : currentTeam){
                System.out.println(currentDroid);
            }
        }
    },
    FIFTH_CHOICE{
        //функція розпочинає двобій
        public void actingUserChoice(){
            FightOfDuel fightOfDuel = new FightOfDuel();
            if(fightOfDuel.isDroidsReady()) {
                fightOfDuel.startFight();
            }
        }
    },
    SIXTH_CHOICE{
        //функція розпочинає бій команд
        public void actingUserChoice(){
            FightOfTeams fightOfTeams = new FightOfTeams();
            if(fightOfTeams.isDroidsReady()) {
                fightOfTeams.startFight();
            }
        }
    };
}
