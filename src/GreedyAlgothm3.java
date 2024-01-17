import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgothm3 {

   public void knapsackFunc(Integer[][] objectList , double capacity){

       double totalValue = 0.0;
       double fraction = 0.0;

       Arrays.sort(objectList, new Comparator<Integer[]>() {
           @Override
           public int compare(Integer[] o1, Integer[] o2) {
               return (o2[1]/o2[0]) - (o1[1]/o1[0]);
           }
       });

       for(int index = 0 ; index < objectList.length; index++){
           if((capacity) - (double)objectList[index][0] > 0){ // 무게당 가치가 가장 놓을상태
               capacity -= (double)objectList[index][0];
               totalValue += (double)objectList[index][1];
               System.out.println("무게 : " + objectList[index][0] + ", 가치 :" + objectList[index][1]);
           }else{
               fraction = capacity / (double)objectList[index][0];
               totalValue += (double)objectList[index][1] * fraction;
               System.out.println("무게 : " + objectList[index][0] + ", 가치 :" + objectList[index][1] + ", 비율 : " + fraction);
               break;
           }
       }

       System.out.println("총 담을수 있는 가치 : " + totalValue);

   }

    public static void main(String[] args) {

       GreedyAlgothm3 greedyAlgothm3 = new GreedyAlgothm3();

       Integer[][] objectList = {{10,10},{15,12},{20,10},{25,8},{30,5}};

       greedyAlgothm3.knapsackFunc(objectList,30.0);

    }


}
