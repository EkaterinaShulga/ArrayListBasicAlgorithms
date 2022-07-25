import org.assertj.core.api.Assertions;
import org.example.MyArrayList;
import org.example.exceptions.MyArrayListIllegalArgumentException;
import org.example.exceptions.MyArrayListIndexOutException;
import org.junit.Test;


public class MyArrayListTest {


    private final MyArrayList<String> myArrayList = new MyArrayList<>();

    public MyArrayListTest() {
    }


    @Test
    public void addValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        String result = myArrayList.add("15");
        myArrayList.add("20");
        myArrayList.add("30");
        myArrayList.add("40");
        myArrayList.add("50");
        myArrayList.add("60");
        myArrayList.add("70");
        myArrayList.add("80");
        myArrayList.add("90");
        myArrayList.add("100");
        Assertions.assertThat(result).isEqualTo("15");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.add(null));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIndexOutException.class, () -> myArrayList.add("110"));
    }

    @Test
    public void addValueByIndex() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        String result = myArrayList.add(1, "20");
        myArrayList.add(2, "30");
        myArrayList.add(3, "10");
        Assertions.assertThat(result).isEqualTo("20");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.add(5, "17"));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.add(-1, "17"));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.add(1, "19"));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.add(4, null));
    }


    @Test
    public void setValueByIndex() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "30");
        myArrayList.add(1, "20");
        myArrayList.add(2, "30");
        myArrayList.add(3, "40");
        myArrayList.add(4, "50");
        myArrayList.add(5, "60");
        myArrayList.add(6, "70");
        myArrayList.add(7, "80");
        myArrayList.add(8, "90");
        String result = myArrayList.set(0, "10");
        Assertions.assertThat(result).isEqualTo("10");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.set(2, null));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.set(9, "50"));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.set(-2, "50"));

    }

    @Test
    public void removeValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        myArrayList.add(2, "30");
        String result = myArrayList.remove("20");
        Assertions.assertThat(result).isEqualTo("удалено значение 20");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.remove(null));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.remove("40"));

    }

    @Test
    public void removeValueByIndex() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        myArrayList.add(2, "30");
        String result = myArrayList.remove(2);
        Assertions.assertThat(result).isEqualTo("удалено значение 30");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.remove(3));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.remove(-1));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.remove(2));
    }


    @Test
    public void containsValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        Boolean result = myArrayList.contains("30");
        Boolean result2 = myArrayList.contains("10");
        Assertions.assertThat(result).isEqualTo(false);
        Assertions.assertThat(result2).isEqualTo(true);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.contains(null));
    }

    @Test
    public void indexValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        int result = myArrayList.indexOf("20");
        int result2 = myArrayList.indexOf("30");
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(result2).isEqualTo(-1);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.indexOf(null));
    }

    @Test
    public void lastIndexOfValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        int result = myArrayList.lastIndexOf("10");
        int result2 = myArrayList.lastIndexOf("30");
        Assertions.assertThat(result).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(-1);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.lastIndexOf(null));
    }

    @Test
    public void getValue() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        String result = myArrayList.get(1);
        Assertions.assertThat(result).isEqualTo("20");
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.get(4));
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.get(-3));
    }

    @Test
    public void equalsListsNegative() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        MyArrayList<String> list = new MyArrayList<>(10);

        list.add(0, "30");
        list.add(1, "30");
        myArrayList.add(0, "30");
        myArrayList.add(1, "20");
        myArrayList.add(2, "40");
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(false);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.equals(null));
    }
    @Test
    public void equalsListsNegativeContent() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        MyArrayList<String> list = new MyArrayList<>(10);

        list.add(0, "1");
        list.add(1, "20");
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(false);
        org.junit.jupiter.api.Assertions.assertThrows(MyArrayListIllegalArgumentException.class, () -> myArrayList.equals(null));
    }
    @Test
    public void equalsListsPositive() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        MyArrayList<String> list = new MyArrayList<>(10);

        list.add(0, "10");
        list.add(1, "20");
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        boolean result = myArrayList.equals(list);
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    public void sizeValues() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        int result = myArrayList.size();
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void isEmptyValues() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        boolean result = myArrayList.isEmpty();
        Assertions.assertThat(result).isEqualTo(true);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        boolean result2 = myArrayList.isEmpty();
        Assertions.assertThat(result2).isEqualTo(false);
    }

    @Test
    public void clearList() {
        MyArrayList<String> myArrayList = new MyArrayList<>(10);
        myArrayList.add(0, "10");
        myArrayList.add(1, "20");
        myArrayList.clear();
    }

    @Test
    public void newStringList() {
        MyArrayList<String> list = new MyArrayList<>(10);
        list.add(0, "10");
        list.add(1, "20");
        list.toArray();
    }
}
