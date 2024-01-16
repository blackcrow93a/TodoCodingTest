import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest004_re {

    /* 4. 구간합구하기 2 - 2차원 배열 사용  */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // 1. 2차원 배열의 크기 , 구간 합 질의의 개수

        int N = sc.nextInt();
        int M = sc.nextInt();

        int A[][] = new int[N + 1][N + 1]; // 2. 원본 배열 초기화 및 데이터 삽입

        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= N; j++){
                A[i][j] = sc.nextInt();
            }
        }

        int S[][] = new int[N+1][N+1]; // 3. 합 배열 초기화

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <=N ; j++){
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
            }
        }

        for(int i = 0 ; i < M; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 -1] + S[x1 -1][y1 - 1];
            System.out.println(result);
        }





















    }

}
