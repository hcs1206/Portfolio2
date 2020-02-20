# Week3_day1 Summary

## Java 설치

환경변수 : 명령어가 있는 위치를 검사하는 path(내 PC->고급 시스템 설정->환경변수)

bin : 실행파일

include, lib : 사용 API

이클립스 ee 버전 다운



## Java

- computing : 효율

- Write once, Run Anywhere
- <u>C 언어의 어려움</u> 극복
  - 메모리 접근, 할당, 수거 -> JVM으로 극복
  - 운영체제마다 최적화 필요 -> JRE(Java Runtime Enviroment)가 해결
- 객체지향(Language 적 특징)
- 파일명과 대표 클래스명(public이 붙은)은 일치해야한다



## Naming

- class naming- 첫문자 대문자, 띄어쓰기 첫문자, 숫자가능(맨앞x), <u>특수문자 $ underbar 가능</u> 비추

- variable, method naming :  첫문자 소문자, 숫자 가능(맨앞 x), 특수문자 x

  ![image-20200120140126203](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20200120140126203.png)

  ![image-20200120140227799](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20200120140227799.png)



## Java의 complie

- java는 컴파일 방식과 인터프리터 방식의 중간으로 작동, JVM이 이를 실행시켜주기에

  어떠한 운영체제라도 상관없이 작동할 수 있다

![image-20200120135953150](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20200120135953150.png)



## Data Type

Privimitive Data Types(8개) : 

- 정수 : byte(8), short(16), int(32) , long(64)
- 실수 : float(32), double(64)
- 논리 : boolean
- 문자 : char(16)



```java
/*
 * class 명:
 * class 설명:
 * 작성자:
 * 작성 일시 :
 * 작성 요구사항:
 * 요청자:
 * 요청자 요구사항:
 */
public class HelloTest {
	
	/*
	 * method 명:
	 * method 설명:
	 * 작성자:
	 * 작성 일시 :
	 * 작성 요구사항:
	 * 요청자:
	 * 요청자 요구사항:
	 * 버전:
	 * parameter :
	 * return type :
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello world");//표준 출력

	}//main

}//class HelloTest
```

```java

public class Var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 7;
		short s = 88;
		int i = 999;
		long l = 9999L; // L을 안붙히면 int로 인식
		float f = 0.123456789F; // 소수점 7자리까지 신뢰
		double d = 0.1234567890123456789; // 소수점 15자리까지 신뢰
		double d2 = 789789789789.789789789789;
		boolean bool = false;
		char c = 'Y';
		double d3 = 1234567.12345678912;
		System.out.println(d3);
		System.out.println(f);
		System.out.println(d);
		System.out.println(d2);

	}//main

}//class
```

```java

public class Var2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1= -128;
		byte b2 = 127;
		byte b3 = (byte) 128; // demotion, 명시적 casting
		byte b4 = (byte) 129;
		
		System.out.println(b1);
		System.out.println(b2);
		int i= b2; // auto casting, promotion, 묵시적 casting
		System.out.println(b3);
		System.out.println(b4);

	}//main

}//class
```

```java
public class Var4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 5;
		byte b2 = 5;
		//byte b3 = b1+b2; // 기본형 datatype인 int로 변환
		//byte b4 = (byte))b1 + (byte)b2; // 연산결과가 int형이기에 오류
		byte b5 = (byte)(b1+b2); // 옳은 표현

	}//main
}//class
```

```java
public class Var5 {
    public static void main(String[] args){
        ImsiTest1 it1 = new ImsiTest1();
        // Reference datatype은 반드시 new라는 키워드를 사용해야
        // 메모리에 올려놓을 수 있다.
        it1.i = 7;
        System.out.println(it1.i);
        
        //예외 - String
        String s1 = new String("hi");
        String s2 = "hello";
        s2 = s2+" everyone !!!";
        
    }//main
}//class

class ImsiTest1{
    int i = 0;
}//class
```

```java
import java.util.ArrayList;

public class ForEach1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hi");
		list1.add("hello");
		list1.add("good");
		System.out.println(list1);
		for(String s : list1) {
			System.out.println(s);
		}
	}
}
```

