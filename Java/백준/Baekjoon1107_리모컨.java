package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1107_리모컨 {

	static boolean[] button;
	static int answer;
	static int maxClick;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		button = new boolean[10];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}

		answer = Math.abs(100 - N);
		maxClick = answer;

		findMinClick(0, 0, false);

		System.out.println(answer);

	}

	private static void findMinClick(int channel, int clickCnt, boolean toggle) {
		if (Math.abs(channel - N) + clickCnt + (toggle ? 0 : 1) > maxClick && channel > N)
			return;
		else if (answer > Math.abs(channel - N) + clickCnt + (toggle ? 0 : 1))
			answer = Math.abs(channel - N) + clickCnt + (toggle ? 0 : 1);

		for (int i = 0; i < button.length; i++) {
			if (!button[i] && (!(channel == 0 && i == 0) || !toggle)) {
				findMinClick(channel * 10 + i, clickCnt + 1, true);
			}
		}
	}

}
