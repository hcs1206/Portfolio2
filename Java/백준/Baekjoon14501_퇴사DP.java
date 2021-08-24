package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501_퇴사DP {

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

		int[] d = new int[N + 5];

		d[t[0] - 1] = p[0];

		for (int i = 1; i < N; i++) {
			int max = 0;
			if (d[i + t[i] - 1] < d[i - 1] + p[i]) {
				d[i + t[i] - 1] = d[i - 1] + p[i];
			}
			
			if(d[i] < d[i-1]) {
				d[i] = d[i-1];
			}
			
		}

		answer = d[N - 1];

		System.out.print(answer);

	}

}
