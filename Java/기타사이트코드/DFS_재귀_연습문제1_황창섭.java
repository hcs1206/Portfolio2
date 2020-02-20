import java.util.Scanner;
/**
 * 
7
8
1 2
1 3
2 4
2 5
4 6
5 6
6 7
3 7
 */
public class DFS_재귀_연습문제1_황창섭 {
	private static boolean[] visited;
	private static int N;
	private static int[][] G;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[][] G = new int[N+1][N+1];
		int L = sc.nextInt();
		for (int i = 0; i < L; i++) {
				int a= sc.nextInt();
				int b = sc.nextInt();
				G[a][b] = 1;
				G[b][a] = 1;
		}
		visited = new boolean[N+1];
		DFS_Recursive(G, 1);
				
		
	}

	private static void DFS_Recursive(int[][] G, int v) {
		visited[v] = true;
		System.out.print(v);
		
		for (int i = 1; i <= N; i++) {
			if(G[v][i] == 1 && !visited[i]) {
				System.out.print("-");
				DFS_Recursive(G,i);
			}
		}
		
	}

}
