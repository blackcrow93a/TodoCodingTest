import java.util.Scanner;

public class CodingTest036 {

    static int answer = 0 ;

    /* 36. 최솟값을 만드는 괄호 배치 찾기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();

        String str[] = example.split("-");

        // 100-(40+50+74)-(30+29)-(45+43+11)

        for(int i = 0; i < str.length;i++){
            int temp = mySum(str[i]);

            if(i == 0){
                answer = answer + temp;
            }else{
                answer = answer - temp;
            }
        }

        System.out.println(answer);
    }

    static int mySum(String a){
        int sum = 0;
        String temp[] = a.split("[+]");

        for(int i = 0 ; i < temp.length;i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }


}
