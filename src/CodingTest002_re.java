import java.util.Scanner;

public class CodingTest002_re {

    /* 2.평균구하기 , 백준온라인 저지 :1546번  */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1) N 개의 과목수 입력 받기

        int[] A = new int[N]; // 2) N 의 길이 만큼의 int 형 배열 생성 및 초기화

        for(int i = 0 ; i < N ; i++){  // 3) 배열의 길이 만큼 , 점수 입력 받을수 있도록 반복문 작성
            A[i] = sc.nextInt();
        }

        long max = 0;
        long sum = 0;

        for(int i = 0 ; i < N ; i++){ // 4) 배열의 길이 만큼 , 점수 입력 받을수 있도록 반복문 작성
            if(max < A[i]) max = A[i];
            sum += A[i];
        }

        // ( A/M * 100 + B/M * 100 + C/M * 100) / 3
        // ( A + B + C ) * 100 / M / 3
        System.out.println( sum * 100.0 / max / 3 );

    }

}
