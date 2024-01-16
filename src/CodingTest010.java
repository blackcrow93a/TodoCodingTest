import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest010 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 버퍼에 넣고 한 번에 출력하기 위해 BufferdWriter 사용

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기

        st = new StringTokenizer(br.readLine());

        Deque<Node> mydeque = new LinkedList<Node>();

        for(int i = 0 ; i < N ; i ++){

            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들오올때마다 정렬대신 현재수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임 ★

            while(!mydeque.isEmpty() && mydeque.getLast().value > now ){
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(now,i));

            if(mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value+ " ");

        }

        bw.flush();
        bw.close();
    }

    static class Node{

        public int value;
        public int index;

        Node(int value,int index){
            this.value = value;
            this.index = index;
        }

    }

}
