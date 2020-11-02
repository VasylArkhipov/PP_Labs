package com.Arkhipov;

import com.Arkhipov.user.Customer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerDemo {

    public static void main(String[] args) {
        StartCustomerDemo();
    }

    public static void StartCustomerDemo(){
        Scanner scanner= new Scanner(System.in);
        ArrayList<Customer> customersArrayList = new ArrayList<Customer>();
        getFileCustomers(customersArrayList);
        System.out.println("Type Name:");
        equalsName(customersArrayList,scanner.nextLine());
        System.out.println("\nType start and end of interval card number :");
        cardNumberInterval(customersArrayList,scanner.nextInt(),scanner.nextInt());
        debtorCustomer(customersArrayList);
        scanner.close();
    }

    //створення об'єктів та отримання стрічок з файлу
    public static ArrayList<Customer> getFileCustomers(ArrayList<Customer> customersArrayList){
        try {
            List<String> customersList = Files.readAllLines(Paths.get("D:\\Learning\\PP_Labs\\Lab2\\src\\Customers.txt"));
            for (String current :customersList){
                Customer currentCustomer = new Customer();
                String[] objectElem = current.split(",");
                currentCustomer.setId(objectElem[0]);
                currentCustomer.setName(objectElem[1]);
                currentCustomer.setSurname(objectElem[2]);
                currentCustomer.setPatronymic(objectElem[3]);
                currentCustomer.setAddress(objectElem[4]);
                currentCustomer.setCardNumber(objectElem[5]);
                currentCustomer.setBalance(objectElem[6]);
                customersArrayList.add(currentCustomer);
            }
        }catch(Exception ex){
            System.out.println("Файл не знайдено");
        }
        return customersArrayList;
    }
    //перевірка на іменна
    public static void equalsName(ArrayList<Customer> customerArrayList,String name){
        boolean isName = false;
        for(Customer currentCustomer: customerArrayList){
            if(currentCustomer.getName().equals(name)){
                outCustomerInfo(currentCustomer);
                isName=true;
            }
        }
        if(isName!=true){
            System.out.println("Customer with this name not found");
        }
    }
    //
    public static void cardNumberInterval(ArrayList<Customer> customerArrayList,int start,int end){
        boolean isInterval = false;
        for(Customer currentCustomer: customerArrayList){
            if(Integer.parseInt(currentCustomer.getCardNumber())>start && Integer.parseInt(currentCustomer.getCardNumber())<end){
                outCustomerInfo(currentCustomer);
                isInterval = true;
            }
        }
        if(isInterval !=true){
            System.out.println("Customers with this card interval not found");
        }
    }
    public static void debtorCustomer(ArrayList<Customer> customerArrayList){
        System.out.println("\n\t\tDebtors:\n");
        for(Customer currentCustomer: customerArrayList){
            if(Integer.parseInt(currentCustomer.getBalance())<0){
                outCustomerInfo(currentCustomer);
            }
        }
    }
    public static void outCustomerInfo(Customer currentCustomer){
        System.out.print(currentCustomer.getId()+",\t");
        System.out.print(currentCustomer.getName()+",\t");
        System.out.print(currentCustomer.getSurname()+",\t");
        System.out.print(currentCustomer.getPatronymic()+",\t");
        System.out.print(currentCustomer.getAddress()+",\t");
        System.out.print(currentCustomer.getCardNumber()+",\t");
        System.out.println(currentCustomer.getBalance()+".");
    }
}
