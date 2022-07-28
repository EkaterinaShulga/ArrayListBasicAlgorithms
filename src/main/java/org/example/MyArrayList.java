package org.example;

import org.example.exceptions.MyArrayListIllegalArgumentException;
import org.example.exceptions.MyArrayListIndexOutException;
import org.example.interfaces.StringList;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList implements StringList {

    private final String[] list;

    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new MyArrayListIllegalArgumentException("Размер массива <= 0");
        } else {
            list = new String[capacity];
        }
    }

    public MyArrayList() {
        list = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String add(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое значение null");
        }
        if (capacity >= list.length) {
            throw new MyArrayListIndexOutException("Все ячейки массива заполнены");
        }
        return list[capacity++] = item;
    }

    @Override
    public String add(int index, String item) {
        if (capacity>= list.length) {
            throw new MyArrayListIllegalArgumentException("список полон");
        }
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
         else if (item == null) {
            throw new MyArrayListIllegalArgumentException("переданное значение = null");
        }
        for (int i = capacity; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        capacity++;

        return item;

    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        if (index >= capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        } else {
            list[index] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int indexToDelete = -1;
        for (int i = 0; i < capacity; i++) {
            if (item.equals(list[i])) {
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
    public String remove(int index) {
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
        String result = "";
        if (index <= list.length) {
            if (list[index] != null) {
                result = list[index];
                list[index] = null;
                capacity--;
            } else {
                throw new MyArrayListIllegalArgumentException("ячейка не содержит данных");
            }
        }
        for (int j = 0; j < list.length - 1; j++) {
            if (j == index && j <= list.length - 1) {
                list[j] = list[index + 1];
                list[index + 1] = null;
                index++;
            }
        }
        return "удалено значение " + result;
    }


    @Override
    public boolean contains(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        for (int i = 0; i < capacity; i++) {
            if (item.equals(list[i])) {
                return true;
            }
        }
        return false;

    }

    @Override
    public int indexOf(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int result = -1;
        for (int i = 0; i < list.length; i++) {
            if (item.equals(list[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(String item) {
        if (Objects.isNull(item)) {
            throw new MyArrayListIllegalArgumentException("Передаваемое в список значение не должно быть null");
        }
        int result = -1;
        for (int i = list.length - 1; i >= 0; i--) {
            if (item.equals(list[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index > capacity) {
            throw new MyArrayListIllegalArgumentException("Индекс: " + index + ", " + "количество элементов в списке: " + capacity);
        }
        if (index < 0) {
            throw new MyArrayListIllegalArgumentException("Индекc должен быть больше 0");
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (Objects.isNull(otherList)) {
            throw new MyArrayListIllegalArgumentException("Передаваемый список не должен быть null");
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!list[i].equals(otherList.get(i))) {
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
            if (list[0] != null) {
                return false;
            }
        return true;

    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            list[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] toArray = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            toArray[i] = list[i];
        }
        System.out.println("создан новый массив");
        return toArray;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "list=" + Arrays.toString(list) +
                ", size=" + capacity +
                ", DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                '}';
    }


}
