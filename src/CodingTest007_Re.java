import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest007_Re {

    /* 7. 주몽의 명령 - 배열 에서 투포인터를 활용한 문제 */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 재료의 개수
        int M = sc.nextInt(); // 갑옷이 완성되는 번호의합

        int A[] = new int[N]; // 재료의 정보 초기화 및 삽입

        for(int i = 0 ; i < N; i++){
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); // 배열 정렬하기

        int count = 0;
        int i = 0 ;
        int j = N - 1;

        while ( i < j) {
            if( A[i] + A[j] < M){
                i++;
            }else if(A[i] + A[j] > M){
                j--;
            }else{
                count++;
                i++;
                j--;
            }

        }
        System.out.println(count);

    }
    
}
