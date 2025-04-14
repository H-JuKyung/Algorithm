import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int normalCount = 0;
        int blindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j], false); 
                    normalCount++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j], true);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + blindCount);
    }

    static void bfs(int x, int y, char color, boolean blindMode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (isSameColor(color, map[nx][ny], blindMode)) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean isSameColor(char c1, char c2, boolean blindMode) {
        if (blindMode) {
            if (c1 == 'B' && c2 == 'B') return true;
            if ((c1 == 'R' || c1 == 'G') && (c2 == 'R' || c2 == 'G')) return true;
            return false;
        } else {
            return c1 == c2;
        }
    }
}