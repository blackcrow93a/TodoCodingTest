import com.sun.javafx.geom.Edge;

import java.util.*;

public class CodingTest028 {

    static boolean visted[];
    static int[] distance;
    static ArrayList<Edge>[] A;


    /* 28. 트리의 지름 구하기  */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        A = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            A[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < N ; i++){
            int S = sc.nextInt();
            while (true){
                int E = sc.nextInt();
                if(E == -1){
                    break;
                }
                int V = sc.nextInt();
                A[S].add(new Edge(E,V));
            }
        }
        distance = new int[N+1];
        visted = new boolean[N+1];
        BFS(1);
        int Max = 1;
        for(int i = 2 ; i <= N; i++){
              if(distance[Max] < distance[i]){
                  Max = i;
              }
        }
        distance = new int[N+1];
        visted = new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visted[index] = true;
        while(!queue.isEmpty()){
             int now_node = queue.poll();
             for(Edge i : A[now_node]){

                 int e = i.e;
                 int v = i.value;

                 if(!visted[e]){
                     visted[e] = true;
                     queue.add(e);
                     distance[e] = distance[now_node] + v;
                 }

             }
        }

    }



    static class Edge {
        int e;
        int value;
        public Edge(int e , int value){
           this.e = e;
           this.value = value;
        }
    }



}