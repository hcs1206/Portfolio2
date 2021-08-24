package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501_퇴사 {

	static int N;
	static int[] t;
	static int[] p;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		t = new int[N];
		p = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		findMaxRevenue(0, 0, 0);

		System.out.print(answer);

	}

	private static void findMaxRevenue(int workDay, int today, int totalPrice) {

		if (totalPrice > answer) {
			answer = totalPrice;
		}

		if (today >= N) {
			return;
		}

		if (workDay == 0) {
			if (today + t[today] - 1 < N) {
				findMaxRevenue(t[today] - 1, today + 1, totalPrice + p[today]);
			}
			findMaxRevenue(0, today + 1, totalPrice);

		} else {
			findMaxRevenue(workDay - 1, today + 1, totalPrice);
		}

	}

}
