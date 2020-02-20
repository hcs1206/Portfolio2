import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JUNGOL563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<10; i++){
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=9; i>=0; i--) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
}