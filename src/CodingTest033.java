import java.util.PriorityQueue;
import java.util.Scanner;

public class CodingTest033 {

    /* 33. 카드정렬하기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드 묶음수;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0 ; i < N ; i++){
            int data = sc.nextInt();
            queue.add(data);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        while (queue.size() != 1){
            data1 = queue.remove();
            data2 = queue.remove();
            sum += data1 + data2 ;
            queue.add(data1 + data2);
        }
        System.out.println(sum);
    }
    
}
