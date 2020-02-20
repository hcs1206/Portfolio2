import java.util.Scanner;
import java.util.Stack;

public class Main_정올_1175_주사위던지기2_황창섭 {

	static int[] dice = { 1, 2, 3, 4, 5, 6 };
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		visited = new boolean[6];

		// 1175
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < 6; i++) {
			Stack<Integer> s = new Stack<Integer>();
			diceThrow(s, 1, N, M, i, dice[i]);
		}

	}

	static void diceThrow(Stack<Integer> s, int curThrow, int N, int M, int curIndex, int sum) {
		s.push(dice[curIndex]);
		if (curThrow == N) {
			if(sum == M) {
				for (int i : s) {
					System.out.print(i + " ");
				}
				System.out.println();
				}
			return;
		}
		for (int i = 0; i < 6; i++) {
			diceThrow(s, curThrow + 1, N, M, i, sum+dice[i]);
			s.pop();
		}

	}

}
