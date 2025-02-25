class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int a = Math.max(n, m);
        int b = Math.min(n, m);        
        
        // 유클리드 호제법
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        // 최소공배수 = 두 수의 곱 / 최대공약수
        answer[0] = a;
        answer[1] = n * m / a;
         
        return answer;
    }
}
