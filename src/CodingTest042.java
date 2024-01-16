import java.util.Scanner;

public class CodingTest042 {

    /* 42. 최소 공배수 구하기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt(); // 테스트 케이스 개수

        for(int i = 0 ; i < P ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a,b);
            System.out.println(result);
        }

    }

    public static int gcd(int a , int b){
        if(b == 0)
            return a;
        else
            return gcd(b,a % b);
    }

}
