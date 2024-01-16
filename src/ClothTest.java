import java.util.HashMap;
import java.util.Map;

public class ClothTest {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String,Integer> clothMap = new HashMap<String,Integer>();

        for(String[] cloth : clothes){
            if(clothMap.containsKey(cloth[1])){
                clothMap.put(cloth[1], clothMap.get(cloth[1]) + 1);
            }else{
                clothMap.put(cloth[1],1);
            }
        }

        for(String key : clothMap.keySet()){
            System.out.println( " key : " + key);
            System.out.println( " value : " + clothMap.get(key));
            answer *= clothMap.get(key) + 1;
        }

        System.out.println("answer :" + answer);
        return answer -1;
    }

    public static void main(String[] args) {

       ClothTest clothTest = new ClothTest();
       clothTest.solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}});
       clothTest.solution(new String[][]{{"crow_mask","face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}});

    }

}
