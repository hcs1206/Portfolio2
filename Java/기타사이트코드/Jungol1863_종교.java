import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1863_종교 {
//	private static boolean[][] matrix;
	private static boolean[] visited;
	private static int N;
	private static int M;
	private static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		map = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			if(s1 < s2) {
				if(map[s1] == 0) {
					map[s1] = s1;
				}
				
				if(map[s2] > 0) {
					map[map[s2]] = findParent(s1);
					map[s2] = findParent(s1);
				}
				else {
					map[s2] = findParent(s1);
				}
			}
			else {
				if(map[s2] == 0) {
					map[s2] = s2;
				}
				
				if(map[s1] > 0) {
					map[map[s1]] = findParent(s2);
					map[s1] = findParent(s2);
				}
				else {
					map[s1] = findParent(s2);
				}
			}
		}
		
		int answer = 0;
		visited[0] = true;
		for(int i=1; i<=N; i++) {
			System.out.println(i + " " + map[i]);
			if(map[i] == 0) {
				answer++;
			}
			else if(!visited[findParent(map[i])]) {
				answer++;
				visited[map[i]] = true;
			}
		}
		
		System.out.println(answer);

	}

	public static int findParent(int s1) {
		if(map[s1] == s1) {
			return s1;
		}
		else {
			return findParent(map[s1]);
		}
	}
	
	

}
