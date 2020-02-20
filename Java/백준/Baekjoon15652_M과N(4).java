package Baekjoon_MN;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon15652_4 {
	static int top = -1;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		
		for(int i=1; i<= N; i++) {
			arr[++top] = i;
			dfs(i,N,M,1,arr);
			--top;
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs(int idx, int N, int M, int curLength, int[] arr) throws IOException {
		if(curLength == M) {
			for (int i = 0;  i< arr.length; i++) {
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		}
		else {
			for(int i=idx; i<=N; i++) {
				arr[++top] = i;
				dfs(i,N,M,curLength+1, arr);
				--top;
			}
		}
	}
}
