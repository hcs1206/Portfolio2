# final, abstract, static

## final

```java
/*
 * final keyword : 최종 정의
 * - final 변수 : 상수화, 최초 대입후 값 변경 불가
 * - final 메소드 : override 불가
 * - final 클래스 : 상속 불가
 * - 상수의 naming rule : 모두 대문자, 단어가 이어질 때 _
 */

final class SuperB{
	
}

//class ChildX extends SuperB{} // 상속 불가

class SuperA{
	public void go() {}
	public final void go2() {}
}

class ChildZ extends SuperA{
	public void go() {
		System.out.println("override");
	}
	
//	public final void go2() {}; overide 불가
}

public class TepFinal {
	public static void main(String[] args) {
		int intA = 7;
		intA = 999;
		final int FINAL_INT_A;
		FINAL_INT_A = 999; // 최초 대입
//		FINAL_INT_A = 7; // 값 변경 불가
		
		
	}
}

```



## Abstract

```java
/*
 * abstract : 미완성
 * abstract method : 구현부{}가 없는
 * abstract class
 *  - 미완성 class : 객체 생성 불가
 */

abstract class SuperC{
	public abstract void name();
}
public class TmpAbstract {
	public static void main(String[] args) {
//		SuperC c = new SuperC();
	}
}
```



## Static

```java
/*
 * 자바에서 메모리를 확보하는 방법 : static, new
 * - static 영역 : ClassLoader가 class를 메모리에 올릴때
 * 				static 선언 부분은 먼저 메모리를 할당함.
 * - new : 메모리에 객체를 올리라고 JVM에게 명령
 * - static : className.static변수명/static메소드명
 * - non-static : new를 통해 생성된 객체참조변수.변수명/메소드명
 */
public class Static1Declare {
	public int nonVar = 3;
	public static int sVar = 999;
	public void nonMethod() {}
	public static void staticMethod() {System.out.println("s~~~");}
	public static void main(String[] args) {
		Static1Declare.sVar = 12345;
		//Static1Declare.nonVar = 11111;
		Static1Declare.staticMethod();
		//Static1Declare.nonMethod();
		Static1Declare ddd= new Static1Declare();
		System.out.println(ddd.sVar);
		System.out.println(ddd.nonVar);
		ddd.nonMethod();
		ddd.staticMethod();
		Static1Declare ddd2 = new Static1Declare();
		ddd2.sVar = 98765;
		System.out.println(ddd.sVar);
		// static 영역은 하나만 만들어져서 공유된다.
	}

}
```

```java
class OnlyOne{
	int intVar;
	static int staticIntVar;
	public OnlyOne() {
		intVar++;
		staticIntVar++;
	}
}
public class Static2OnlyOne {

	public static void main(String[] args) {
		OnlyOne oo = new OnlyOne();
		System.out.println(oo.intVar + " : " + oo.staticIntVar);
		OnlyOne oo2 = new OnlyOne();
		System.out.println(oo.intVar + " : " + oo2.staticIntVar);
		
	}
}
```

```java
class StaticSuper{
	public void nonStaticMethod() {
		System.out.println("super--non");
	}
	public static void staticMethod() {
		System.out.println("super--static");
	}
}

class StaticChild extends StaticSuper{
	public void nonStaticMethod() {
		System.out.println("child--non");
	}
	
	public static void staticMethod() {
		System.out.println("child--static");
	}
	//static 메소드 override시 static도 가져온다.
	// 사실은 또다른 static 메소드를 만든셈이 됨(override 아님)
}
/*
 * static 메소드 override
 * - override 불가
 * - 부모의 static 영역과 자식의 static 영역이 따로 존재, 따로 호출해야함
 * - 부모ClassName.자식의 static 영역, 자식ClassName.자식의 static 영역 
 */
public class Static3Inherit {
	public static void main(String[] args) {
		StaticSuper s1 = new StaticChild();
		s1.nonStaticMethod(); // override 적용
		s1.staticMethod(); // override 적용 x
		StaticChild c1 = new StaticChild();
		c1.staticMethod();
	}
}
```

```java
/*
 * Static4Initializer
 * - 1객체 생성 시에 1회성으로 돌아가는 코드를 배치할 수 있음.
 * - class load 시에 동작.
 * - 생성자는 객체 만들때마다 동작
 * - Static initializer는 class load 시에 최초 한번만 동작
 */

class InitializerTest{
	static int a = 0;
	static {
		System.out.println("static runn~~");
		a = 999;
	}
}
public class Static4Initailizer {
	
	
	public static void main(String[] args) {
		InitializerTest it = new InitializerTest();
		System.out.println(it.a);
		InitializerTest it2 = new InitializerTest();
		System.out.println(it2.a);
	}

}
```

