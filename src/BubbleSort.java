import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int index = 0 ; index < dataList.size() -1 ; index ++){
            boolean swap = false;
            for(int index2 = 0 ; index2 < dataList.size() -1 - index; index2++){
                if(dataList.get(index2) >  dataList.get(index2 + 1)){
                    Collections.swap(dataList,index2,index2 + 1);
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }

        return dataList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ; i++){
            dataList.add((int)(Math.random() * 100) + 1);
        }

        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort(dataList);

        System.out.println(dataList.toString());

    }




}
