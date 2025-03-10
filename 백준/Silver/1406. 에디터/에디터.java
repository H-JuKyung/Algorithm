import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String initialText = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        
        for (char c : initialText.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> cursor = list.listIterator(list.size());

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            if (cmd == 'L') {
                if (cursor.hasPrevious()) cursor.previous();
            } else if (cmd == 'D') {
                if (cursor.hasNext()) cursor.next();
            } else if (cmd == 'B') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (cmd == 'P') {
                char ch = command.charAt(2);
                cursor.add(ch);
            }
        }

        for (char c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
