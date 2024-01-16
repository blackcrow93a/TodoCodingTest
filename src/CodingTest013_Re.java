import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CodingTest013_Re {

    /* 13. 카드게임 - Queue 에 대한 메서드를 알고있는지 확인하는 문제 , add 와 poll */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> myQueue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            myQueue.add(i);
        }

        while (myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }

        System.out.println(myQueue.poll());
    }

}
