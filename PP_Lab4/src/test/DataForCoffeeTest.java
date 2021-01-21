package test;

import functional.DataForCoffee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import type.Coffee;

import java.util.ArrayList;
import java.util.List;

class DataForCoffeeTest {

    @Test
    void getDataFromFile() {
        Coffee coffee1 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee2 = new Coffee("sasss",1.3,30,130.6,"мелена");
        Coffee coffee3 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee4 = new Coffee("sasss",1.3,30,130.6,"мелена");
        Coffee coffee5 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee6 = new Coffee("sasss",1.3,30,130.6,"мелена");
        Coffee coffee7 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee8 = new Coffee("sasss",1.3,30,130.6,"мелена");
        Coffee coffee9 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee10 = new Coffee("sasss",1.3,30,130.6,"мелена");
        Coffee coffee11 = new Coffee("qweqwe",1.2,20,125.5,"зернова");
        Coffee coffee12 = new Coffee("sasss",1.3,30,130.6,"мелена");
        String fileName = "D:\\Learning\\PP_Labs\\PP_Lab4\\src\\functional\\content.txt";
        DataForCoffee.getDataFromFile(fileName);
        List<Coffee> expected = Coffee.getCurrentContent();
        List<Coffee> actual =new ArrayList<>();
        actual.add(coffee1);
        actual.add(coffee2);
        actual.add(coffee3);
        actual.add(coffee4);
        actual.add(coffee5);
        actual.add(coffee6);
        actual.add(coffee7);
        actual.add(coffee8);
        actual.add(coffee9);
        actual.add(coffee10);
        actual.add(coffee11);
        actual.add(coffee12);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void newCoffee() {

    }
}