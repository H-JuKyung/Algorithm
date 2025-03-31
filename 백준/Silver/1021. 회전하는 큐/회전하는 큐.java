import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int totalMoves = 0;

        for (int target : targets) {
            int index = 0;
            
            for (int num : deque) {
                if (num == target) break;
                index++;
            }

            int size = deque.size();

            if (index <= size / 2) {
                for (int i = 0; i < index; i++) {
                    deque.offerLast(deque.pollFirst());
                    totalMoves++;
                }
            } else {
                for (int i = 0; i < size - index; i++) {
                    deque.offerFirst(deque.pollLast());
                    totalMoves++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(totalMoves);
    }
}