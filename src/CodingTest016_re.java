import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CodingTest016_re {

    /* 16. 버블소트 프로그램 1  */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        mData[] A = new mData[N];

        for(int i = 0 ; i < N ; i++){
            A[i] = new mData(Integer.parseInt(br.readLine()),i);
        }

        Arrays.sort(A);

        int Max = 0 ;

        for(int i = 0 ; i < N; i++){

            if(Max < A[i].index -1){
                Max = A[i].index - i;
            }

        }
        System.out.println(Max + 1);
    }

    static class mData implements Comparable<mData>{

        int value;
        int index;

        public mData(int value , int index){
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }



}
