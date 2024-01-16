import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CodingTest014 {

    /* 14. 절대값 힙 구하기  */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 우선순위 큐 정렬방법 정리하기 ★ */
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>(((o1, o2) -> {

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1; // 절대값이 같으면 음수 우선 정렬하기
            else
               return first_abs - second_abs; // 절대값을 기준으로 정렬하기

        }));

        for(int i = 0 ; i < N ; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){

                if(MyQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(MyQueue.poll());

            }else{
                MyQueue.add(request);
            }

        }
    }


}
