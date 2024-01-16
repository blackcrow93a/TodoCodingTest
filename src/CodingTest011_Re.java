import java.util.Scanner;
import java.util.Stack;

public class CodingTest011_Re {

    /* 11. 스택으로 오름차순 수열 만들기  */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 개수
        int[] A = new int[N];

        for(int i = 0 ; i < N ; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> statck = new Stack<>();
        int num = 1;
        boolean result = false;

        for(int i = 0 ; i < A.length; i++){

            int su = A[i]; // 현재 수열의 값

            if(su >= num){ // 현재수열값 >= 오름차순 자연수 : 값이 같아질때까지 push() 수행
                while (su >=num){
                  statck.push(num++);
                  System.out.println("+");
                }
                statck.pop();
                System.out.println("-");
            }else{ // 현재수열값 < 오름차순 자연수 : pop() 을 수행해 수열 원소를 꺼냄
                int n = statck.pop();
                if( n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    System.out.println("-");
                }
            }

        }
    }


}
