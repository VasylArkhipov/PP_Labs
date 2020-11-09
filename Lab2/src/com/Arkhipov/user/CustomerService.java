package com.Arkhipov.user;

import java.util.ArrayList;

public class CustomerService {
    //перевірка на іменна
    public static boolean isEqualsName(ArrayList<Customer> customerArrayList, String name){
        boolean isName = false;
        for(Customer currentCustomer: customerArrayList){
            if(currentCustomer.getName().equals(name)){
                System.out.println(currentCustomer.toString());
                isName=true;
            }
        }
        return isName;
    }
    //перевірка інтервалу
    public static boolean isCardNumberInterval(ArrayList<Customer> customerArrayList,int start,int end){
        boolean isInterval = false;
        for(Customer currentCustomer: customerArrayList){
            if(Integer.parseInt(currentCustomer.getCardNumber())>start && Integer.parseInt(currentCustomer.getCardNumber())<end){
                System.out.println(currentCustomer.toString());
                isInterval = true;
            }
        }
        return isInterval;
    }
    //пошук боржників
    public static void debtorCustomer(ArrayList<Customer> customerArrayList){
        System.out.println("\n\t\tDebtors:\n");
        for(Customer currentCustomer: customerArrayList){
            if(Integer.parseInt(currentCustomer.getBalance())<0){
                System.out.println(currentCustomer.toString());
            }
        }
    }
}
