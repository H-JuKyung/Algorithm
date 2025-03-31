import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;
        int lead1 = 0;
        int lead2 = 0;
        int lastTime = 0;  

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            String timeStr = st.nextToken();
            String[] timeParts = timeStr.split(":");
            int minute = Integer.parseInt(timeParts[0]);
            int second = Integer.parseInt(timeParts[1]);
            int currentTime = minute * 60 + second;

            if (score1 > score2) {
                lead1 += (currentTime - lastTime);
            } else if (score2 > score1) {
                lead2 += (currentTime - lastTime);
            }

            if (team == 1) score1++;
            else score2++;

            lastTime = currentTime;
        }

        int endTime = 48 * 60;

        if (score1 > score2) {
            lead1 += (endTime - lastTime);
        } else if (score2 > score1) {
            lead2 += (endTime - lastTime);
        }

        int min1 = lead1 / 60;
        int sec1 = lead1 % 60;
        System.out.printf("%02d:%02d\n", min1, sec1);

        int min2 = lead2 / 60;
        int sec2 = lead2 % 60;
        System.out.printf("%02d:%02d\n", min2, sec2);
    }
}