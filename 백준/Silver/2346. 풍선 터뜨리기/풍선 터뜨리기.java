import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();  

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.offer(new int[]{i, move});  
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();  
            int index = current[0];
            int move = current[1];
            sb.append(index).append(" ");

            if (deque.isEmpty()) break;

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
