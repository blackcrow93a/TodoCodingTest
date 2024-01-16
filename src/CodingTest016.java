import java.util.Scanner;

public class CodingTest016 {

    /* 16. 버블소트 프로그램 1  */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N+1];

        for(int i = 1 ; i < N+1 ; i++){
            A[i] = sc.nextInt();
        }

        boolean change = false;

        for(int i = 1; i <= N+1; i++){

            change = false;

            for(int j = 1 ; j <= N - i; j++){
                if(A[j] > A[j+1]){
                    change = true;
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;

                }
            }

            if(change == false){
                System.out.println(i);
                break;
            }
        }
    }

}
