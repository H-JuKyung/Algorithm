import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int last = -1; 

        for (int i = 0; i < N; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int x = sc.nextInt();
                queue.offer(x);  
                last = x;      
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : last).append("\n");
            }
        }

        System.out.print(sb);
        sc.close();
    }
}