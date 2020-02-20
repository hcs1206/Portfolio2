import java.util.Scanner;

public class Baekjoon15684_사다리조작 {
	private static int[][] ladder;
	private static int N;
	private static int M;
	private static int H;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		ladder = new int[N+1][H+1];
		for (int i = 0; i < M; i++) {
			int a =sc.nextInt();
			int b= sc.nextInt();
			ladder[b][a] = 1;
		}
		
		if(dfs(0,0)) {
			System.out.println(0);
		} else if(dfs(0,1)) {
			System.out.println(1);
		} else if(dfs(0,2)) {
			System.out.println(2);
		} else if(dfs(0,3)) {
			System.out.println(3);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean dfs(int curL, int desL) {
		if(curL == desL) {
			if(checkLadder()) {
				return true;
			}
			return false;
		} else {
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= H; j++) {
					if(ladder[i][j] == 0) {
						if(i-1 > 0 && ladder[i-1][j] == 1)
							continue;
						if(i+1 <= N && ladder[i+1][j] == 1)
							continue;
						
						ladder[i][j] = 1;
						if(dfs(curL+1, desL)) {
							return true;
						}
						ladder[i][j] = 0;
					}
				}
			}
		}
		return false;
	}

	public static boolean checkLadder() {
		for(int i=1; i<=N; i++) {
			int r = i;
			for(int j=1; j<=H; j++) {
				if(ladder[r][j] == 1) {
					r = r+1;
				}
				else if(ladder[r-1][j] == 1) {
					r = r-1;
				}
			}
			if(r != i) {
				return false;
			}
		}
		
		return true;
	}

}
