import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008_숫자만들기 {
	private static int[] operator;
	private static int[] number;
	private static int max;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			operator = new int[4];
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			
			number = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < number.length; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,operator[0], operator[1], operator[2], operator[3], number[0]);
			

			System.out.println("#" + test_case + " " + (max-min));
		} // end of tc
	} // end of main

	public static void dfs(int i, int sum, int sub, int mul, int div, int result) {
		if(sum == 0 && sub ==0 && mul == 0 && div == 0) {
			if(result > max)
				max = result;
			if(result < min)
				min = result;
		} else {
			if(sum>0) {
				dfs(i+1,sum-1,sub,mul,div,result+number[i+1]);
			}
			if(sub>0) {
				dfs(i+1,sum,sub-1,mul,div,result-number[i+1]);
			}
			if(mul>0) {
				dfs(i+1,sum,sub,mul-1,div,result*number[i+1]);
			}
			if(div>0) {
				dfs(i+1,sum,sub,mul,div-1,result/number[i+1]);
			}
		}
		
	}
	
}
