import java.util.Scanner;

public class JUNGOL555 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] save = new char[10];
		for(int i=0; i<10; i++) {
			save[i] = sc.next().charAt(0);
		}
		
		for(int i=0; i<10; i++) {
			System.out.print(save[i]);
		}

	}

}
