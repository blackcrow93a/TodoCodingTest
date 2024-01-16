import java.util.Scanner;
import java.util.SortedMap;

public class CodingTest050 {

    static int[] A;
    static int N , M;

    /* 50. 집합표현하기 - 유니온파인드 이론 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N+1];

        for(int i = 1 ; i <= N; i++){
            A[i] = i;
        }

        for(int i = 1; i <= M; i++){
            int checkVal = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(checkVal == 0){ // union 연산
                union(a,b);
            }else{ // find 연산
                 if(checkSame(a,b)){
                     System.out.println("YES");
                 }else{
                     System.out.println("NO");
                 }
            }
        }
    }

    public static void union(int a , int b){
        a = find(a);
        b = find(b);
        if(a != b){
            A[b] = a;
        }
    }

    public static int find(int a){
        if( a == A[a]){
            return a;
        }else{
            return A[a] = find(A[a]);
        }
    }

    public static boolean checkSame(int a , int b){
        a = find(a);
        b = find(b);

        if(a == b){
            return true;
        }

        return false;
    }



}
