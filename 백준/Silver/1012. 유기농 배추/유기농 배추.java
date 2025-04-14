import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int t = 0; t < T; t++) {
            int M = sc.nextInt(); 
            int N = sc.nextInt(); 
            int K = sc.nextInt(); 

            int[][] map = new int[N][M];           
            boolean[][] visited = new boolean[N][M]; 

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            int count = 0; 

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++; 

                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            int[] current = queue.poll();
                            int cx = current[0];
                            int cy = current[1];

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cx + dx[dir];
                                int ny = cy + dy[dir];

                                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        queue.add(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
