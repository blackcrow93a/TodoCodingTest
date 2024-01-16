import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class CodingTest012_Re {

    /* 12. 오큰수 구하기  */
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N]; // 수열 배열 생성
        int[] ans = new int[N]; // 정답배열 생성
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 항상 스택이 비어 있으므로 최초 값을 push 해 초기화

        for(int i = 1; i < N; i++){

            // 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[stack.pop()] = A[i];
            }
            stack.push(i);

        }

        while (!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < N ; i++){
            bw.write(ans[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }

}
