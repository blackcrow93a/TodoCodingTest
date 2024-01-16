import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CodingTest057 {

    static int N,M; // 도시 및 버스의 개수
    static ArrayList<Node>[] list; // 인접리스트
    static int[] dist; // 거리 계산 배열
    static boolean[] visit; // 방문배열 초기화

    /* 57. 최소 비용 구하기  */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE); // 거리 배열을 충분히 큰 수로 초기화 하기

        for(int i = 0 ; i <= N ; i++){
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,weight));
        }

        st = new StringTokenizer(br.readLine());

        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex,endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start , int end){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if(!visit[now]){
                visit[now] = true;
                for(Node n : list[now]){
                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value){
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode,dist[n.targetNode]));
                    }
                }
            }

        }
        return dist[end];
    }

}

class Node implements Comparable<Node>{

    int targetNode;
    int value;

    Node(int targetNode,int value){
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
