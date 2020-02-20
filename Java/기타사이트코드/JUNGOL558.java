import java.util.Scanner;

public class JUNGOL558 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[100];
		int i=0;
		for(i=0; i<100; i++) {
			int temp = sc.nextInt();
			if(temp == 0)
				break;
			else
				arr[i] = temp;
		}
		
		for(int j=i-1; j>=0; j--)
			System.out.println(arr[j]);

	}

}