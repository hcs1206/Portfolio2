# 순열,dr,부분집합,비트연산

자동 줄바꿈 : Ctrl+shift+F

## Baby-gin Game

- 어떻게 풀까? : 6장 중 3장을 선택하는 것이므로 나올 수 있는 조합은 20가지 밖에 없다
- 나의 가설이 맞는지 확인할 수 있어야한다
- 시험에서는 Brute-force 로 안전하게 진행하고 시간이 부족할때 성능개선을 한다



## 순열 만들기

```java
public class Z03_순열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		0, 1, 2		 3개의 원소를 순열로 출력하기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==j) continue;
//				for (int k = 0; k < 3; k++) {
//					if(i==k || j==k) continue;
					System.out.println(i+","+j+","+(3-i-j));
//				}
			}
		}
		// int형 이하의 타입은 이항연산시 int 형으로 자동형변환 된다

	}// end of main

} // end of class

```

- 순열 만드는 법
  - for 반복(빠르다), 구현이 불가능한 경우가 있을 수 있다.
  - 재귀 함수(느리다)



## dR, dC 사용

````java
import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[7][7];
		
		int temp = 0;
		for(int i=1; i<=5; i++)
		 for (int j = 1; j <= 5; j++) {
			arr[i][j] = temp++;
		}
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int answer = 0;
		temp = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				for (int dest = 0; dest < 4; dest++) {
					if(arr[i + dr[dest]][j + dc[dest]] == 0) {
						if(!(i + dr[dest] == 1 && j + dc[dest] == 1))
							continue;
					}
					temp += Math.abs(arr[i][j] - arr[i + dr[dest]][j + dc[dest]]);
					
				}
				answer += temp;
				System.out.print(temp + " ");
				temp = 0;
			}
			System.out.println();
		}
		
		System.out.println(answer);

	}

}

````



## 부분집합

```java
import java.util.Arrays;

/**
 * Subset : 부분집합
 * PowerSet(멱집합) : 어떤 집합의 모든 부분집합을 원소로 갖는 집합
 * 		반복문노가다
 * 		바이너리카운팅
 * 		재귀함수
 *
 */
public class Z05_Subset {

	public static void main(String[] args) {
		int[] a = {-7,-3,-2,5,8};
		
		for (int i = 0; i < 2; i++) { // 첫뻔째 원소를 사용할지 여부를 결정할 변수 i
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						for (int m = 0; m < 2; m++) {
							int sum = 0;
							if(i==1){System.out.print(a[0]+" "); sum += a[0];}
							if(j==1){System.out.print(a[1]+" "); sum += a[1];}
							if(k==1){System.out.print(a[2]+" "); sum += a[2];}
							if(l==1){System.out.print(a[3]+" "); sum += a[3];}
							if(m==1){System.out.print(a[4]+" "); sum += a[4];}
							System.out.println();
							if(sum == 0) System.out.println("\t : 합 " +  sum);
						}		
					}
				}
			}
		}
		
		
		int[] z = a;
		for (int i = 0; i < (1<<z.length); i++) { // 0~31
			for (int j = 0; j < z.length; j++) {
				if((i&1<<j) != 0) {
					System.out.print(z[j]+",");
				}
			}
			System.out.println();
		}
		
		
	} // end of main

} // end of class

```



## 비트연산

```java
/**
 * 연산자 : 단항, 이항, 삼항, 대입연산자 비트연산자 : 이항연산에 포함되는 연산자 << >> || && | & ^
 *
 */
public class Z06_비트연산 {

	public static void main(String[] args) {
		int a = 123; // 10진수
		System.out.println(a); // 10진수

		a = 0b110111; // 2진수 0b or 0B
//		a = 0110111; // 8진수 0
//		a = 0x110111; // 16진수 0x or 0X
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toString(a, 3)); // 하고 싶은 진법 설정

		int b = 0b1100; // 12
		int c = 0b1001; // 9
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(b & c));
		System.out.println(Integer.toBinaryString(b | c));

		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(1 << 0) + " =  1<<0");
		System.out.println(Integer.toBinaryString(1 << 1) + " =  1<<1");
		System.out.println(Integer.toBinaryString(1 << 2) + " =  1<<2");

//		비트마스킹 : 원하는 비트의 값만 뽑아내기
		System.out.println("비트마스킹");
		int n = 0b10011011;
		System.out.println((n & 0b1) == 0 ? 0 : 1);
		System.out.println((n & 0b10) == 0 ? 0 : 1);
		System.out.println((n & 0b100) == 0 ? 0 : 1);
		System.out.println((n & 0b1000) == 0 ? 0 : 1);
		System.out.println((n & 0b10000) == 0 ? 0 : 1);

		System.out.println("반복문으로 출력(쉬프트 연산자 활용)");
		for (int i = 0; i < 8; i++) {
			System.out.print((n & (1<<i)) == 0 ? 0 : 1);
		}

	} // end of main

} // end of class

```

