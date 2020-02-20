//import java.util.Arrays;
//import java.util.Scanner;
//
//public class SWEAUser9539_코섭이는커피를좋아해 {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int test_case = 1; test_case <= T; test_case++) {
//			int N = sc.nextInt();
//			
//			int[] week = new int[7*N];
//			
//			for (int i = 0; i < week.length; i++) {
//				week[i] = sc.nextInt();
//			}
//			
//			int[][] weekInfo = new int[N][7];
//			
//			
//			int[] dp = new int[7*N];
//			dp[0] = week[0];
//			weekInfo[0][0] = 0;
//			dp[1] = week[1];
//			weekInfo[0][1] = 1;
//			
//			
//			for(int i=0; i<N; i++) {
//				if(i==0) {
//					for(int j=2; j<7; j++) {
//						if(dp[j-2].x+week[j] > dp[j-1].x) {
//							b[j] = true;
//							dp[j] = new Dp(dp[j-2].x+week[j], b);
//						}
//						else {
//							boolean[] b = new boolean[7];
//							System.arraycopy(dp[j-1].weekInfo, 0, b, 0, 7);
//							dp[j] = new Dp(dp[j-1].x, b);
//						}
//					}
//				}
//				else {
//					if(dp[7*i-1].weekInfo[0]) {
//						
//					}
//					else {
//						boolean[] b= new boolean[7];
//						b[0] = true;
//						dp[7*i] = new Dp(dp[7*i-1].x + week[7*i], b);
//					}
//					for(int j=0; j<7; j++) {
//						if(dp[j-2].x+week[j] > dp[j-1].x) {
//							boolean[] b = new boolean[7];
//							System.arraycopy(dp[j-2].weekInfo, 0, b, 0, 7);
//							b[j] = true;
//							dp[j] = new Dp(dp[j-2].x+week[j], b);
//						}
//						else {
//							boolean[] b = new boolean[7];
//							System.arraycopy(dp[j-1].weekInfo, 0, b, 0, 7);
//							dp[j] = new Dp(dp[j-1].x, b);
//						}
//					}
//				}
//				
//			}
//			
//			
//			System.out.println(dp[6].x);
//		}
//	}
//
//}
