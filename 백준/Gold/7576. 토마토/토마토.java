import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] box = new int[n][m]; 
        int[][] days = new int[n][m]; 
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1; 
                        days[nx][ny] = days[x][y] + 1; 
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int result = 0;
        boolean allRipe = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    allRipe = false;
                    break;
                }
                result = Math.max(result, days[i][j]); 
            }
        }

        System.out.println(allRipe ? result : -1);
    }
}