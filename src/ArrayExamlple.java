import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExamlple {

    public static void main(String[] args) {

        // 1. 배열 초기화 방법
        // 1) 자료형 초기화 및 길이 지정 , 이후 배열 길이에 맞게 데이터 삽입하기

        Integer[] data_list = new Integer[10];

        for(int i = 0 ; i < data_list.length; i++){
            data_list[i] = i + 1;
        }

        // 2) 자료형 선언 과 함께 , 데이터 초기화

        String[] data_list_str = new String[] { "알고리즘이론","알고리즘실습","코딩테스트실습","프로그래밍강좌듣기","영어회화듣기"};

        for(int i = 0 ; i < data_list_str.length ; i ++){
            System.out.println(data_list_str[i].toString());
        }

        // 3) 자료형 선언 과 함께 널 초기화 , 이후 배열 정보 초기화 시키기

        String[] data_list_str2 = null;
        data_list_str2 = new String[] { "알고리즘이론","알고리즘실습","코딩테스트실습","프로그래밍강좌듣기","영어회화듣기"};


        // 2. ArrayList 초기화 및 사용법

        ArrayList<Integer> data_array_list = new ArrayList<Integer>();

        data_array_list.add(1);
        data_array_list.add(2);
        data_array_list.add(3);

        System.out.println(data_array_list.size());
        System.out.println(data_array_list.toString());




    }
}
