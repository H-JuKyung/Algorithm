import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> result = new ArrayList<>();
		List<Integer> people = new ArrayList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		sc.close();
		
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}
		
		int idx = 0;
		while(!people.isEmpty()) {
			idx = (idx + K -1) % people.size();
			result.add(people.remove(idx));
		}
		
		System.out.print("<");
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
                System.out.print(", ");
            }
		}
		System.out.println(">");
	}
}