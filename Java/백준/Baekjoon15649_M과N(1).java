package Baekjoon_MN;
import java.util.Scanner;

public class Baekjoon15649_1 {
	static boolean[] visited;
	static int top = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		visited = new boolean[N+1];
		int[] arr = new int[M];
		
		for(int i=1; i<= N; i++) {
			visited[i] = true;
			arr[++top] = i;
			dfs(N,M,1,arr);
			--top;
			visited[i] = false;
		}
	}
	
	static void dfs(int N, int M, int curLength, int[] arr) {
		if(curLength == M) {
			for (int i = 0;  i< arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr[++top] = i;
					dfs(N,M,curLength+1, arr);
					--top;
					visited[i] = false;
				}
			}
		}
	}
}
