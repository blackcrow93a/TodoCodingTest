import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {


    public void coinFunc(Integer price , ArrayList<Integer> coinList){

        Integer totalCoinCount = 0;
        Integer coinNum = 0;

        for(int i = 0; i < coinList.size(); i++){
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            System.out.println(coinList.get(i) + " 원 , " + coinNum);
        }

        System.out.println("총 동전 갯수 : " + totalCoinCount);

    }

    public void knapsackFunc(Integer[][] objectList , double capacity){

       double totalValue = 0.0;
       double flaction = 0.0;

       Arrays.sort(objectList, new Comparator<Integer[]>() {
           @Override
           public int compare(Integer[] o1, Integer[] o2) {
               return (o2[0]/o1[1]) - (o1[1]/o1[0]);
           }
       });

       for(int index = 0 ; index < objectList.length; index++){
           if((capacity - (double)objectList[index][0] > 0 )){
               capacity -= (double)objectList[index][0];
               totalValue += (double)objectList[index][1];
               System.out.println("무게 :" + objectList[index][0] + ", 가치 :" + objectList[index][1] );
           }else{
               flaction = capacity / (double) objectList[index][0];
               totalValue += (double)objectList[index][1] * flaction;
               System.out.println("무게 : " + objectList[index][0] + ", 가치 : " + objectList[index][1] + "비율 : " + flaction);
           }
       }

        System.out.println(totalValue);

    }









    public static void main(String[] args) {

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();

        greedyAlgorithm.coinFunc(4720,new ArrayList<Integer>(Arrays.asList(500,100,50,1)));

        // 배열 정렬

        Integer[] arrays = new Integer[]{1,10,3,5};
        Arrays.sort(arrays);

        Integer[][] objectList = {{10,10},{15,12},{20,10},{25,8},{30,5}};

        greedyAlgorithm.knapsackFunc(objectList,30.0);

    }



}
