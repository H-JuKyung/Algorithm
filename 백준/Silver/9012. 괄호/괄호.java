import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int i = 0; i < T; i++) {
            String str = sc.next();  
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;  

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '(') {
                    stack.push(ch); 
                } else if (ch == ')') {
                    if (stack.isEmpty()) {  
                        isValid = false;
                        break;
                    }
                    stack.pop(); 
                }
            }

            if (!stack.isEmpty()) {  
                isValid = false;
            }

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}