package com.Arkhipov;

import com.Arkhipov.user.*;

import java.util.ArrayList;
import java.util.Scanner;


public class CustomerDemo {

    public static void main(String[] args) {
        StartCustomerDemo();
    }

    public static void StartCustomerDemo(){
        Scanner scanner= new Scanner(System.in);
        ArrayList<Customer> customersArrayList = new ArrayList<Customer>();
        CustomerInfo.getFileCustomers(customersArrayList); //Створення об.
        CustomerInfo.outEqualsName(customersArrayList,scanner);//вивід списка покупців з заданим імененм
        CustomerInfo.outInterval(customersArrayList,scanner);//вивід списка покупців з інтервалом номера картки
        CustomerService.debtorCustomer(customersArrayList);// вивід боржників
        scanner.close();
    }
}

