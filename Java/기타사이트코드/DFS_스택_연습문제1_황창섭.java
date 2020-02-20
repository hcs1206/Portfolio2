import java.util.Scanner;
/** 
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
public class DFS_스택_연습문제1_황창섭 {
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
		
		int[] stack = new int[N+1];
		int top = -1;
		visited = new boolean[N+1];
		int v = 1;
		stack[++top] = v;
		System.out.print(v + "-");
		visited[v] = true;
		while(top>=0) {
			int w = -1;
			for (int i = 1; i <= N; i++) {
				if(G[v][i] == 1 && !visited[i]) {
					stack[++top] = i;
					visited[i] = true;
					System.out.print(i + "-");
					v = w = i;
					break;
				}
			}
			if(w==-1) {
				v= stack[top--];
			}
		}
		
	} // end of main
} // end of class
