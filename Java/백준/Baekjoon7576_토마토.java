import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7576_토마토 {
	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					q.offer(new int[] {i,j,0});
				}
			}
		}
		
		int answer = 0;
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			if(p[2] > answer)
				answer = p[2];
			
			if(p[0]-1 >= 0 && map[p[0]-1][p[1]] == 0) {
				map[p[0]-1][p[1]] = 1;
				q.offer(new int[] {p[0]-1,p[1],p[2]+1});
			}
			if(p[0]+1 < N && map[p[0]+1][p[1]] == 0) {
				map[p[0]+1][p[1]] = 1;
				q.offer(new int[] {p[0]+1,p[1],p[2]+1});
			}
			if(p[1]-1 >= 0 && map[p[0]][p[1]-1] == 0) {
				map[p[0]][p[1]-1] = 1;
				q.offer(new int[] {p[0],p[1]-1,p[2]+1});
			}
			if(p[1]+1 < M && map[p[0]][p[1]+1] == 0) {
				map[p[0]][p[1]+1] = 1;
				q.offer(new int[] {p[0],p[1]+1,p[2]+1});
			}
		}
		
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
