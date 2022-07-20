package org.example;

import org.example.interfaces.StringList;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<String>(10);
        System.out.println("add---------------------------------------------------");
        System.out.println(myArrayList.add("15"));
        System.out.println(myArrayList);
        System.out.println();

        System.out.println("add(index)---------------------------------------------------");
        myArrayList.add(1, "20");
        myArrayList.add(2, "30");
        myArrayList.add(3, "40");
        myArrayList.add(4, "50");
        myArrayList.add(5, "60");
        myArrayList.add(6, "70");
        myArrayList.add(7, "80");
        myArrayList.add(8, "80");
        myArrayList.add(9, "90");
        System.out.println(myArrayList);
        System.out.println();


        System.out.println("set---------------------------------------------------");
        System.out.println(myArrayList.set(0, "10"));
        System.out.println(myArrayList);
        System.out.println();


        System.out.println("remove(item)---------------------------------------------------");
        System.out.println(myArrayList.remove("80"));
        System.out.println(myArrayList);
        System.out.println();

        System.out.println("remove(index)---------------------------------------------------");
        System.out.println(myArrayList.remove(3));
        System.out.println(myArrayList);
        System.out.println(myArrayList.remove(5));
        System.out.println(myArrayList);
        System.out.println();


        System.out.println("contains---------------------------------------------------");
        System.out.println(myArrayList.contains("90"));
        System.out.println();

        System.out.println("indexOf---------------------------------------------------");
        System.out.println(myArrayList.indexOf("90"));
        System.out.println();

        System.out.println("lastIndexOf---------------------------------------------------");
        System.out.println(myArrayList.lastIndexOf("90"));
        System.out.println();

        System.out.println("get---------------------------------------------------");
        System.out.println(myArrayList.get(1));
        System.out.println();


        System.out.println("equals---------------------------------------------------");
        StringList otherList = new MyArrayList<String>() {
        };
        otherList.add(0, "10");
        otherList.add(1, "20");
        otherList.add(2, "30");
        otherList.add(3, "50");
        otherList.add(4, "60");
        otherList.add(5, "80");


        System.out.println(myArrayList);
        System.out.println(otherList);
        System.out.println(myArrayList.equals(otherList));
        System.out.println();


        System.out.println("size---------------------------------------------------");
        System.out.println(myArrayList.size());
        System.out.println();

        System.out.println("isEmpty---------------------------------------------------");
        System.out.println(myArrayList.isEmpty());
        System.out.println();

        System.out.println();
        System.out.println("clear---------------------------------------------------");
        myArrayList.clear();
        System.out.println(myArrayList);
        System.out.println();

        System.out.println("myArrayList.toArray---------------------------------------------------");
        System.out.println(Arrays.toString(myArrayList.toArray()));


    }
}
