import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort{

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
        }

        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int i = 1 ; i < dataList.size(); i++){
            if(dataList.get(i) > pivot){
                rightArr.add(dataList.get(i));
            }else{
                leftArr.add(dataList.get(i));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
        QuickSort quickSortSplit = new QuickSort();
        quickSortSplit.sort(new ArrayList<Integer>(Arrays.asList(2,3,1,8,12,5,9)));
    }




}
