import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CodingTest047 {

    static ArrayList<Integer> A[]; // 인접리스트
    static boolean visted[]; // 방문배열
    static int answer[]; // 출력

    /* 47. 효율적으로 해킹하기 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        A = new ArrayList[N+1];
        visted = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 1 ; i <= N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= M ; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }

        for(int i = 1; i <= N; i++){
            visted = new boolean[N+1];
            BFS(i);
        }

        int maxVal = 0;
        for(int i = 1 ; i <= N; i++){
            maxVal = Math.max(maxVal,answer[i]);
        }

        for(int i = 1 ; i <=N ; i++){
            if(maxVal == answer[i]){
                System.out.print(i + " ");
            }
        }

    }

    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visted[index] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int a : A[now_node]){
                if(visted[a] == false){
                    visted[a] = true;
                    answer[a]++;
                    queue.add(a);
                }
            }
        }
    }
}
