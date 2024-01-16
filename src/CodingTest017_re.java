import java.util.Scanner;

public class CodingTest017_re {

    /* 17. 내림차순으로 자릿수 정렬하기  */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int[] A = new int[str.length()];

        for(int i = 0 ; i < str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for(int i = 0 ; i < A.length ; i++){ // 선택정렬 공식 이해하기
            int max = i;
            for(int j = i + 1 ; j < A.length; j++){
                if(A[j] > A[max]){
                    max = j;
                }
            }

            if(A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }


        }

        for(Integer a : A){
            System.out.print(a);
        }

    }


}
