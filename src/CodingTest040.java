import java.util.Scanner;

public class CodingTest040 {

    /* 40. 제곱이 아닌수 찾기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long Min = sc.nextLong(); // 1
        long Max = sc.nextLong(); // 10

        boolean[] Check = new boolean[(int) (Max - Min + 1)];

        for(long i = 2; i*i <= Max; i++){
            long pow = i * i ; // 4
            long start_index = Min / pow ; // 1 / 4
            if( Min % pow != 0 )
                start_index++;
            for(long j = start_index; pow * j <= Max; j++){
                Check[(int)((j*pow) -Min)] = true;
            }

        }

        int count = 0 ;
        for(int i = 0 ; i <= Max - Min; i++){
            if(!Check[i]){
                count++;
            }
        }

        System.out.println(count);
    }

}
