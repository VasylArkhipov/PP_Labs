package com.arkhipov.controller;
import java.util.Scanner;

import static com.arkhipov.controller.NumberOfChoice.*;

public class Menu {
    public static void startMenu(){
        menuInstruction();
    }
    public static void menuOptionsInfo(){
        System.out.println("\nType if you want to :");
        System.out.println("1:Create droids for a duel.\n2:Create droids for team fight.\n3:Show list of droids for duel.");
        System.out.println("4:Show list of teams\n5:Start duel.\n6:Start team fight.\n7:Exit.");
    }
    public static int userChoice(){
        int numOfUser;
        Scanner scannerOfNum = new Scanner(System.in);
        System.out.print("Type:");
        numOfUser=scannerOfNum.nextInt();
      //  scannerOfNum.close();
        return numOfUser;
    }
    //функція яка контролює весь процес меню та бою
    public static void menuInstruction(){
        int currentChoice;
        NumberOfChoice[] numberOfChoice = {FIRST_CHOICE,SECOND_CHOICE,THIRD_CHOICE,FORTH_CHOICE,FIFTH_CHOICE,SIXTH_CHOICE};
        while (true) {
            menuOptionsInfo();
            currentChoice = userChoice();
            if(currentChoice==7){
                break;
            }else if(currentChoice<0 || currentChoice>7){
                System.out.println("\n\t\t !!!WRONG INPUT!!!");
            }else {
                numberOfChoice[currentChoice - 1].actingUserChoice();
            }
        }
        System.out.print("See you soon!!!");
    }
}
