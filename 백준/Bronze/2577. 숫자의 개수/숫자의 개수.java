import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        br.close();

        int[] cnt = new int[10];
        int n = A * B * C;

        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }

        for (int i = 0; i < cnt.length; ++i) {
            System.out.println(cnt[i]);
        }
    }
}