import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16987_계란으로계란치기 {
	public static int[] eggS;
	public static int[] eggW;
	public static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		eggS = new int[N];
		eggW = new int[N];
		for (int i = 0; i < eggS.length; i++) {
			st = new StringTokenizer(br.readLine());
			eggS[i] = Integer.parseInt(st.nextToken());
			eggW[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1, eggS);
		System.out.println(answer);
	}

	public static void dfs(int idx, int nextIdx, int[] copyS) {
		// TODO Auto-generated method stub
		if(idx == copyS.length-1 || nextIdx == eggS.length) {
			System.out.println(Arrays.toString(copyS));
			int count = 0;
			for (int i = 0; i < copyS.length; i++) {
				if(copyS[i] < 0)
					count++;
			}
			if(answer < count)
				answer = count;
			
		}
		for (int i = nextIdx; i < eggS.length; i++) {
			int[] tempS = Arrays.copyOf(copyS, copyS.length);
			if(tempS[idx] <= 0) {
				dfs(idx+1, idx+2, copyS);
				return;
			}
			
			
			tempS[idx] = tempS[idx] - eggW[i];
			tempS[i] = tempS[i] - eggW[idx];
			
			dfs(idx, i+1, tempS);
			
		}
	}
	

}
