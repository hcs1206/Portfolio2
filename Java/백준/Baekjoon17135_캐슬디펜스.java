import java.util.Scanner;

public class Baekjoon17135_캐슬디펜스 {
	private static int[][] map;
	private static int N;
	private static int M;
	private static int D;
	private static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M];
		D = sc.nextInt();
		answer = 0;
		int[] set = new int[3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<M; i++) {
			makeSet(i, -1, set);
		}
		
		
		System.out.println(answer);
		
	}

	public static void makeSet(int k, int top, int[] arr) {
		arr[++top] = k;
		if(top >= 2) {
			calEnemy(arr);
			return;
		}
		else {
			for(int i=k+1; i<M; i++) {
				makeSet(i, top, arr);
			}
		}
		top--;
	}

	public static void calEnemy(int[] arr) {
		int kill = 0;
		boolean[][] isDead = new boolean[N][M];
		boolean check = false;
		
		for (int turn = 0; turn < N; turn++) {
			for (int i = 0; i < arr.length; i++) { // 궁수
				check = false;
				for (int d = 1; d <= D; d++) { // 거리
					for (int r = N-1-turn; r > N-1-turn-d; r--) {
						for (int c = 0; c < M; c++) {
							int curDist = Math.abs(N-turn - r) + Math.abs(arr[i]-c);
							if(curDist == d && r >= 0 && map[r][c] == 1) {
								isDead[r][c] = true;
								check = true;
								break;
							}
						}
						if(check)
							break;
					}
					if(check)
						break;
				}
			}
			
			for(int r=0; r<N; r++) {
				for (int c = 0; c < M; c++) {
					if(isDead[r][c]) {
						map[r][c] = 0;
					}
				}
			}
//			for(int r=0; r<N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(isDead[i][j]) {
					map[i][j] = 1;
					kill++;
				}
			}
		}
		
		if(answer < kill)
			answer = kill;
		
	}


}




























