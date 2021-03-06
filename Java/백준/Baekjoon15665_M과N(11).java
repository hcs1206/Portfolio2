package Baekjoon_MN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15665_11 {
	static int top = -1;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] visited;
	static int[] num;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		num = new int[N]; // 숫자 담는 배열
		visited = new boolean[N];
		int[] arr = new int[M]; // 출력 배열

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		for (int i = 0; i < N; i++) {
			if (i > 0) {
				if (num[i] == num[i - 1])
					continue;
			}
			visited[i] = true;

			arr[++top] = num[i];

			dfs(N, M, 1, arr);
			--top;
			visited[i] = false;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int N, int M, int curLength, int[] arr) throws IOException {
		if (curLength == M) {
			for (int i = 0; i < M; i++) {
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (i > 0) {
					if (num[i] == num[i - 1])
						continue;
				}
				visited[i] = true;
				arr[++top] = num[i];
				dfs(N, M, curLength + 1, arr);
				--top;
				visited[i] = false;
			}
		}
	}
}
