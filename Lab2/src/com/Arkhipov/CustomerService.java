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
//клас з вводом та виводом інформації покупця
class CustomerInfo{
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
    public static void outEqualsName(ArrayList<Customer> customersArrayList,Scanner scanName){
        System.out.println("Type Name:");
        boolean isName=false;
        if(isName=CustomerService.isEqualsName(customersArrayList,scanName.nextLine())!=true){
            System.out.println("Customers with this name not found");
        }
    }
    public static void outInterval(ArrayList<Customer> customersArrayList,Scanner scanInterval){
        System.out.println("\nType start and end of interval card number :");
        boolean isInterval=false;
        if(isInterval=CustomerService.isCardNumberInterval(customersArrayList,scanInterval.nextInt(),scanInterval.nextInt())!=true){
            System.out.println("Customers with this card number interval not found");
        }
    }
}
