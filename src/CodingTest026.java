import java.util.*;

public class CodingTest026 {


    static ArrayList<Integer> A[]; // 인접리스트
    static boolean visted[];

    /* 26. DFS 와 BFS 프로그램 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int point_num = sc.nextInt();

        A = new ArrayList[N+1];

        for(int i = 0 ; i <= N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for(int i = 0 ; i <= N ; i++){
            Collections.sort(A[i]);
        }

        visted = new boolean[N+1];
        DFS(point_num);
        System.out.println();
        visted = new boolean[N+1];
        BFS(point_num);

    }

    static void DFS(int node){
        System.out.print(node + " ");

        if(visted[node]){
           return;
        }

        visted[node] = true;

        for(int i : A[node]){
           if(!visted[i]){
               DFS(i);
           }
        }
    }

    static void BFS( int node ){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visted[node] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for(int i : A[now_Node]){
                if(!visted[i]){
                    visted[i] = true;
                    queue.add(i);
                }
            }
        }

    }

}
