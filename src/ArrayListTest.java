import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList.toString());

        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.remove(0));

    }

}
