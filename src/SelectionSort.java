import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        int lowest;

        for(int index = 0 ; index < dataList.size(); index++){
            lowest = index;
            for( int index2 = index + 1 ; index2 < dataList.size(); index2++){

                if(dataList.get(lowest) > dataList.get(index2)){
                    lowest = index2;
                }

                Collections.swap(dataList,lowest,index);
            }

        }

        return dataList;
    }

}
