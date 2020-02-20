import java.util.Scanner;

public class Baekjoon17144_미세먼지안녕 {

	private static Map[][] map;

	static class Map {
		int dust;
		int totalDust;
		public Map(int dust, int totalDust) {
			this.dust = dust;
			this.totalDust = totalDust;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		map = new Map[R][C];
		int airR = 0, airC = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dust = sc.nextInt();
				if (dust == -1) {
					airR = i;
					airC = j;
				}
				map[i][j] = new Map(dust, dust);
			}
		}

		for (int t = 0; t < T; t++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j].dust = map[i][j].totalDust;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j].dust > 0) {
						int count = 0;
						if (i - 1 >= 0 && map[i - 1][j].dust != -1) {
							count++;
							map[i - 1][j].totalDust += map[i][j].dust / 5;
						}
						
						if (i + 1 < R && map[i + 1][j].dust != -1) {
							count++;
							map[i + 1][j].totalDust += map[i][j].dust / 5;
						}

						if (j - 1 >= 0 && map[i][j - 1].dust != -1) {
							count++;
							map[i][j - 1].totalDust += map[i][j].dust / 5;
						}

						if (j + 1 < C && map[i][j + 1].dust != -1) {
							count++;
							map[i][j + 1].totalDust += map[i][j].dust / 5;
						}

						map[i][j].totalDust -= (map[i][j].dust / 5) * count;
					}
				}
			} // end of diffustion

			int tempR = airR + 1;
			int tempC = airC;
			while (tempR + 1 < R) {
				map[tempR][tempC] = map[tempR + 1][tempC];
				tempR++;
			}
			while (tempC + 1 < C) {
				map[tempR][tempC] = map[tempR][tempC + 1];
				tempC++;
			}
			while (tempR - 1 >= airR) {
				map[tempR][tempC] = map[tempR - 1][tempC];
				tempR--;
			}
			while (tempC - 1 > airC) {
				map[tempR][tempC] = map[tempR][tempC - 1];
				tempC--;
			}
			map[airR][airC + 1] = new Map(0, 0);

			tempR = airR - 2;
			tempC = airC;
			while (tempR - 1 >= 0) {
				map[tempR][tempC] = map[tempR - 1][tempC];
				tempR--;
			}
			while (tempC + 1 < C) {
				map[tempR][tempC] = map[tempR][tempC + 1];
				tempC++;
			}
			while (tempR + 1 < airR) {
				map[tempR][tempC] = map[tempR + 1][tempC];
				tempR++;
			}
			while (tempC - 1 > airC) {
				map[tempR][tempC] = map[tempR][tempC - 1];
				tempC--;
			}
			map[airR - 1][airC + 1] = new Map(0, 0);

		} // end of second

		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer += map[i][j].totalDust;
			}
		}
		System.out.println(answer + 2);

	} // end of main

} // end of class