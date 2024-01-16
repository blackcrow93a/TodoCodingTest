import java.util.Scanner;

public class CodingTest001 {

    /* 1.숫자의합구하기 , 백준온라인 저지 : 11720번  */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1) 첫번째 N 입력 받기

        String sNum = sc.next(); // 2) 두번째 입력값 String 변수에 저장하기

        char[] cNum = sNum.toCharArray(); // 3) 두번째 입력받은값 char 형으로 변환 (아스키코드 변환 정리하기 ★)
        // 아스키코드 표 확인 0 ~ 9 는 48 ~ 57의 순서로 되어 있음 , '0' 을 빼주면 원하는 숫자를 얻을수 있음

        int sum = 0 ;

        for(int i = 0 ; i < cNum.length ; i++){
            //sum += cNum[i] - '0';
            sum += Character.getNumericValue(cNum[i]);
        }

        System.out.println(sum);
    }
}
