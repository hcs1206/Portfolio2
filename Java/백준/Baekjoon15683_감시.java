package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15683_감시 {

	static List<Camera> camera;
	static int answer, N, M;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class Camera {
		int r;
		int c;
		int num;

		public Camera(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 64;

		int[][] map = new int[N][M];
		camera = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] != 6) {
					camera.add(new Camera(i, j, map[i][j]));
				}
			}
		}

		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}

		cameraOn(0, copyMap);
		System.out.println(answer);

	}

	private static void cameraOn(int index, int[][] tempMap) {
		if (index >= camera.size()) {
			int cnt = 0;
			for (int i = 0; i < tempMap.length; i++) {
				for (int j = 0; j < tempMap[i].length; j++) {
					if (tempMap[i][j] == 0)
						cnt++;
				}
			}
			if (cnt < answer)
				answer = cnt;

		} else {
			Camera curCamera = camera.get(index);

			switch (curCamera.num) {
			case 1:
				for (int dest = 0; dest < 4; dest++) {
					int[][] copyMap = new int[tempMap.length][tempMap[0].length];
					for (int i = 0; i < tempMap.length; i++) {
						System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
					}
					int nR = curCamera.r;
					int nC = curCamera.c;
					while (true) {
						nR += dr[dest];
						nC += dc[dest];

						if (nR < 0 || nC < 0 || nR >= N || nC >= M || copyMap[nR][nC] == 6)
							break;

						copyMap[nR][nC] = -1;

					}
					cameraOn(index + 1, copyMap);
				}

				break;
			case 2:
				for (int dest = 0; dest < 2; dest++) {
					int[][] copyMap = new int[tempMap.length][tempMap[0].length];
					for (int i = 0; i < tempMap.length; i++) {
						System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
					}
					for (int i = 0; i < 2; i++) {
						int nR = curCamera.r;
						int nC = curCamera.c;
						while (true) {
							nR += dr[(dest + 2 * i) % 4];
							nC += dc[(dest + 2 * i) % 4];

							if (nR < 0 || nC < 0 || nR >= N || nC >= M || copyMap[nR][nC] == 6)
								break;

							copyMap[nR][nC] = -1;

						}
					}
					cameraOn(index + 1, copyMap);
				}
				break;
			case 3:
				for (int dest = 0; dest < 4; dest++) {
					int[][] copyMap = new int[tempMap.length][tempMap[0].length];
					for (int i = 0; i < tempMap.length; i++) {
						System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
					}
					for (int i = 0; i < 2; i++) {
						int nR = curCamera.r;
						int nC = curCamera.c;
						while (true) {
							nR += dr[(dest + i) % 4];
							nC += dc[(dest + i) % 4];

							if (nR < 0 || nC < 0 || nR >= N || nC >= M || copyMap[nR][nC] == 6)
								break;

							copyMap[nR][nC] = -1;

						}
					}

					cameraOn(index + 1, copyMap);
				}
				break;
			case 4:
				for (int dest = 0; dest < 4; dest++) {
					int[][] copyMap = new int[tempMap.length][tempMap[0].length];
					for (int i = 0; i < tempMap.length; i++) {
						System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
					}
					for (int i = 0; i < 3; i++) {
						int nR = curCamera.r;
						int nC = curCamera.c;
						while (true) {
							nR += dr[(dest + i) % 4];
							nC += dc[(dest + i) % 4];

							if (nR < 0 || nC < 0 || nR >= N || nC >= M || copyMap[nR][nC] == 6)
								break;

							copyMap[nR][nC] = -1;

						}
					}

					cameraOn(index + 1, copyMap);
				}
				break;
			case 5:
				int[][] copyMap = new int[tempMap.length][tempMap[0].length];
				for (int i = 0; i < tempMap.length; i++) {
					System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
				}
				for (int dest = 0; dest < 4; dest++) {
					int nR = curCamera.r;
					int nC = curCamera.c;
					while (true) {
						nR += dr[(dest) % 4];
						nC += dc[(dest) % 4];

						if (nR < 0 || nC < 0 || nR >= N || nC >= M || copyMap[nR][nC] == 6)
							break;

						copyMap[nR][nC] = -1;

					}
				}

				cameraOn(index + 1, copyMap);

				break;
			}
		}

	}

}
