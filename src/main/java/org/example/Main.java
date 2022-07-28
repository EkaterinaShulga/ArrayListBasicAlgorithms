package org.example;

import org.example.interfaces.IntegerList;
import org.example.interfaces.StringList;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);
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
        StringList otherList = new MyArrayList();
        otherList.add(0, "00");
        otherList.add(1, "20");
        otherList.add(2, "30");
        otherList.add(3, "50");
        otherList.add(4, "60");
        otherList.add(5, "80");
        otherList.add(6, "90");


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


        System.out.println("===================================================================================");
        System.out.println();


        MyArrayListInteger listInt = new MyArrayListInteger(10);
        System.out.println("add---------------------------------------------------");
        System.out.println(listInt.add(15));
        System.out.println(listInt);
        System.out.println();

        System.out.println("add(index)---------------------------------------------------");
        listInt.add(1, 20);
        listInt.add(2, 30);
        listInt.add(3, 40);
        listInt.add(4, 50);
        listInt.add(5, 60);
        listInt.add(6, 70);
        listInt.add(7, 80);
        listInt.add(8, 80);
        listInt.add(9, 90);
        listInt.add(10, 100);
        listInt.add(11, 200);
        listInt.add(12, 300);
        System.out.println(listInt);
        System.out.println();


        System.out.println("set---------------------------------------------------");
        System.out.println(listInt.set(0, 10));
        System.out.println(listInt);
        System.out.println();

        System.out.println("remove(item)---------------------------------------------------");
        System.out.println(listInt.remove("20"));
        System.out.println(listInt);
        System.out.println();

        System.out.println("remove(index)---------------------------------------------------");
        System.out.println(listInt.remove(3));
        System.out.println(listInt);
        System.out.println(listInt.remove(5));
        System.out.println(listInt);
        System.out.println();

        System.out.println("contains---------------------------------------------------");
        System.out.println(listInt.contains(10));
        System.out.println();

        System.out.println("indexOf---------------------------------------------------");
        System.out.println(listInt.indexOf(90));
        System.out.println();

        System.out.println("lastIndexOf---------------------------------------------------");
        System.out.println(listInt.lastIndexOf(90));
        System.out.println();

        System.out.println("get---------------------------------------------------");
        System.out.println(listInt.get(1));
        System.out.println();

        System.out.println("equals---------------------------------------------------");
        IntegerList otherList2 = new MyArrayListInteger(10);
        otherList2.add(0, 0);
        otherList2.add(1, 30);
        otherList2.add(2, 40);
        otherList2.add(3, 60);
        otherList2.add(4, 70);
        otherList2.add(5, 80);
        otherList2.add(6, 90);
        System.out.println(listInt);
        System.out.println(otherList2);
        System.out.println(listInt.equals(otherList2));
        System.out.println();


        System.out.println("size---------------------------------------------------");
        System.out.println(listInt.size());
        System.out.println();

        System.out.println("isEmpty---------------------------------------------------");
        System.out.println(listInt.isEmpty());
        System.out.println();

        System.out.println();
        System.out.println("clear---------------------------------------------------");
        listInt.clear();
        System.out.println(listInt);
        System.out.println();

        System.out.println("listInt.toArray---------------------------------------------------");
        System.out.println(Arrays.toString(listInt.toArray()));
        System.out.println();


        System.out.println("doQuickSort---------------------------------------------------");
        MyArrayListInteger list = new MyArrayListInteger(10);
        Integer[] num = new Integer[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) Math.round(Math.random() * 50);
        }
        System.out.println(Arrays.toString(num));
        list.doQuickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));


        FindFastestSort fastestSort = new FindFastestSort();
        final Integer[] arr = new Integer[100_000];
        System.out.println("продлжительность пузырьковой сортировки - " + fastestSort.calculateBubbleSortingTime(arr));
        System.out.println("продолжительность  сортировки выбором -   " + fastestSort.calculateSortingTimeChoice(arr));
        System.out.println("продолжительность  сортировки вставкой -   " + fastestSort.calculateInsertionSortTime(arr));

    }
}
