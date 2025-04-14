import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[][][] days;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        days = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }

        bfs();

        int result = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, days[h][n][m]);
                }
            }
        }

        System.out.println(result);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int x = current[1];
            int y = current[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = z + dz[dir];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1;
                        days[nz][nx][ny] = days[z][x][y] + 1;
                        queue.add(new int[]{nz, nx, ny});
                    }
                }
            }
        }
    }
}
