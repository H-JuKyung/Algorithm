import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            
            switch (command) {
                case "push":
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                    
                case "pop":
                    sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
                    break;
                    
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                    
                case "empty":
                    sb.append(stack.isEmpty() ? "1" : "0").append("\n");
                    break;
                    
                case "top":
                    sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb); 
        sc.close();
    }
}