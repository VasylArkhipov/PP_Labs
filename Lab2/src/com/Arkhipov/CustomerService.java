package com.Arkhipov;

import com.Arkhipov.user.Customer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerService {

    public static void main(String[] args) {
        StartCustomerDemo();
    }

    public static void StartCustomerDemo(){
        Scanner scanner= new Scanner(System.in);
        ArrayList<Customer> customersArrayList = new ArrayList<Customer>();
        CustomerInfo.getFileCustomers(customersArrayList); //Створення об.
        CustomerInfo.outEqualsName(customersArrayList,scanner);//вивід списка покупців з заданим імененм
        CustomerInfo.outInterval(customersArrayList,scanner);//вивід списка покупців з інтервалом номера картки
        debtorCustomer(customersArrayList);// вивід боржників
        scanner.close();
    }

    //перевірка на іменна
    public static boolean isEqualsName(ArrayList<Customer> customerArrayList,String name){
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

