import java.util.Scanner;
import java.util.Vector;

public class Swexpert3752 {
	static boolean[] visited;
	static Vector<Integer> v;
	static int[] score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			visited = new boolean[N];
			v = new Vector<Integer>();
			score = new int[N];
			for (int i = 0; i < score.length; i++) {
				score[i] = sc.nextInt();
			}
			
			for (int i = 0; i < score.length; i++) {
				dfs(score[i], i, i);
			}
			
			for(int e : v)
				System.out.println(e);
			
			System.out.println("#" + test_case + " " + v.size());
		}
		
		
	}
	
	public static void dfs(int sum, int index, int start) {
		visited[index] = true;
		
		if(!v.contains(sum)) {
			v.add(sum);
		}
		
		for (int i = start+1; i < visited.length; i++) {
			if(!visited[i]) {
				dfs(sum+score[i], i, start);
			}
		}
		
		visited[index] = false;
	}

}
