package com.arkhipov.actions;

import com.arkhipov.model.*;

public class FightOfDuel extends Fight{
    private static Droid userDroid;//дроїд користувача
    private static Droid enemyDroid;//ворожий дроїд
    private Droid attacker;//дроїд нападника
    private Droid defender;//Дроїд захисника
    private  String firstDroidStr;
    private  String secondDroidStr;
    //конструктор по замовчуванню
    protected static int turnNumber;//номер ходу
    static {
        turnNumber=1;
    }
    public FightOfDuel(){

    }

    public  void setUserDroid(int numberOfDroid) {
        userDroid = getDroidFromList(numberOfDroid);
    }

    public  void setIsDroidsCreated(boolean isDroidsCreated) {
        this.isDroidsCreated = isDroidsCreated;
    }

    public  boolean isIsDroidsCreated() {
        return isDroidsCreated;
    }

    public  void setEnemyDroid(int numberOfDroid) {
        enemyDroid = getDroidFromList(numberOfDroid);
    }

    public static Droid getUserDroid() {
        return userDroid;
    }

    public static int nextTurn(){
        return turnNumber++;
    }

    public static Droid getEnemyDroid() {
        return enemyDroid;
    }
    //функція перевіряє чи дроїди готові до двобою
    @Override
    public boolean isDroidsReady() {
        if(!(new FightOfDuel().isIsDroidsCreated())){
            System.out.println("\n\t\t!!!Firstly create droids!!!");
            return false;
        } else if(FightOfDuel.getUserDroid().isAlive() == false || FightOfDuel.getEnemyDroid().isAlive()==false) {
            System.out.println("\n\t\t!!!Create new droids,one of them died!!!\n");
            return false;
        }
        return true;
    }
    //функція встановлює опонентів
    public void setOpponents()  {
        if(userAttack()){
            attacker = userDroid;
            defender = enemyDroid;
            firstDroidStr = "Your droid - ";
            secondDroidStr = "Enemy droid -";
        }else{
            attacker = enemyDroid;
            defender = userDroid;
            firstDroidStr = "Enemy droid -";
            secondDroidStr = "Your droid - ";
        }
    }
    //функція міняє нападника та ціль
    public void switchOpponents(){
        Droid current = this.attacker;
        this.attacker =this.defender;
        this.defender = current;
        String currentStr = firstDroidStr;
        firstDroidStr = secondDroidStr;
        secondDroidStr = currentStr;
    }
    //початок двобою
    public void startFight(){
        setOpponents();
       // String userDroidStr = "Your droid - ";
      //  String enemyDroidStr = "Enemy droid -";
        System.out.println("\t\t LET'S FIGHT!!!");
        do{
            turnInstruction(attacker, defender,firstDroidStr,secondDroidStr);
            switchOpponents();
            System.out.println("раунд:" +nextTurn());
        }while(attacker.isAlive() && defender.isAlive());
        outWinnerAndLoser();
    }
    //виконання усіх дій для ходу дроїда
    public void turnInstruction(Droid firstDroid, Droid secondDroid, String userDroidStr, String enemyDroidStr){
        int damage;
        int currentFirstCoolDown=firstDroid.getCurrentCoolDown()+1;
        int currentSecondCoolDown=secondDroid.getCurrentCoolDown()+1;
            if(firstDroid.isReady()) {
                damage=firstDroid.droidTurn(secondDroid);
                DroidTurnInfo(firstDroid,secondDroid,damage,userDroidStr,enemyDroidStr);
                firstDroid.setCurrentCoolDown(0);
            }
            else{
                System.out.println(userDroidStr+firstDroid.getName() + " NOT READY");
            }
        firstDroid.setCurrentCoolDown(currentFirstCoolDown);
        secondDroid.setCurrentCoolDown(currentSecondCoolDown);
    }
    //вивід інформації ходу
    void DroidTurnInfo(Droid firstDroid,Droid secondDroid,int damage,String firstDroidStr,String secondDroidStr){
        System.out.println(firstDroidStr+" "+firstDroid.getName()+" Наносить " + damage+ " шкоди "+ secondDroidStr+ secondDroid.getName());
        System.out.println(secondDroidStr+" "+secondDroid.getHealth() + " здоров'я у " + secondDroid.getName());
    }
    //вивід результату двобою
    public void outWinnerAndLoser(){
        if(userDroid.isAlive()){
            System.out.println("\nYour droid won!Congratulation!!!");
        }else{
            System.out.println("\nYour droid lost...");
        }
    }
}
