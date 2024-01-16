import java.util.ArrayList;
import java.util.Arrays;

public class SampleArray0116 {

    public void splitFunc(ArrayList<Integer> dataList){

        if(dataList.size() <=1){
            return;
        }else{

            int medium = dataList.size() / 2;

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            leftArr = new ArrayList<Integer>(dataList.subList(0,medium));
            rightArr = new ArrayList<Integer>(dataList.subList(medium,dataList.size()));

            System.out.println(leftArr);
            System.out.println(rightArr);

        }

    }

    public static void main(String[] args) {
        SampleArray0116 sampleArray0116 = new SampleArray0116();
        sampleArray0116.splitFunc(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
    }


}
