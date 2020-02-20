import java.util.Scanner;

public class Swexpert1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for (int i = 0; i < arr.length; i++) {
				int sum=0;
				for (int j = 0; j < arr[i].length; j++) {
					sum += arr[i][j];
				}
				if(answer < sum)
					answer = sum;
			}
			
			for (int i = 0; i < arr.length; i++) {
				int sum=0;
				for (int j = 0; j < arr[i].length; j++) {
					sum += arr[j][i];
				}
				if(answer < sum)
					answer = sum;
			}
			
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i][i];
				
				if(answer < sum)
					answer = sum;
			}
			
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i][arr.length-i-1];
				
				if(answer < sum)
					answer = sum;
			}
			
			System.out.println("#"+T+" "+answer);
		} // end of testcase
	}
}
