import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodingTest010_Re {

    // 10 : 최솟값 찾기 ( 슬라이딩 윈도우 개념 ★)
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기

        st = new StringTokenizer(br.readLine());

        Deque<Node> myDeque = new LinkedList<Node>();

        for(int i = 0 ; i < N ; i++){

            int now = Integer.parseInt(st.nextToken());

            while(!myDeque.isEmpty() && myDeque.getLast().value > now){
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now,i));

            if(myDeque.getFirst().index <= i - L){
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value+" ");

        }
        bw.flush();
        bw.close();
    }
    static class Node{
        public int value;
        public int index;

        Node(int value , int index){
            this.value = value;
            this.index = index;
        }
    }


}
