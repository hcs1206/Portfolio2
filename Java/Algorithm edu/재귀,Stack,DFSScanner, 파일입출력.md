# 재귀,Stack,DFSScanner, 파일입출력



## 재귀함수

```java

public class Z07_재귀함수 {
	public static int z = 10;

	// static은 먼저 생성된다
	public static void main(String[] args) {
		for (int i = 0; i < 400; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		a(0); // 시작값을 보냄, 0 1 2 3
		// static을 붙히지 않았다면 객체 생성 후 사용
		
		for (int i = 3; i > 0; i--) {
			System.out.print(i+ " ");
		}
		System.out.println();
		b(3);
		
		for (int i = 1; i <= 4; i++) {
			System.out.print(i*2 + " ");
		}
		System.out.println();
		c(2);
		
		d(3,2,10); // 초기값, 증감값, 조건기준값
		
		for (int i = 10; i >= 0; i = i-3) {
			System.out.print(i + " ");
		}
		System.out.println();
		e(10, 3, 0); // 초기값, 감소값, 조건기준값
		
//		1~10 까지의 합
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1~10까지 합 : " + sum);
		
		f(1,10); // 전역변수를 사용해서 합을 구해보자
		System.out.println("1~10까지 합 : " + total);
		
		System.out.println(f2(1,10)); // 리턴값을 사용해서 합을 구해보자
		
		int facto = 1;
		for (int i = 5; i > 0; i--) {
			facto *= i;
		}
		System.out.println("5! : " + facto);
		
		System.out.println("5! : " + g(1,5));

	} // end of main

//	리턴타입 매서드명 (매개변수)
	public static void a(int i) {
		if(i >= 4) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			a(i+1); // 증감식
		}
	}
	
	public static void b(int i) {
		if(i <= 0) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			b(i-1); // 증감식
		}
	}
	
	public static void c(int i) {
		if(i > 8) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			c(i+2); // 증감식
		}
	}
	
	public static void d(int start, int plus, int stop) {
		if(start > stop) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(start + " "); // 반복할 실행문
			d(start+plus, plus, stop); // 증감식
		}
	}
	
	public static void e(int start, int sub, int end) {
		if(start <= end) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(start + " "); // 반복할 실행문
			e(start-sub, sub, end); // 증감식
		}
	}
	
	public static int total = 0; // 변수 선언만 해도 전역변수는 각타입의 초기값이 들어간다

	public static void f(int start, int end) {
		if(start > end) { // basis case 종료파트
			return;
		} else { // inductive case 재귀파트
			total += start;
			f(start+1, end);
		}
	}
	
	public static int f2(int start, int end) {
		if(start == end) { // basis case 종료파트
			return start;
		} else { // inductive case 재귀파트
			return start+f2(start+1, end); // 1+(2~10까지의 합)
		}
	}
	
	public static int g(int start, int end) {
		if(start == end) { // basis case 종료파트
			return start;
		} else { // inductive case 재귀파트
			return start*g(start+1, end); // 
		}
	}
}
```

- 재귀 함수를 사용하는 방법
  - 전역변수 사용
  - 리턴 값을 이용하는 방법
  - 매개변수를 이용하는 방법



## 자료구조

- 선형(1:1)
  - 다음 위치가 정확히 어딘지 알고있다
  - 배열, 리스트, 스택, 큐, 덱
  - 쉬운 문제 풀이
- 비선형(1:N, N:N)
  - 그래프
    - 용어
    - 저장방식
    - 순회/탐색
  - 어려운 문제 풀이

## Stack

