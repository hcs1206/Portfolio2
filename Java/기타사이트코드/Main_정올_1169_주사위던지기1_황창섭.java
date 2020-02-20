import java.util.Scanner;
import java.util.Stack;

public class Main_정올_1169_주사위던지기1_황창섭 {
	
	static int[] dice = {1,2,3,4,5,6};
	static int[] weight = {1,5,25,125,625,3125};
	static boolean[] visited;
	static boolean[] visited2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		visited = new boolean[6];
		visited2 = new boolean[15626];

		int N = sc.nextInt();
		int M = sc.nextInt();
		

		for (int i = 0; i < 6; i++) {
			Stack<Integer> s = new Stack<Integer>();
			diceThrow(s, 1, N, M, i, weight[i]);
		}
		
	}

	static void diceThrow(Stack<Integer> s, int curThrow, int N, int M, int curIndex, int sum) {
		if (M == 1) {			
			s.push(dice[curIndex]);
			if(curThrow == N) {
				for(int i : s) {
					System.out.print(i + " ");
				}
				System.out.println();
				return;
			}
			for(int i=0; i<6; i++) {
				diceThrow(s, curThrow+1, N, M, i, 0);
				s.pop();
			}
		}
		else if (M == 2) {
			s.push(dice[curIndex]);
			if(curThrow == N) {
				if(!visited2[sum]) {
					visited2[sum] = true;
					for(int i : s) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
				return;
			}
			for(int i=0; i<6; i++) {
				diceThrow(s, curThrow+1, N, M, i, sum+weight[i]);
				s.pop();
			}
		}
		else {
			visited[curIndex] = true;
			s.push(dice[curIndex]);
			if(curThrow == N) {
				for(int i : s) {
					System.out.print(i + " ");
				}
				System.out.println();
				visited[curIndex] = false;
				return;
			}
			for(int i=0; i<6; i++) {
				if(!visited[i]) {
					diceThrow(s, curThrow+1, N, M, i, 0);
					s.pop();
				}
			}
			
			visited[curIndex] = false;
		}

	}

}
