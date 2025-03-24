import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, priority});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean hasHigher = false;

                for (int[] doc : queue) {
                    if (doc[1] > current[1]) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.offer(current);  
                } else {
                    count++; 
                    if (current[0] == M) {
                        sb.append(count).append("\n");  
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
