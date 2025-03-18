import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();  

        for (int i = 0; i < N; i++) {
            int command = sc.nextInt();

            if (command == 1) {  
                int X = sc.nextInt();
                stack.push(X);
            } else if (command == 2) { 
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if (command == 3) {  
                sb.append(stack.size()).append("\n");
            } else if (command == 4) {  
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if (command == 5) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }

        System.out.print(sb); 
        sc.close();
    }
}