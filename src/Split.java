import java.util.ArrayList;
import java.util.Arrays;

public class Split {

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr= new ArrayList<Integer>(dataList.subList(0,medium));
        rightArr = new ArrayList<Integer>(dataList.subList(medium,dataList.size()));

        return mergeFunc(leftArr,rightArr);
    }

    public ArrayList<Integer> mergeFunc( ArrayList<Integer> leftList , ArrayList<Integer> rightList){

        ArrayList<Integer> mergdList = new ArrayList<Integer>();

        int leftPoint = 0;
        int rightPoint = 0;

        // CASE 1 : left / right 둘다 있을때
        while( leftList.size() > leftPoint && rightList.size() > rightPoint ){
            if(leftList.get(leftPoint) > rightList.get(rightPoint)){
                mergdList.add(rightList.get(rightPoint));
                rightPoint++;
            }else{
                mergdList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE 2 : right 데이터가 없을때
        while( leftList.size() > leftPoint){
            mergdList.add(leftList.get(leftPoint));
            leftPoint++;
        }
        // CASE 3 : left 데이터가 없을때

         while( rightList.size() > rightPoint){
            mergdList.add(rightList.get(rightPoint));
            rightPoint++;
        }

         return mergdList;
    }

    public static void main(String[] args) {

        Split split = new Split();


    }




}
