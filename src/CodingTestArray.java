import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTestArray {


    public static void main(String[] args) {

        List<Integer> arrList = new ArrayList<>();

        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);

        System.out.println(arrList.toArray().toString());

        int[] arr = new int[]{0,1,2,3,4,5};
        int[] query = new int[]{4,1,2};

        for(int i = 0 ; i < query.length; i++){
            if(i % 2 == 0){
                arr = Arrays.copyOfRange(arr,0,query[i]+1);
            }else{
                arr = Arrays.copyOfRange(arr,query[i],arr.length);
            }
        }
    }

}
