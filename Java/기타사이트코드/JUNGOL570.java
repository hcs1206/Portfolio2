
public class JUNGOL570 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i < 1 || j < 1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				}

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		} // end of for
		
	} // end of main

} // end of class
