import java.util.LinkedList;
import java.util.Scanner;

/**
 * 불!
 */
public class Main {

	public static class Pair {
		Pair(int r, int c, int m) {
			curR = r;
			curC = c;
			curMove = m;
		}

		int curR;
		int curC;
		int curMove;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = -1;
		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][] map = new int[R + 2][C + 2];
		boolean[][] visited = new boolean[R + 2][C + 2];
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		/*
		 * 맵에 대한 정보 저장
		 * 맵을 char로 생성한 것이 아닌 int로 생성하여
		 * 지훈이가 지나갈 수 있는 길인지 아닌지 확인하기 쉽도록 설계
		 */
		int startR = 0;
		int startC = 0;
		for (int i = 1; i <= R; i++) {
			String str = sc.next();
			for (int j = 1; j <= C; j++) {
				switch (str.charAt(j - 1)) {
				//벽 '#' : -2, 지훈이와 불 모두 지나갈 수 없음
				case '#':
					map[i][j] = -2;
					break;
					
				// 빈 공간 '.' : -1, 불과 지훈이 모두
				// 지나갈 수 있음
				case '.':
					map[i][j] = -1;
					break;
					
				// 지훈이의 시작 위치 'J' : 어디서 시작하는지에 대한
				// 좌표만 저장하고 그 외는 지나갈 수 있는 공간과 같으므로
				// -1로 저장
				case 'J':
					map[i][j] = -1;
					startR = i;
					startC = j;
					break;
					
				// 불 'F' : 시작은 1로 시작하여 퍼져나가며
				// 지훈이가 지나갈 수 없는 길을 표시한다
				case 'F':
					map[i][j] = 1;
					break;
				
				default:
					break;
				}
			}
		}

		
		/*
		 * 불을 퍼트리는 부분
		 * -2(벽) 을 제외하고 상하좌우로 불을 퍼트린다
		 * 1의 불은 2의 불을 생성하고
		 * 2의 불은 3의 불을 생성한다
		 */
		boolean toggle = true; 
		int curFire = 1;
		while (toggle) { // 더이상 퍼트릴 불이 업으면 탈출
			toggle = false;
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] == curFire) {
						for (int k = 0; k < 4; k++) {
							int nextR = i + dr[k];
							int nextC = j + dc[k];
							if (map[nextR][nextC] == -1) {
								map[nextR][nextC] = curFire + 1;
								toggle = true;
							}
						}
					}

				}
			}
			curFire++;
		} // end of while

		
		/*
		 * 지훈이가 미로를 탈출하는 최단 경로를 찾기위해
		 * bfs 사용
		 */
		LinkedList<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(startR, startC, 2));
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			Pair curP = q.poll();
			int cR = curP.curR; // 현재 위치 y 좌표
			int cC = curP.curC; // 현재 위치 x 좌표
			int cM = curP.curMove; // 탈출 소요시간, 이동횟수

			// 미로의 외부로 탈출했으면 루프 break
			if (cR > R || cR < 1 || cC > C || cC < 1) {
				answer = cM-2;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = cR + dr[i];
				int nextC = cC + dc[i];
				// 아직 불이 퍼지지 않아 탈출할 수 있는 길이거나(map[nextR][nextC] > cM)
				// 미로의 외부이거나(0)
				// 지나갈 수 있는 길이면(-1)
				// queue에 추가
				if(!visited[nextR][nextC] && (map[nextR][nextC] > cM || map[nextR][nextC] == 0 || map[nextR][nextC] == -1)) {
					visited[nextR][nextC] = true;
					q.add(new Pair(nextR, nextC, cM+1));
				}
			}
		}
		
		if(answer < 0) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(answer);
		}

	} // end of main
}
