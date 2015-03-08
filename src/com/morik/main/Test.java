package com.morik.main;

/**
 * Created by Morik on 01.03.2015.
 */
public class Test {
    public static void main(String[] args) {
        String[] fName = new String[20];
        int[] id = new int[20];
        String[] lName = new String[20];

        fName[0] = "Sergey";
        fName[1] = "Sergey";
        fName[2] = "Alex";

        lName[0] = "Morkotun";
        lName[1] = "Repch";
        lName[2] = "Bugan";

        id[0] = 1;
        id[1] = 2;
        id[2] = 3;

        int i = 1;
        System.out.println(id[i] + fName[i] + lName[i]);


    }
}
