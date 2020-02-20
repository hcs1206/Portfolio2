package Baekjoon_MN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15656_7 {
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

		int[] arr = new int[N];
		num = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		for (int i = 0; i < N; i++) {
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
				//if (!visited[i]) {
					visited[i] = true;
					arr[++top] = num[i];
					dfs(N, M, curLength + 1, arr);
					--top;
					visited[i] = false;
				//}
			}
		}
	}
}
