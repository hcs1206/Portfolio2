import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon14502_laboratory_Hwang {
	static int[][] map; // info lab
	static int answer = 0; // max safety zone
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Pair> q = new LinkedList<Pair>();

	static public class Pair { // axis info
		int R;
		int C;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N + 2][M + 2];

		// initialize map to -1
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = -1;


		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					Pair p = new Pair();
					p.R = i;
					p.C = j;
					q.add(p); // save virus axis
				}

			}
		}

		createWall(0, N, M);
		System.out.println(answer);

	}

	static void virusDiff(int N, int M) {
		Queue<Pair> copyQ = new LinkedList<Pair>();
		// copyQ로 hard copy
		for (Pair i : q) { 
			copyQ.add(i);
		}

		int[][] copyMap = new int[N + 2][M + 2];

		// copyMap으로 hard copy
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// bfs로 virus 확산
		while (!copyQ.isEmpty()) {
			Pair p = copyQ.poll();
			int curR = p.R;
			int curC = p.C;

			for (int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				if (copyMap[nextR][nextC] == 0) {
					copyMap[nextR][nextC] = 2;
					Pair p2 = new Pair();
					p2.R = nextR;
					p2.C = nextC;
					copyQ.add(p2);
				}
			}
		}

		//safety zone 계산
		int safety = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (copyMap[i][j] == 0)
					safety++;
			}
		}
		
		// safety zone 최대값 찾기
		if (answer < safety)
			answer = safety;

	} // end of virusDiff

	
	/*
	 * 3개의 벽을 생성하는 모든 경우의 map을 만드는 함수
	 */
	static void createWall(int wallNum, int N, int M) {
		if (wallNum >= 3) { // 벽을 3개 세우면 바이러스 확산
			virusDiff(N, M);
			return;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					createWall(wallNum + 1, N, M);
					map[i][j] = 0;
				}
			}
		}
	} // end of createWall
} // end of class
