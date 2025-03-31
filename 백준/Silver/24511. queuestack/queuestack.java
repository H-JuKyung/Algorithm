import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] type = new int[N];
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (type[i] == 0) {
                deque.addLast(val); 
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            deque.addFirst(input);         
            sb.append(deque.pollLast())   
              .append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}