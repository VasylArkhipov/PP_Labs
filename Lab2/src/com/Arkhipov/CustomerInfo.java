package com.Arkhipov;
import com.Arkhipov.user.Customer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static void outEqualsName(ArrayList<Customer> customersArrayList, Scanner scanName){
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