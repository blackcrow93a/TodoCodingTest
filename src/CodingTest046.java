import java.util.*;

public class CodingTest046 {

    /* 46. 특정 거리의 도시 찾기 */

    static int[] visted; // 방문배열
    static ArrayList<Integer>[] A; // 인접리스트
    static int N,M,K,X; // 노드 개수 , 에지 개수 , 목표거리 , 시작점
    static List<Integer> answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        A = new ArrayList[N+1]; // 인접리스트
        answer = new ArrayList<>();

        for(int i = 1 ; i <= N ; i++){ // 인접리스트 초기화
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 1 ; i <= N ; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        visted = new int[N + 1]; // 방문 배열 초기화

        for(int i = 1 ; i <= N ; i++){
            visted[i] = -1;
        }

        BFS(X);

        for(int i = 0 ; i <= N; i++){
            if(visted[i] == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println("-1");
        }else{
            Collections.sort(answer);
            for(int a : answer){
                System.out.println(a);
            }
        }

    }

    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visted[Node]++;
        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i : A[now_Node]){
                if(visted[i] == -1){
                    visted[i] = visted[now_Node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
