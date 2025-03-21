import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();
            if (n == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(n);
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        System.out.println(sum);
        sc.close();
	}
}
