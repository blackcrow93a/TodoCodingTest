import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodingTest003 {

    /* 3. 구간 합 구하기 , 백준 온라인 저지 : 11659 */
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[suNo + 1]; // 1) 구간합을 구하기 위한 배열 생성 , N + 1 의 배열 초기화 ( 0 인덱스는 어차피 없는값 ?)

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 1 ; i <= suNo ; i++){ // 2) 합 배열 공식 : S[i] = S[i - 1] + A[i]
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q = 0 ; q < quizNo; q++){ // 3) 구간 합 공식 : S[j] - S[i-1]
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

    }
}
