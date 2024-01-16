import java.util.ArrayList;

// 대표적인 정렬 알고리즘 : 병합정렬
public class MergeSort {

    // 1) Split 기능을 하는 함수 : 재귀함수 구현
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){

        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArray = new ArrayList<Integer>();
        ArrayList<Integer> rightArray = new ArrayList<Integer>();

        leftArray = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0,medium)));
        rightArray =this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium,dataList.size())));

        return this.mergeFunc(leftArray,rightArray);
    }

    // 2) Merge 기능을 하는 함수
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArrayList , ArrayList<Integer> rightArrayList){

        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE 1: left/right 둘 다 있을때
        while (leftArrayList.size() > leftPoint && rightArrayList.size() > rightPoint){
            if(leftArrayList.get(leftPoint) > rightArrayList.get(rightPoint)){
                mergedList.add(rightArrayList.get(rightPoint));
                rightPoint += 1;
            }else{
                mergedList.add(leftArrayList.get(leftPoint));
                leftPoint += 1;
            }
        }
        // CASE 2: right 데이터가 없을떄
        while ( leftArrayList.size() > leftPoint){
            mergedList.add(leftArrayList.get(leftPoint));
            leftPoint += 1;
        }
        // CASE 3: left 데이터가 없을때
        while ( rightArrayList.size() > rightPoint){
            mergedList.add(rightArrayList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;

    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        ArrayList<Integer> sampleData = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ; i++){
           sampleData.add((int)(Math.random() * 100));
        }

        System.out.println(mergeSort.mergeSplitFunc(sampleData));

    }


}
