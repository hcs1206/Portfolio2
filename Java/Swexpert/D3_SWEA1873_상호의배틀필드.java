import java.util.Scanner;

public class SWEA1873_상호의배틀필드 {

	static class Tank {

		Tank() {
		}

		public Tank(int r, int c, int dest) {
			this.r = r;
			this.c = c;
			this.dest = dest;
		}

		int r;
		int c;
		int dest;
	}

	private static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			map = new char[H + 2][W + 2];
			Tank t = new Tank();
			for (int i = 1; i <= H; i++) {
				String str = sc.next();
				for (int j = 1; j <= W; j++) {
					map[i][j] = str.charAt(j - 1);
					if (map[i][j] == '<') {
						t = new Tank(i, j, 2);
					} else if (map[i][j] == '>') {
						t = new Tank(i, j, 3);
					} else if (map[i][j] == '^') {
						t = new Tank(i, j, 0);
					} else if (map[i][j] == 'v') {
						t = new Tank(i, j, 1);
					}
				}
			}

			int N = sc.nextInt();
			String command = sc.next();

			for (int i = 0; i < N; i++) {
				int nextR, nextC;
				switch (command.charAt(i)) {
				case 'U':
					t.dest = 0;
					nextR = t.r + dr[0];
					nextC = t.c + dc[0];
					if(map[nextR][nextC] == '.' && nextR > 0) {
						map[t.r][t.c]= '.';
						map[nextR][nextC] = '^';
						t.r = nextR;
						t.c = nextC;
					}
					else {
						map[t.r][t.c]= '^'; 
					}
					break;

				case 'D':
					t.dest = 1;
					nextR = t.r + dr[1];
					nextC = t.c + dc[1];
					if(map[nextR][nextC] == '.' && nextR <= H) {
						map[t.r][t.c]= '.';
						map[nextR][nextC] = 'v';
						t.r = nextR;
						t.c = nextC;
					}
					else {
						map[t.r][t.c]= 'v'; 
					}
					break;
				case 'L':
					t.dest = 2;
					nextR = t.r + dr[2];
					nextC = t.c + dc[2];
					if(map[nextR][nextC] == '.' && nextC > 0) {
						map[t.r][t.c]= '.';
						map[nextR][nextC] = '<';
						t.r = nextR;
						t.c = nextC;
					}
					else {
						map[t.r][t.c]= '<'; 
					}
					break;
				case 'R':
					t.dest = 3;
					nextR = t.r + dr[3];
					nextC = t.c + dc[3];
					if(map[nextR][nextC] == '.' && nextC <= W) {
						map[t.r][t.c]= '.';
						map[nextR][nextC] = '>';
						t.r = nextR;
						t.c = nextC;
					}
					else {
						map[t.r][t.c]= '>'; 
					}
					break;
				case 'S':
					int curDest = t.dest;
					int curR = t.r;
					int curC = t.c;
					while(true) {
						curR += dr[curDest];
						curC += dc[curDest];
						if(curR > H || curR < 1 || curC > W || curC < 1) {
							break;
						}
						if(map[curR][curC] == '*') {
							map[curR][curC] = '.';
							break;
						}
						if(map[curR][curC] == '#') {
							break;
						}
					}
				}
			} // end of N
			
			System.out.print("#" + test_case + " ");
			for (int i = 1; i<= H; i++) {
				for (int j = 1; j <= W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} // end of test case

	}

}