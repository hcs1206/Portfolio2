import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1808_지희의고장난계산기 {
	static boolean[] num = new boolean[10];

	static class Cal {
		public Cal(int curNum, int nextNum, boolean flag, boolean oneTimeMul, int cnt) {
			this.curNum = curNum;
			this.nextNum = nextNum;
			this.flag = flag;
			this.oneTimeMul = oneTimeMul;
			this.cnt = cnt;
		}

		int curNum;
		int nextNum;
		boolean flag;
		boolean oneTimeMul;
		int cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < num.length; i++) {
				if (st.nextToken().charAt(0) == '0') {
					num[i] = false;
				} else {
					num[i] = true;
				}
			}
			int N = Integer.parseInt(br.readLine());

			Queue<Cal> q = new LinkedList<Cal>();

			for (int i = 1; i <= 9; i++) {
				if (num[i])
					q.offer(new Cal(i, 0, false, false, 1));
			}

			boolean check = false;

			while (!q.isEmpty()) {
				Cal c = q.poll();

				if (c.curNum == N) {
					if (c.oneTimeMul) {
						System.out.println("#" + test_case + " " + c.cnt);
					}
					else {
						System.out.println("#" + test_case + " " + (c.cnt+1));
					}
					check = true;
					break;
				}

				for (int i = 0; i <= 9; i++) {
					if (num[i]) {
						if (c.flag) {
							if (c.nextNum == 0 && i == 0)
								continue;
							int y = c.nextNum * 10 + i;
							int x = c.curNum * y;
							if (x <= N && N%c.curNum == 0) {
								q.offer(new Cal(c.curNum, y, true, c.oneTimeMul, c.cnt + 1));
							}
						} else {

							int x = c.curNum * 10 + i;
							if (x <= N) {
								q.offer(new Cal(x, 0, false, c.oneTimeMul, c.cnt + 1));
							}
						}
					}
				}

				if (c.flag) {
					if (c.nextNum == 0 || c.nextNum == 1) {
						continue;
					}
					if (c.curNum * c.nextNum <= N && N%(c.curNum * c.nextNum) == 0) {
						q.offer(new Cal(c.curNum * c.nextNum, 0, true, c.oneTimeMul, c.cnt + 1));
					}
				} else {
					q.offer(new Cal(c.curNum, 0, true, true, c.cnt + 1));
				}
			}

			if (!check) {
				System.out.println("#" + test_case + " " + -1);
			}
		}
	}
}
