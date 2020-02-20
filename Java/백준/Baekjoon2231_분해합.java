import java.util.Scanner;

public class Baekjoon2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int answer = 0;

		for (int i = N - 1; i > 0; i--) {
			int M = i;
			int sum = M;
			while(M > 0) {
				sum += M%10;
				M /= 10;
			}
			if(sum == N) {
				answer = i;
			}
		}
		
		System.out.println(answer);

	}

}
