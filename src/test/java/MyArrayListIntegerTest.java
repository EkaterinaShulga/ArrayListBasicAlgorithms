import org.assertj.core.api.Assertions;
import org.example.MyArrayListInteger;
import org.example.exceptions.MyArrayListIllegalArgumentException;
import org.junit.Test;

public class MyArrayListIntegerTest {


    private final MyArrayListInteger myArrayListInteger = new MyArrayListInteger();

    public MyArrayListIntegerTest() {
    }

    @Test
    public void addValue() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        Integer result = myArrayListInt.add(15);
        myArrayListInt.add(20);
        myArrayListInt.add(30);
        myArrayListInt.add(40);
        myArrayListInt.add(50);
        myArrayListInt.add(60);
        myArrayListInt.add(70);
        myArrayListInt.add(80);
        myArrayListInt.add(90);
        myArrayListInt.add(100);
        Integer result2 = myArrayListInt.add(200);
        Assertions.assertThat(result).isEqualTo(15);
        Assertions.assertThat(result2).isEqualTo(200);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.add(null));
    }

    @Test
    public void addValueByIndex() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        Integer result = myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        myArrayListInt.add(2, 30);
        myArrayListInt.add(3, 40);
        myArrayListInt.add(4, 50);
        myArrayListInt.add(5, 60);
        myArrayListInt.add(6, 70);
        myArrayListInt.add(7, 80);
        myArrayListInt.add(8, 90);
        myArrayListInt.add(9, 100);
        myArrayListInt.add(10, 100);
        myArrayListInt.add(11, 100);
        Integer result2 = myArrayListInt.add(10, 100);
        Integer result3 = myArrayListInt.add(3, 5);
        Assertions.assertThat(result).isEqualTo(10);
        Assertions.assertThat(result2).isEqualTo(100);
        Assertions.assertThat(result3).isEqualTo(5);


    }

    @Test
    public void growArrayLength() {
        MyArrayListInteger list = new MyArrayListInteger(3);
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        Integer result = list.add(3, 50);
        Assertions.assertThat(result).isEqualTo(50);
    }

    @Test
    public void addValueByIndexNegative() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 20);
        myArrayListInt.add(1, 30);
        myArrayListInt.add(2, 40);
        Integer result = myArrayListInt.add(0, 10);
        Assertions.assertThat(result).isEqualTo(10);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.add(7, 50));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.add(-1, 17));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.add(3, null));
    }

    @Test
    public void setValueByIndex() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 30);
        myArrayListInt.add(1, 20);
        myArrayListInt.add(2, 30);
        myArrayListInt.add(3, 40);
        myArrayListInt.add(4, 50);
        myArrayListInt.add(5, 60);
        myArrayListInt.add(6, 70);
        myArrayListInt.add(7, 80);
        myArrayListInt.add(8, 90);
        Integer result = myArrayListInt.set(0, 10);
        Assertions.assertThat(result).isEqualTo(10);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.set(2, null));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.set(9, 50));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.set(-2, 50));

    }

    @Test
    public void removeValue() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        myArrayListInt.add(2, 30);
        Integer result = myArrayListInt.remove("20");
        Assertions.assertThat(result).isEqualTo(20);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.remove(null));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.remove("40"));

    }

    @Test
    public void removeValueByIndex() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        myArrayListInt.add(2, 30);
        Integer result = myArrayListInt.remove(2);
        Assertions.assertThat(result).isEqualTo(30);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.remove(3));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.remove(-1));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.remove(2));
    }

    @Test
    public void containsNumber() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 40);
        myArrayListInt.add(1, 20);
        myArrayListInt.add(2, 80);
        myArrayListInt.add(3, 30);
        myArrayListInt.add(4, 50);
        boolean result = myArrayListInt.contains(30);
        boolean result2 = myArrayListInt.contains(10);
        Assertions.assertThat(result).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(false);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.contains(null));


    }

    @Test
    public void indexValue() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        int result = myArrayListInt.indexOf(20);
        int result2 = myArrayListInt.indexOf(30);
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(result2).isEqualTo(-1);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.indexOf(null));
    }

    @Test
    public void lastIndexOfValue() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        int result = myArrayListInt.lastIndexOf(10);
        int result2 = myArrayListInt.lastIndexOf(30);
        Assertions.assertThat(result).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(-1);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.lastIndexOf(null));
    }

    @Test
    public void getValue() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        Integer result = myArrayListInt.get(1);
        Assertions.assertThat(result).isEqualTo(20);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.get(4));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayListInt.get(-3));
    }

    @Test
    public void equalsListsNegative() {
        MyArrayListInteger myArrayList = new MyArrayListInteger(10);
        MyArrayListInteger list = new MyArrayListInteger(10);

        list.add(0, 30);
        list.add(1, 30);
        myArrayList.add(0, 30);
        myArrayList.add(1, 20);
        myArrayList.add(2, 40);
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(false);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.equals(null));
    }

    @Test
    public void equalsListsNegativeContent() {
        MyArrayListInteger myArrayList = new MyArrayListInteger(10);
        MyArrayListInteger list = new MyArrayListInteger(10);

        list.add(0, 1);
        list.add(1, 20);
        myArrayList.add(0, 10);
        myArrayList.add(1, 20);
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(false);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.equals(null));
    }

    @Test
    public void equalsListsPositive() {
        MyArrayListInteger myArrayList = new MyArrayListInteger(10);
        MyArrayListInteger list = new MyArrayListInteger(10);

        list.add(0, 10);
        list.add(1, 20);
        myArrayList.add(0, 10);
        myArrayList.add(1, 20);
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    public void sizeValues() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        int result = myArrayListInt.size();
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void isEmptyValues() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        boolean result = myArrayListInt.isEmpty();
        Assertions.assertThat(result).isEqualTo(true);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        boolean result2 = myArrayListInt.isEmpty();
        Assertions.assertThat(result2).isEqualTo(false);
    }

    @Test
    public void clearList() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        myArrayListInt.add(0, 10);
        myArrayListInt.add(1, 20);
        myArrayListInt.clear();
    }

    @Test
    public void newIntegerList() {
        MyArrayListInteger listInt = new MyArrayListInteger(10);
        listInt.add(0, 10);
        listInt.add(1, 20);
        listInt.toArray();
    }

    @Test
    public void quickSortArray() {
        MyArrayListInteger myArrayListInt = new MyArrayListInteger(10);
        Integer[] num = new Integer[]{3, 6, 2, 7, 0};
        Integer[] result = myArrayListInt.doQuickSort(num, 0, num.length - 1);
        Integer[] result2 = new Integer[]{0, 2, 3, 6, 7};
        Assertions.assertThat(result).isEqualTo(result2);
    }

}