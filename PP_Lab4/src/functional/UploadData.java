package functional;

import type.Coffee;

public class UploadData {
    public static void uploadAllData(){
        Coffee.setCurrentContent(null);
        System.out.println("The van is empty...");
    }
}
