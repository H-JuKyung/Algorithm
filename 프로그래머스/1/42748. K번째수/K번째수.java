import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;

            int[] cut = Arrays.copyOfRange(array, start, end); 

            Arrays.sort(cut);
            result[i] = cut[k];
        }

        return result;
    }
}
