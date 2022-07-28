package org.example;

public class FindFastestSort {

    public void generateArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
    }

    public long calculateBubbleSortingTime(Integer[] arr) {
        long start = System.currentTimeMillis();
        doBubbleSorting(arr);
        long l = System.currentTimeMillis() - start;
        return l;
    }

    public long calculateSortingTimeChoice(Integer[] arr) {
        long start = System.currentTimeMillis();
        doSortingChoice(arr);
        long l = System.currentTimeMillis() - start;
        return l;
    }


    public long calculateInsertionSortTime(Integer[] arr) {
        long start = System.currentTimeMillis();
        doSortingInsertion(arr);
        long l = System.currentTimeMillis() - start;
        return l;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int num = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = num;
    }

    private void doBubbleSorting(Integer[] arr) {
        generateArray(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }


    }

    private void doSortingChoice(Integer[] arr) {
        generateArray(arr);
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swapElements(arr, i, min);
        }
    }

    private void doSortingInsertion(Integer[] arr) {
        generateArray(arr);
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = arr[current];
        }
    }
}
