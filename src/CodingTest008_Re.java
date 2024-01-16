import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest008_Re {

    /* 8. 좋은수 구하기 [핵심] - 투 포인터 알고리즘 이동원칙 ★ */

    // 1) A[i] + A[j] > K : j--;
    // 2) A[i] + A[j] < K : i++;
    // 3) A[i] + A[j] == K : i++; j--; count++;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 수의 개수

        int reuslt = 0;

        int A[] = new int[N]; // 배열 초기화 및 삽입

        for(int i = 0 ; i < N ; i++){
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); // 정렬

        int count = 0 ;

        for(int k = 0 ; k < N ; k++){

            long find = A[k];
            int i = 0 ;
            int j = N - 1;

            while ( i < j) {

                if( A[i] + A[j] == find ){
                    if( i != k && j != k){
                        reuslt++;
                        break;
                    }else if( i == k){
                        i++;
                    }else if( j == k){
                        j--;
                    }
                }else if( A[i] + A[j]  > find){
                    j--;
                }else{
                    i++;
                }

            }
        }
        System.out.println(reuslt);
    }

}
