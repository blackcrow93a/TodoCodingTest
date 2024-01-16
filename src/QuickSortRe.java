import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortRe {

    public void splitFunc(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return;
        }

        int pivot = dataList.get(0);

        ArrayList<Integer> leftArry = new ArrayList<Integer>();
        ArrayList<Integer> rightArry = new ArrayList<Integer>();

        for(int i = 1; i < dataList.size();i++){
            if(dataList.get(i) > pivot){
                rightArry.add(dataList.get(i));
            }else{
                leftArry.add(dataList.get(i));
            }
        }

        ArrayList<Integer> mergerArr = new ArrayList<Integer>();

        mergerArr.addAll(leftArry);
        mergerArr.addAll(Arrays.asList(pivot));
        mergerArr.addAll(rightArry);

        System.out.println(mergerArr);
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,1,2,5,7));

        QuickSortRe quickSortRe = new QuickSortRe();

        quickSortRe.splitFunc(list);
    }



}
