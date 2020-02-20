import java.util.Scanner;

public class Solution_SWEA_1244_최대상금_D3_황창섭 {
	private static int[] price;
	private static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			int C = sc.nextInt();
			price = new int[str.length()];

			for (int i = 0; i < price.length; i++) {
				price[i] = str.charAt(i) - '0';
			}
			answer = 0;
			dfs(0, C, 0, price);
			
			System.out.println("#" + test_case + " " + answer);

		}
	}

	public static void dfs(int curC, int desC, int index, int[] tempArray) {
		// TODO Auto-generated method stub
		if (curC == desC) {
			int sum = 0;
			for (int i = tempArray.length - 1, j = 1; i >= 0; i--, j *= 10) {
				sum += tempArray[i] * j;
			}
			if (answer < sum)
				answer = sum;

		} else {
			int[] copyArray = new int[price.length];
			for (int i = index; i < price.length; i++) {
				for (int j = i+1; j < price.length; j++) {
					System.arraycopy(tempArray, 0, copyArray, 0, price.length);
					if (copyArray[i] <= copyArray[j] && curC < desC) {
						int temp = copyArray[i];
						copyArray[i] = copyArray[j];
						copyArray[j] = temp;
						dfs(curC + 1, desC, index + 1, copyArray);
					}
				}
			}
			if (curC < desC) {
				int temp = tempArray[price.length - 1];
				tempArray[price.length-1] = tempArray[price.length-2];
				tempArray[price.length-2] = temp;
				dfs(curC+1, desC, index+1, tempArray);
			}
		}

	}

}
