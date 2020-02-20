import java.util.Scanner;

public class Baekjoon17779_게리맨더링2 {
	public static int[][] map;
	public static int N;
	public static int answer = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+2][N+2];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if(j-d1 > 0 && j+d2 <= N && i+d1+d2 <= N) {
							int temp = makeMap(i,j,d1,d2);
							if(temp < answer)
								answer  = temp;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}

	public static int makeMap(int r, int c, int d1, int d2) {
		int minNum = 10000;
		int maxNum = 0;
		int region1 = 0;
		int copyR = r;
		int copyC = c;
	
		for (int i = 1; i <= r+d1-1; i++) {
			if(i >= copyR) {
				copyC--;
			}
			for (int j = 1; j <= copyC; j++) {
				region1 += map[i][j];
			}
		}
		if(region1 < minNum)
			minNum = region1;
		if(region1 > maxNum)
			maxNum = region1;
		
		int region2 = 0;
		copyR = r;
		copyC = c+1;
		for (int i = 1; i <= r+d2; i++) {
			if(i > copyR) {
				copyC++;
			}
			for (int j = copyC; j <= N; j++) {
				region2 += map[i][j];
			}
		}
		
		if(region2 < minNum)
			minNum = region2;
		if(region2 > maxNum)
			maxNum = region2;
		
		int region3 = 0;
		copyR = r;
		copyC = c-d1-1;
		for (int i = r+d1; i <= N; i++) {
			for (int j = 1; j <= copyC; j++) {
				region3 += map[i][j];
			}
			if(i < r+d1+d2) {
				copyC++;
			}
		}
		
		if(region3 < minNum)
			minNum = region3;
		if(region3 > maxNum)
			maxNum = region3;
		
		int region4 = 0;
		copyR = r;
		copyC = c+d2;
		
		for (int i = r+d2+1; i <= N; i++) {
			
			
			for (int j = N; j >= copyC; j--) {
				region4 += map[i][j];
			}
			if(i <= r+d1+d2) {
				copyC--;
			}
			
		}
		
		
		if(region4 < minNum)
			minNum = region4;
		if(region4 > maxNum)
			maxNum = region4;
		
		int region5 = 0;
		copyR = r;
		int copyC1 = c;
		int copyC2 = c;
		for (int i = r; i <= r+d1+d2; i++) {
			for (int j = copyC1; j <= copyC2; j++) {
				region5 += map[i][j];
			}
			if(i < r+d2) {
				copyC2++;
			}
			else {
				copyC2--;
			}
			if(i < r+d1) {
				copyC1--;
			}
			else {
				copyC1++;
			}
		}
		
		if(region5 < minNum)
			minNum = region5;
		if(region5 > maxNum)
			maxNum = region5;
		
//		System.out.println(r + " " + c + " " + d1 + " " + d2);
//		System.out.println(region1);
//		System.out.println(region2);
//		System.out.println(region3);
//		System.out.println(region4);
//		System.out.println(region5);
		
		
		return maxNum-minNum;
		
	}

}
