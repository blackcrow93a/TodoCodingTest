import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingTest015 {

    /* 15. 수 정렬하기 : 핵심알고리즘 ★ ( 버블 정렬 ) */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];

        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++ ){
                if(A[j] > A[j+1]){
                  int temp = A[j];
                  A[j] = A[j+1];
                  A[j+1] = temp;
                }
            }
        }

        for(int a : A){
            System.out.println(a);
        }

    }


}
