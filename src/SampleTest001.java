import java.util.ArrayList;
import java.util.List;

public class SampleTest001 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2, 5, 3}).toString());
    }

    public static int[] solution(int[] arr) {

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < arr.length; i++){
            if(list.size() == 0) {
                list.add(arr[i]);
            }else{
                if(list.get(list.size()-1) < arr[i]){
                    list.add(arr[i]);
                }else if(list.get(list.size()-1) >= arr[i]){
                    list.remove(list.size()-1);
                }
            }
        }

        int[] stk = new int[list.size()];

        for(int i = 0 ; i < stk.length; i++){
            stk[i] = list.get(i);
        }

        return stk;
    }






}
