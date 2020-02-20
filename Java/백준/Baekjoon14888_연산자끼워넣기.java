import java.util.Scanner;

public class Baekjoon14888_연산자끼워넣기 {
	static int[] A;
	static int[] operator;
	static int N;
	static int maxNum = 0;
	static int minNum = 1000000001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new int[N];
		operator = new int[4];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		dfs(1, A[0], operator[0], operator[1], operator[2], operator[3]);

		System.out.println(maxNum);
		System.out.println(minNum);
	}

	static void dfs(int idx, int curSum, int sum, int sub, int mul, int div) {
		if (idx == N) {
			if (curSum > maxNum)
				maxNum = curSum;

			if (curSum < minNum)
				minNum = curSum;

			return;
		}
		for (int i = 0; i < 4; i++) {
			if (i == 0 && sum > 0) {
				dfs(idx + 1, curSum + A[idx], sum-1, sub, mul, div);
			} else if (i == 1 && sub > 0) {
				dfs(idx + 1, curSum - A[idx], sum, sub-1, mul, div);
			} else if (i == 2 && mul > 0) {
				dfs(idx + 1, curSum * A[idx], sum, sub, mul-1, div);
			} else if (i == 3 && div > 0) {
				dfs(idx + 1, curSum / A[idx], sum, sub, mul, div-1);
			}

		}
	}
}
