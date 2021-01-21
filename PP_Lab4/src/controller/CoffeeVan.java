package controller;

import functional.*;
import type.Coffee;

import java.util.List;

public class CoffeeVan {
     public void outMenu(){
         System.out.println("1 - Download van." +
                 "\n2 - Upload van." +
                 "\n3 - Show content information." +
                 "\n4 - Sorted product" +
                 "\n5 - Find the product by quality range." +
                 "\n6 - Exit");
     }
     public void download(){
         System.out.println("downloading...");
         String fileName = "D:\\Learning\\PP_Labs\\PP_Lab4\\src\\functional\\content.txt";
         DataForCoffee.getDataFromFile(fileName);
     }
     public void upload(){
         System.out.println("uploading....");
         UploadData.uploadAllData();
     }
     public void outContent(){
         System.out.println("outputting...");
         List<Coffee> content = Coffee.getCurrentContent();
         OutDataForCoffee.outData(content);
     }
     public void sort(){
         System.out.println("sorting...");
         List<Coffee> sortCoffeeList = Coffee.getCurrentContent();
         SortDataForCoffee.sortData(sortCoffeeList);
         OutDataForCoffee.outData(sortCoffeeList);
     }
     public void search(){
         System.out.println("searching...");
         List<Coffee> coffeeList = Coffee.getCurrentContent();
         SearchDataForCoffee.searchData(coffeeList);
         List<Coffee> byRange = Coffee.getContentInformation();
         OutDataForCoffee.outData(byRange);
     }
     public void exit(){
         System.exit(0);
     }
}
