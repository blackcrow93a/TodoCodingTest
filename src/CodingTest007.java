import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodingTest007 {

    /* 7. 주몽의 명령 - 배열 에서 투포인터를 활용한 문제 */
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int A[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 정렬

        int count = 0 ;
        int i = 0;
        int j = N - 1;

        while ( i < j ){
            int sum = A[i] + A[j];

            if( sum < M ){
                i++;
            }else if(sum > M){
                j--;
            }else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
    
}
