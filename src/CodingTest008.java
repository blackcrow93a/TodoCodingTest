import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodingTest008 {

    /* 8. 좋은수 구하기 [핵심] - 투 포인터 알고리즘 이동원칙 ★ */

    // 1) A[i] + A[j] > K : j--;
    // 2) A[i] + A[j] < K : i++;
    // 3) A[i] + A[j] == K : i++; j--; count++;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int Result = 0 ;
        long A[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for(int k = 0 ; k < N ; k++){

            long find = A[k];

            int i = 0;
            int j = N - 1;

            while (i < j){
                long sum  = A[i] + A[j];
                if(sum == find){
                    if( i != k && j != k){
                        Result++;
                        break;
                    }else if(i == k){
                        i++;
                    }else if( j == k){
                        j--;
                    }
                }else if(sum < find){
                    i++;
                }else {
                    j--;
                }


            }
        }

        System.out.println(Result);
        br.close();

    }

}
