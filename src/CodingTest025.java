import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CodingTest025 {

    static ArrayList<Integer> A[];
    static boolean visited[];
    static boolean arrive;

    /* 25. 친구 관계 파악하기  */
    public static void main(String[] args) {
        int N , M ;
        arrive = false;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        A = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0 ; i < N; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for(int i = 0 ; i < N ; i++){
            DFS(i,1);
        }

        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");


    }

    static void DFS(int now , int depth){

        if(depth == 5 || arrive){
            arrive = true;
            return;
        }

        visited[now] = true;

        for(int i : A[now]){
            if(!visited[i]){
                DFS(i,depth + 1);
            }
        }

        visited[now] = false;

    }


}