```java
import java.util.Stack;

/**
 * stack : 선형 자료구조 LIFO 구조
 */
public class Z12_Stack {

	public static int[] stack = new int[3];
	public static int top = -1;

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());

////		API 활용하기 : 현업
//		Stack st = new Stack();
//		st.push(4);
//		st.push(5);
//		st.push(6);
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());
			
		
		// 실전 알고리즘에서는 아래와 같이
		int[] stack = new int[4]; // 필요한 만큼만
		int topp = -1;
		stack[++topp] = 10;
		stack[++topp] = 20;
		stack[++topp] = 30;
		System.out.println(stack[topp--]);
		System.out.println(stack[topp--]);
		System.out.println(stack[topp--]);
		

	} // end of main

	/** 스택 */
	public static int pop() {
		if(isEmpty()) {
			System.out.println("underflow Error");
			return -1; // Exception handling을 해야한다
		} else {
			return stack[top--];
		}
	}

	private static boolean isEmpty() {
		// TODO Auto-generated method stub
		return top <= -1;
	}

	/** 스택에 데이터 삽입 */
	public static void push(int data) {
		if (isFull()) {
			System.out.println("overflow Error");
		} else {
			top++;
			stack[top] = data;
		}
	}

	/** 스택이 꽉찼는지 판별 */
	public static boolean isFull() {
		return top >= stack.length - 1;
	}

//	public static class Stack {
//		int top = -1;
//		int[] arr;
//
//		public Stack() {
//			top = -1;
//		}
//
//		public void pop() {
//			if (top > -1) {
//				int[] arr2 = new int[arr.length - 1];
//				System.arraycopy(arr, 0, arr2, 0, arr.length - 1);
//				top--;
//
//				arr = arr2;
//			}
//		}
//
//		public void push(int num) {
//			if (top > -1) {
//				top++;
//				int[] arr2 = new int[arr.length + 1];
//				System.arraycopy(arr, 0, arr2, 0, arr.length);
//				arr2[top] = num;
//				arr = arr2;
//			} else {
//				top++;
//				arr = new int[1];
//				arr[top] = num;
//			}
//		}
//
//		public int top() {
//			if (top > -1) {
//				return arr[top];
//			}
//			return -1;
//		}
//
//		public boolean isEmpty() {
//			if (top >= 0)
//				return false;
//			else
//				return true;
//		}
//	}
}

```

- 스택의 활용
  - 괄호검사

```java
import java.util.Scanner;

public class Main_Practice_괄호검사 {

	public static void main(String[] args) {
		
		char[] stack = new char[30];
		int top = -1;
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
//		int i;
//		for(i=0; i<str.length(); i++) {
//			if(str.charAt(i) == ')') {
//				top--;
//				if(top < -1) {
//					break;
//				}
//			}
//			else {
//				++top;
//			}
//		}
//		
//		if(top == -1) {
//			System.out.println("괄호짝이 맞습니다.");
//		}
//		else {
//			System.out.println("괄호짝이 안맞습니다");
//		}
		
		
		
		stack[++top] = str.charAt(0);
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)  == ')' || str.charAt(i)  == '}' || str.charAt(i)  == ']') {
				if(stack[top] == str.charAt(i)-2 || stack[top] == str.charAt(i)-1) {
					top--;
					continue;
				}
				else {
					break;
				}
			}
			else {
				stack[++top] = str.charAt(i);
			}
		}
				

		if(top == -1) {
		System.out.println("괄호짝이 맞습니다.");
		}
		else {
			System.out.println("괄호짝이 안맞습니다");
		}
		

	} // end of main

}
```



## DFS

- 그래프의 순회 방법 중 하나(DFS, BFS, BestFS, 전위, 중위, 후위)
- 그래프 저장방법
  - 간선 배열(메모리는 좋지만, 시간이 오래걸림)
  - 인접 리스트
  - 인접 행렬

