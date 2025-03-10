import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                if (ch == '<') {  
                    if (cursor.hasPrevious()) cursor.previous();
                } else if (ch == '>') { 
                    if (cursor.hasNext()) cursor.next();
                } else if (ch == '-') {  
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else {  
                    cursor.add(ch);
                }
            }

            for (Character c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
