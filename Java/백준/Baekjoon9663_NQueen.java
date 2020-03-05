import java.util.Scanner;

public class Baekjoon9663_NQueen {
	private static int[] col;
	private static int N;
	private static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			col[0] = i;
			dfs(1);
			col[0] = 0;
		}
		System.out.println(answer);
	}

	private static void dfs(int idx) {
		// TODO Auto-generated method stub
		if(idx == N) {
			answer++;
		} else {			
			for (int i = 0; i < col.length; i++) {
				boolean check = false;
				for (int j = 0; j < idx; j++) {
					if(col[j] == i || col[j]-j == i-idx || col[j]+j == i+idx) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					col[idx] = i;
					dfs(idx+1);
					col[idx] = 0;
				}
			}
		}
	}

}
