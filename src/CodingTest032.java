import java.util.Scanner;

public class CodingTest032 {

    /* 32. 동전 개수의 최솟값 구하기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전수
        int k = sc.nextInt(); // 목표금액
        int cointCnt = 0;

        int coin[] = new int[N];

        for(int i = 0 ; i < N ; i++){
            coin[i] = sc.nextInt();
        }

        for(int i = N - 1; i > 0 ; i--){
            if(coin[i] <= k ){
                cointCnt += ( k / coin[i]);
                k = k % coin[i];
            }
        }

        System.out.println(cointCnt);
    }
    
    
}
