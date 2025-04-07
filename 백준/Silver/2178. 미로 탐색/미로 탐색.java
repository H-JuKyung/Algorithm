import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); 

        int[][] maze = new int[n][m];   
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine(); 
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; 
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1; 
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(distance[n - 1][m - 1]);
    }
}