package org.example;

import org.example.exceptions.MyArrayListIllegalArgumentException;
import org.example.interfaces.IntegerList;

import java.util.Arrays;
import java.util.Objects;


public class MyArrayListInteger implements IntegerList {


    private Integer[] listInt;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayListInteger(int capacity) {
        if (capacity <= 0) {
            throw new MyArrayListIllegalArgumentException("Размер массива <= 0");
        } else {
            listInt = new Integer[capacity];
        }
    }

    public MyArrayListInteger() {
        listInt = new Integer[DEFAULT_CAPACITY];
    }


    @Override
    public Integer add(Integer item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое значение null");
        }
        if (capacity >= listInt.length) {
            grow();
            listInt[capacity] = item;
            capacity++;
            return item;
        }
        listInt[capacity] = item;
        capacity++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("переданное значение = null");
        }
        if (capacity >= listInt.length) {
            grow();
            for (int i = capacity; i > index; i--) {
                listInt[i] = listInt[i - 1];
            }
            listInt[index] = item;
            capacity++;
            return item;
        } else {

            for (int i = capacity; i > index; i--) {
                listInt[i] = listInt[i - 1];
            }
            listInt[index] = item;
            capacity++;
        }
        return item;
    }

    private void grow() {
        int newCapacity = capacity + (capacity >> 1);
        Integer[] list = new Integer[newCapacity];
        System.arraycopy(listInt, 0, list, 0, listInt.length);
        this.listInt = list;
    }


    @Override
    public Integer set(int index, Integer item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        if (index >= capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        } else {
            listInt[index] = item;
        }
        return item;
    }

    @Override
    public Integer remove(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int indexToDelete = -1;
        for (int i = 0; i < capacity; i++) {
            if (Integer.valueOf(item).equals(listInt[i])) {
                indexToDelete = i;

                break;
            }
        }
        if (indexToDelete == -1) {
            throw new MyArrayListIllegalArgumentException("Элемент не найден");
        }

        return remove(indexToDelete);
    }


    @Override
    public Integer remove(int index) {
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
        Integer result = 0;
        if (index <= listInt.length) {
            if (listInt[index] != null) {
                result = listInt[index];
                listInt[index] = null;
                capacity--;
            } else {
                throw new MyArrayListIllegalArgumentException("ячейка не содержит данных");
            }
        }
        for (int j = 0; j < listInt.length - 1; j++) {
            if (j == index && j <= listInt.length - 1) {
                listInt[j] = listInt[index + 1];
                listInt[index + 1] = null;
                index++;
            }
        }
        return result;
    }

    private Integer[] doSortingInsertion() {
        for (int i = 1; i < capacity - 1; i++) {
            int current = listInt[i];
            int j = i;
            while (j > 0 && listInt[j - 1] > current) {
                listInt[j] = listInt[j - 1];
                j--;
            }
            listInt[j] = current;
        }
        return listInt;


    }

    private boolean doBinarySearch(Integer[] listInt, int element) {
        int min = 0;
        int max = listInt.length - 1;


        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == listInt[mid]) {
                return true;
            }
            if (element < listInt[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        return doBinarySearch(doSortingInsertion(), item);
    }


    @Override
    public int indexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int result = -1;
        for (int i = 0; i < listInt.length; i++) {
            if (item.equals(listInt[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int result = -1;
        for (int i = listInt.length - 1; i >= 0; i--) {
            if (item.equals(listInt[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
        return listInt[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (Objects.isNull(otherList)) {
            throw new MyArrayListIllegalArgumentException("Передаваемый список не должен быть null");
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!listInt[i].equals(otherList.get(i))) {
                return false;
            }

        }
        return true;
    }


    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        if (listInt[0] != null) {
            return false;
        }
        return true;

    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            listInt[i] = null;
        }
    }

    @Override
    public Integer[] toArray() {
        Integer[] toArray = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            toArray[i] = listInt[i];
        }
        System.out.println("создан новый массив");
        return toArray;
    }

    public Integer[] doQuickSort(Integer[] listInt, int start, int end) {
        if (start >= end) return listInt;
        int i = start;
        int j = end;
        int op = i - (i - j) / 2;
        while (i < j) {
            while ((i < op) && (listInt[i] <= listInt[op])) i++;
            while ((j > op) && (listInt[j] >= listInt[op])) j--;
            if (i < j) {
                int temp = listInt[i];
                listInt[i] = listInt[j];
                listInt[j] = temp;
                if (i == op) op = j;
                else if (j == op) op = i;
            }
        }
        doQuickSort(listInt, start, op);
        doQuickSort(listInt, op + 1, end);
        return listInt;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "listInt=" + Arrays.toString(listInt) +
                ", capacity=" + capacity +
                ", listInt.length =" + listInt.length +
                '}';
    }
}
