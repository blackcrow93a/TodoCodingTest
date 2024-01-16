import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortAvatar {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
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

        mergerArr.addAll(this.sort(leftArry));
        mergerArr.addAll(Arrays.asList(pivot));
        mergerArr.addAll(this.sort(rightArry));

        return mergerArr;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,1,2,5,7));

        QuickSortAvatar quickSortAvatar = new QuickSortAvatar();

        quickSortAvatar.sort(list);
    }



}