```java
import java.util.Scanner;
/**
 * DFS : 그래프 순회 방법중 하나
 * 		깊이우선 탐색, 갈수있는 길이 있으면 계속 고고싱, 막다른 길이면 이전 갈림길로 되돌아옴(스택)
 * 		모든 정점을 한번씩 방문하기위한 코드블럭
 */
public class Z13_DFS {
	public static void main(String[] args) {
		
		
		int[][] matrix = { // 그래프 저장 방법 : 인접행렬
				{}, // 0번 정점
//				 0 1 2 3 4 5 6 7
				{0,0,1,1,0,0,0,0}, // 1번 정점
				{0,1,0,0,1,1,0,0}, // 2번 정점
				{0,1,0,0,0,0,0,1}, // 3번 정점
				{0,0,1,0,0,0,1,0}, // 4번 정점
				{0,0,1,0,0,0,1,0}, // 5번 정점
				{0,0,0,0,1,1,0,1}, // 6번 정점
				{0,0,0,1,0,0,1,0}, // 7번 정점
		};
		
		Scanner sc = new Scanner(System.in);
		
		int[] stack = new int[100]; // 이전 갈림길로 돌아가기위해 가는 경로를 저장
		int top = -1;
		boolean[] visited = new boolean[matrix.length]; // 정점의 방문여부를 체크할 변수
		
//		DFS 순회
		int v = 1; // 시작 정점 지정
		visited[v] = true; // 정점 방문 체크
		stack[++top] = v; // 스택에 넣기
		System.out.print(v + " "); // 방문해서 할일(정점 번호 출력)
		
		while(top > -1) { // 스택이 비워질때까지 반복
			int w = -1; // 다음 갈 정점을 저장할 변수
			for (int i = 1; i < matrix[v].length; i++) { // 반복문으로
				if(matrix[v][i]==1 && !visited[i]) {// 인접한 정점 찾기, 미방문 정점 찾기
					w = i;
					visited[i] = true;// 정점 방문 체크
					stack[++top] = w;// 스택에 넣기
					System.out.print(w + " ");// 방문해서 할일(정점 번호 출력)
					v = w;
					break; // 갈 경로를 잘았으면 for반복 종료
				}	
			}
			if(w==-1) {
				v=stack[top--];// 못찾았으면 이전 갈림길로 되돌아가기(스택에서 꺼냄)
			}
		}
		
	} // end of main
} // end of class
```



## Scanner

- next(), nextInt(), nextBoolean(), nextLong() : 기본형 타입

  - 지정한 타입의 데이터를 버퍼에서 읽어온다

  - 데이터 앞의 화이트 스페이스를 제거하고 데이터만 리턴한다

    - _  /t /n /r 36 /t /n /r

      위와 같은 상황에서 앞에 화이트스페이스를 제거하고 원하는 정보 취득후
      종료하므로 뒤에 화이트 스페이스는 남아있다.

- nextLine()

  - String을 return
  - 엔터가 입력될때까지의 한줄을 버퍼에서 읽어온다
  - 엔터는 제거후 문자열을 리턴



## 계산기, 파일 입출력

- A*B-C/D 변환
  - ((A*B)-(C/D))
  - (AB*CD/)
  - AB*CD/-

