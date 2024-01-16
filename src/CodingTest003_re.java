import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest003_re {

    /* 3. 구간 합 구하기 , 백준 온라인 저지 : 11659 */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1. 데이터의 개수
        int M = sc.nextInt(); // 2. 질의 개수

        int S[] = new int[N+1]; // 3. 합 배열 변수 초기화

        for(int i = 1 ; i <= N ; i++ ){
            S[i] = S[i-1] + sc.nextInt();
        }

        for(int m = 0 ; m < M ; m++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(S[j] - S[i-1]);
        }

    }
}
