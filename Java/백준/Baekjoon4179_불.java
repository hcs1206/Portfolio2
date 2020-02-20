import java.util.LinkedList;
import java.util.Scanner;

/**
 * ��!
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
		 * �ʿ� ���� ���� ����
		 * ���� char�� ������ ���� �ƴ� int�� �����Ͽ�
		 * �����̰� ������ �� �ִ� ������ �ƴ��� Ȯ���ϱ� ������ ����
		 */
		int startR = 0;
		int startC = 0;
		for (int i = 1; i <= R; i++) {
			String str = sc.next();
			for (int j = 1; j <= C; j++) {
				switch (str.charAt(j - 1)) {
				//�� '#' : -2, �����̿� �� ��� ������ �� ����
				case '#':
					map[i][j] = -2;
					break;
					
				// �� ���� '.' : -1, �Ұ� ������ ���
				// ������ �� ����
				case '.':
					map[i][j] = -1;
					break;
					
				// �������� ���� ��ġ 'J' : ��� �����ϴ����� ����
				// ��ǥ�� �����ϰ� �� �ܴ� ������ �� �ִ� ������ �����Ƿ�
				// -1�� ����
				case 'J':
					map[i][j] = -1;
					startR = i;
					startC = j;
					break;
					
				// �� 'F' : ������ 1�� �����Ͽ� ����������
				// �����̰� ������ �� ���� ���� ǥ���Ѵ�
				case 'F':
					map[i][j] = 1;
					break;
				
				default:
					break;
				}
			}
		}

		
		/*
		 * ���� ��Ʈ���� �κ�
		 * -2(��) �� �����ϰ� �����¿�� ���� ��Ʈ����
		 * 1�� ���� 2�� ���� �����ϰ�
		 * 2�� ���� 3�� ���� �����Ѵ�
		 */
		boolean toggle = true; 
		int curFire = 1;
		while (toggle) { // ���̻� ��Ʈ�� ���� ������ Ż��
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
		 * �����̰� �̷θ� Ż���ϴ� �ִ� ��θ� ã������
		 * bfs ���
		 */
		LinkedList<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(startR, startC, 2));
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			Pair curP = q.poll();
			int cR = curP.curR; // ���� ��ġ y ��ǥ
			int cC = curP.curC; // ���� ��ġ x ��ǥ
			int cM = curP.curMove; // Ż�� �ҿ�ð�, �̵�Ƚ��

			// �̷��� �ܺη� Ż�������� ���� break
			if (cR > R || cR < 1 || cC > C || cC < 1) {
				answer = cM-2;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = cR + dr[i];
				int nextC = cC + dc[i];
				// ���� ���� ������ �ʾ� Ż���� �� �ִ� ���̰ų�(map[nextR][nextC] > cM)
				// �̷��� �ܺ��̰ų�(0)
				// ������ �� �ִ� ���̸�(-1)
				// queue�� �߰�
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