| 토큰 | isp  | icp  |
| :--: | :--: | :--: |
|  )   |  -   |  -   |
| *,/  |  2   |  2   |
| +,-  |  1   |  1   |
|  (   |  0   |  3   |

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * 계산기1 중위표기식 => 후위표기식(스택을 사용) 6 + 5 * ( 2 - 8 ) / 2
 */

public class Z15_calculator {

	int[] weight = { 0, 1, 1, 2, 2 };

	public static void main(String[] args) throws FileNotFoundException {
		
		
//		파일 입력처리
		System.setIn(new FileInputStream("Test.txt"));
		Scanner sc = new Scanner(System.in);
		
//		문자열 입력처리
//		String string = "6 + 5 * ( 2 - 8 ) / 2";
//		Scanner sc = new Scanner(new StringReader(string));
		
//		키보드 입력처리
//		Scanner sc = new Scanner(System.in);
		
		
		// 엔터는 제거후 문자열을 리턴
//		===================================================
//		sc.next();
//		sc.nextInt();
//		sc.nextDouble();
//		// 기본형 타입계열 메서드
//		지정한 타입의 데이터를 버퍼에서 읽어온다
//		데이터 앞의 화이트 스페이스를 제거하고 데이터만 리턴한다

//		혼용해서 사용하면 좋지않다.

		String str = sc.nextLine();
		String[] srr = str.split(" ");
		String[] stack = new String[20];
		int top = -1;

		
		for (int i = 0; i < srr.length; i++) {
		
			// 스위치가 if문보다 빠르다
			switch (srr[i]) { // int형 범위 이하의 정수 or String 문자열
			case "(": // 스택에 무조건 넣는다
				stack[++top] = srr[i];
				break;
			case "*": // 스택에 2보다 작은 우선순위가 있을 때까지 꺼내서 출력
			case "/":
				while( top >= 0 && (stack[top].equals("*") || stack[top].equals("*") ) ) {
					System.out.print(stack[top--]);
				}
				stack[++top] = srr[i];
				
				break;
			case "+": // 스택에 1보다 작은 우선순위가 있을 때까지 꺼내서 출력
			case "-":	
				while( top >= 0 && !stack[top].equals("(") ) {
					System.out.println(stack[top--]);
				}
				stack[++top] = srr[i];
				
				break;
			case ")": // ( 여는 괄호가 나올때까지 모두 빼서 출력
				while(top>= 0 && !stack[top].equals("(")){
					System.out.print(stack[top--]);
				}
				top--;
				break;

			default: // 피연산자(숫자)
				
				System.out.print(srr[i]);
				break;
			}
		}
		
		while(top > -1) {
			System.out.print(stack[top--]);
		}
		
	} // end of main
} // end of class
```



## WS

```java
import java.util.Scanner;

public class Swea {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int T = sc.nextInt();
			String str = sc.next();
			char[] stack = new char[T];
			String back = "";
			int top = -1;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				// 스위치가 if문보다 빠르다
				switch (c) { // int형 범위 이하의 정수 or String 문자열
				case '(': // 스택에 무조건 넣는다
					stack[++top] = c;
					break;
				case '*': // 스택에 2보다 작은 우선순위가 있을 때까지 꺼내서 출력
				case '/':
					while (top >= 0 && (stack[top] == '*' || stack[top] == '*')) {
						back += stack[top--];
					}
					stack[++top] = c;

					break;
				case '+': // 스택에 1보다 작은 우선순위가 있을 때까지 꺼내서 출력
				case '-':
					while (top >= 0 && stack[top] != '(') {
						back += stack[top--];
					}
					stack[++top] = c;

					break;
				case ')': // ( 여는 괄호가 나올때까지 모두 빼서 출력
					while (top >= 0 && stack[top] != '(') {
						back += stack[top--];
					}
					top--;
					break;

				default: // 피연산자(숫자)
					back += c;
					break;
				}
			}

			while (top > -1) {
				back += stack[top--];
			}
						
			int[] stackBack = new int[T+1];
			int topBack = -1;
			
			for (int i = 0; i < back.length(); i++) {
				char c = back.charAt(i);
				int a,b;
				
				// 스위치가 if문보다 빠르다
				switch (c) { // int형 범위 이하의 정수 or String 문자열

				case '*': // 스택에 2보다 작은 우선순위가 있을 때까지 꺼내서 출력
					a = stackBack[topBack--];
					b = stackBack[topBack--];
					stackBack[++topBack] = b*a;
					break;
				case '/':
					a = stackBack[topBack--];
					b = stackBack[topBack--];
					stackBack[++topBack] = b/a;
					break;
				case '+': // 스택에 1보다 작은 우선순위가 있을 때까지 꺼내서 출력
					a = stackBack[topBack--];
					b = stackBack[topBack--];
					stackBack[++topBack] = b+a;
					break;
				case '-':
					a = stackBack[topBack--];
					b = stackBack[topBack--];
					stackBack[++topBack] = b-a;
					break;

				default: // 피연산자(숫자)
					stackBack[++topBack] = c-'0';
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + stackBack[topBack--]);
			
			
			
		} // end of testcase

	} // end of main
} // end of class
```

