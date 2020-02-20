# Calendar, Exception, IO, Inner, TreeMap, TreeSet, Vector

## Calendar

```java
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
//		Date d = new Date();
//		System.out.println(d.getYear());
//		System.out.println(d.getMonth()+1);//month:0~11
//		System.out.println(d.getDate());
//		System.out.println(d.getDay());//day:0(일) 1 2 3 4 5 6(토)
//		System.out.println(d.getTime());
//		System.out.println(d.getMinutes());
//		System.out.println(d.getSeconds());
	}

}
```

## Exception

```java
import java.io.FileReader;
import java.util.ArrayList;

/*
 * Java Error 종류
 * - compile error : 문법 오류. -> 코드 수정으로 해결.
 * - runtime error : 실행 중 오류. fatal과 exception으로 구분.
 * - fatal error : 구조적 오류.
 * Exception : 예외 상황.
 * - 프로그래머가 예상치 못한 실행 중의 문제 발생.
 * 예) DBMS 접속 중, DBMS 전원 다운, 인터넷 접속 중 인터넷선 플러그 아웃.
 * Exception Handling : 예외 상황 처리.
 * - 예외상황 발생 시에, 오작동 방지, 안내 처리, 프로그램 종료 등의 처리.
 * - 예외 처리를 통해, 로그를 남겨서, 이후에 조치 가능하도록 함.
 * Exception 전달 과정.
 * - 프로그램 실행 과정 : program -> jvm에 의해 실행
 * - Exception 전달 과정 : jvm -> program
 * - jvm은 발생한 Exception에 대한 자세한 정보를 객체로 만들어서 전달함.
 * Exception 상속 구조 중요!!! - Polymorphism 적용!!!
 */
public class Exception1OverView {

	public static void main(String[] args) {
		//System.out.println(args[0]);//ArrayIndexOutOfBoundsException
		ArrayList list = null;
		//System.out.println(list.get(0));//NullPointerException
		System.out.println(999/0);//ArithmeticException
		//Integer.parseInt("안녕");//NumberFormatException
//		list = new ArrayList();
//		list.add(new Exception1OverView());
//		TreeMapTest e1o = (TreeMapTest) list.get(0);//ClassCastException
	}

}
```

```java
import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * Exception 처리 방법.
 * - Exception 발생할 수 있는 프로그램 코드에 포위망 설치(try{})
 * - 발생한 Exception 객체를 받을 수 있는 처리 블록을 설치(catch(Exception객체를 받자){})
 * - 발생한 Exception 객체에 따른 처리 가능.
 * try ~ catch : 반드시 try와 catch는 함게 사용.
 * - 하나의 try에 여러 catch 올 수 있음.
 */
public class Exception2TryCatch {

	public static void main(String[] args) {
		try {
			String s = null;
			System.out.println(s.length());
			System.out.println(999/0);
			FileReader fr = new FileReader("aaa.txt");
		} catch(ArithmeticException e) {
			System.out.println("계산 오류 입니다.\n시스템을 종료 합니다.");
			System.exit(-1);
		} catch (NullPointerException e) {
			System.out.println("시스템 관리자에게 문의하세요.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못하였습니다.\n파일을 확인해 주세요.");
		}
	}//main

}

```

```java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Exception 간의 상속 관계를 고려해야 함!!!
 * FileNotFoundException -> IOException -> Exception
 * - 자식 타입의 객체를 부모 타입의 변수로 받을 수 있음.
 * - Exception 객체가 IOException과 FileNotFoundException을 모두 받을 수 있음.
 * - catch문 사용시, Exception 상속에서 sub class를 위로, super class를 아래로 배치!!!
 */
public class Exception3Inheritance {

	public static void main(String[] args) {
		try{
			FileReader fr = new FileReader("aaa.txt");
		} catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException 처리");
		} catch(IOException e) {
			System.out.println("IOException의 sub class중"
					+ " FileNotFoundException이 아닌 모든 IOException 처리");
		} catch(Exception e) {
			System.out.println("모든 Exception 처리");
		}
		//=========================================
		try {
			String s = null; System.out.println(s.length());//nullpointerexception
			FileReader fr = new FileReader("aaa.txt");
		} catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException 처리");
		} catch (NullPointerException e) {
		}
		//=========================================
		try {
			String s = null; System.out.println(s.length());//nullpointerexception
			FileReader fr = new FileReader("aaa.txt");
		} catch(FileNotFoundException | NullPointerException e) {
			System.out.println("FileNotFoundException 처리");
			System.out.println("\n또는 NullPointerException 처리");
		}//하나의 catch문에서 여러 exception 처리 가능.
	}//main

}

```

```java
import java.io.EOFException;

/*
 * finally : try문의 뒷처리.
 * - 예외 발생 여부와 무관하게, 반드시 수행되는 코드.
 */
public class Exception4Finally {

	public static void main(String[] args) {
		try {
			System.out.println("Exception 발생 없음.");
		} catch (Exception e) {
			System.out.println("따라서, catch문 수행 안함.");
		} finally {
			System.out.println("반드시 수행.");
		}
		//=============================================
		try {
			System.out.println("Exception 발생.");
			System.out.println(999/0);
		} catch (Exception e) {
			System.out.println("catch문 수행.");
		} finally {
			System.out.println("반드시 수행.");
		}
		//예)=============================================
		try {
			System.out.println("파일을 오픈하였으나, EOFException 발생.");
			throw new EOFException();
		} catch (Exception e) {
			System.out.println("파일이 비었습니다.\n파일을 확인 하세요.");
		} finally {
			System.out.println("파일 닫기.");
		}
	}//main

}

```

```java
/*
 * throw : Exception을 발생 시키는 표현.
 * throws : Exception을 Exception이 발생한 코드를 호출한 놈에게 떠넘기는 표현.
 * - 호출한 곳에서 처리하라.
 */
public class Exception5Throws {
	public void throwNullPointer() {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			System.out.println("Exception 발생 지점에서 처리.");
		}
	}
	public void idCheck(String id) throws NullPointerException {
		if(!id.equals("SSAFY")) {
			throw new NullPointerException();
		}
	}
	public static void main(String[] args) {
		Exception5Throws e5 = new Exception5Throws();
		e5.throwNullPointer();
		try {
			e5.idCheck("ssafy");
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 ID 입니다.");
			System.out.println("Exception 호출한 지점에서 처리.");
		}
	}

}

```

```java
import java.io.FileNotFoundException;
import java.io.IOException;

//FileNotFoundException-▷IOException-▷Exception
class OESuper {
	public void name() throws IOException {}
	public IOException gogo() {return new IOException();}
}
class OEChild extends OESuper {
	//public void name() throws IOException {}//똑같은 경우 ok.
	//public void name() {}//throws 없애도 된다.
	public void name() throws FileNotFoundException {}
	//throws에 선언된 IOException의 상속에서의 하위class는 선언 ok.

	//public void name() throws Exception {}//error
	//throws에 선언된 IOException의 상속에서의 상위class를 선언할 수 없다.

	//public IOException gogo() {return new IOException();}//똑같은 경우 ok.
	public FileNotFoundException gogo() {return new FileNotFoundException();}
	//return type에 선언된 IOException의 상속에서의 하위class는 선언 ok.

	//public void gogo() {}//error//return type 바꿀 수 없음.
	//public Exception gogo() {return new IOException();}//error
	//return type에 선언된 IOException의 상속에서의 상위class를 선언할 수 없다.
}

public class Exception6Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

```

```java
/*
 * User Defined Exception
 * - 프로그래머가 상황에 따른 Exception을 만들어 사용 가능.
 * - Exception을 extends 받는 class 작성.
 */
class MyExceptionClass extends Exception {}
public class Exception7UserDefined {

	public static void main(String[] args) throws MyExceptionClass {
		throw new MyExceptionClass();

	}

}

```

```java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * try문에서 자원을 자동 해제하는 방법.(자바7부터 사용.)
 * - implements AutoCloseable ->  @Override close()
 */
class AutoCloseTest implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("자동 자원 해제...");
	}
}
class AutoCloseTest2 implements AutoCloseable {
	FileReader fr;
	@Override
	public void close() throws IOException {
		System.out.println("자동 자원 해제...");
		//fr.close();
	}
}
public class Exception8Resources {
	public static void main(String[] args) {
		try(AutoCloseTest2 at2 = new AutoCloseTest2()) {
			//at2.fr = new FileReader("aaa.txt");
		} catch (IOException e) {
			System.out.println("IOException 처리...");
			//e.printStackTrace();
		}
//		try(AutoCloseTest at = new AutoCloseTest()){
//			throw new FileNotFoundException();
//		} catch(Exception e) {
//			System.out.println("Exception 처리...");
//		}

	}//main

}

```

## IO

```java
/*
 * IO : InputStream & OutputStream
 * - Stream : data의 이동을 의미.
 * - Input : 외부에서 myProgram으로 data 이동.
 * - Output : myProgram에서 외부로 data 이동.
 * - node(기반) : data source와 destination을 연결하는 기능.
 *               예)FileInputStream, FileOutputStream
 * - filter(조작) : data 가공 또는 용이한 접근을 제공.
 *                 예) InputStreamReader, OutputStreamWriter(8bit -> 16bit 변환)
 * - byte(8bit) : 입출력 단위가 8bit. 비영어권 문자 표현에 제약있음.
 *                class name이 InputStream, OutputStream으로 끝남.
 * - char(16bit) : 입출력 단위가 16bit. 비영어권 문자 표현 가능.
 *                 class name이 Reader, Writer으로 끝남.
 * - Stream의 조합 시, 주의 사항. : Reader는 Reader끼리, InputStream은 InputStream끼리.
 *                            Writer는 Writer끼리, OutputStream은 OutputStream끼리.
 * - 주의!!! : 생성한 IO 객체는 반드시 close() 해야 함!!!
 *            close() 할 때는 생성의 역순으로!!!
 * - flush() : Writer와 OutputStream에서 data 강제 밀어내기.
 */
public class IO1OverView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

```

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IO2File {

	public static void main(String[] args) {
		//File f = new File("C:\\SSAFY\\workspace\\01_javabasic\\src\\filetest.txt");
//		FileInputStream fis
//		= new FileInputStream("C:\\SSAFY\\workspace\\01_javabasic\\src\\filetest.txt");
		FileInputStream fis2 = null;
		try {
			File f1 = new File((new File(".").getCanonicalPath())+"\\src\\filetest.txt");
			fis2 = new FileInputStream(f1);
			int i=0;
			while((i=fis2.read()) != -1) {//-1:EndOfFile
				System.out.print((char)i);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();//Exception 정보 출력.
		} catch(IOException e) {
			e.printStackTrace();//Exception 정보 출력.
		} finally {
			try {
				fis2.close();
			} catch (IOException e) {
				e.printStackTrace();//Exception 정보 출력.
			}
		}
//		try(FileInputStream fis2 = new FileInputStream(f1)) {//java1.7 이상만 가능.
//		} catch(IOException e) {
//			
//		} finally {
//		}

	}//main

}

```

```java
import java.io.File;

public class IO2File2 {

	public static void main(String[] args) {
		File f1 = new File("C:\\SSAFY");
		System.out.println("canRead : "+f1.canRead());
		System.out.println("canWrite : "+f1.canWrite());
		System.out.println("canExecute : "+f1.canExecute());
		System.out.println("isDirectory : "+f1.isDirectory());
		System.out.println("isFile : "+f1.isFile());
		System.out.println("getAbsolutePath : "+f1.getAbsolutePath());
		System.out.println("getParent : "+f1.getParent());
		System.out.println("getPath : "+f1.getPath());
		System.out.println("getName : "+f1.getName());
		String [] ssaffyDir = f1.list();
//		for(String tmp : ssaffyDir) {
//			System.out.println(tmp);
//		}
		File [] ssaffyDir2 = f1.listFiles();
		for(File f : ssaffyDir2) {
			System.out.println(f);
		}
	}//main

}

```

```java
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class IO2File3 {
	ArrayList<File> list = new ArrayList<File>();
	public static void main(String[] args) {
		File f1 = new File("C:\\SSAFY_INS\\upload_workshop_java");
		//특정 폴더에 있는 모든 폴더와 모든 파일을 리스트하시오.
		//폴더가 있는 경우, 그 하위의 모든 폴더와 모든 파일도 리스트 하시오.
		IO2File3 io2 = new IO2File3();
		io2.addList(f1);
		for(int i=0; i<io2.list.size(); i++) {
			File f = io2.list.get(i);
//			io2.list.add(f);
			if(f.isDirectory()) {
				io2.addList(f);
				System.out.println(f);
			}
		}
		for(File f : io2.list) {
			System.out.println(f);
		}
	}//main
	public void addList(File dir) {
		File [] tmpArr = dir.listFiles();
		for(File tmp : tmpArr) {
			this.list.add(tmp);
		}
	}
}


```

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO4FileReadWrite {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			File inFile = new File((new File(".").getCanonicalPath())
					+"\\src\\filetest2.txt");
			File outFile = new File((new File(".").getCanonicalPath())
					+"\\src\\filetestcopy2.txt");
			fr = new FileReader(inFile);
			fw = new FileWriter(outFile);
			int i=0;
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
				fw.write(i);
			}
			fw.write("와우~추워요...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}//main

}

```

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * InputStreamReader : 8bit입력 -> 16bit입력
 * OutputStreamWriter : 8bit출력 -> 16bit출력
 */
public class IO5ReadWriteFiler {

	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			File inFile = new File((new File(".").getCanonicalPath())
														+"\\src\\filetest2.txt");
			File outFile = new File((new File(".").getCanonicalPath())
														+"\\src\\filetestcopy2.txt");
			fis = new FileInputStream(inFile);
			isr = new InputStreamReader(fis);
			fos = new FileOutputStream(outFile);
			osw = new OutputStreamWriter(fos);
			int i=0;
			while((i=isr.read()) != -1) {
				System.out.print((char)i);
				osw.write(i);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();//close는 생성의 역순으로...
				fis.close();
				osw.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

```

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * DataInputStream & DataOutputStream
 */
public class IO6DataInOut {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			File outFile = new File((new File(".").getCanonicalPath())
													+"\\src\\dataout.dat");
			fos = new FileOutputStream(outFile);
			dos = new DataOutputStream(fos);
			dos.writeByte(127);dos.writeShort(1270);
			dos.writeInt(12700);dos.writeLong(127000L);
			dos.writeFloat(3.14F);dos.writeDouble(0.999);
			dos.writeBoolean(false);dos.writeChar('A');
			dos.writeUTF("data out stream...");
			fis = new FileInputStream(outFile);
			dis = new DataInputStream(fis);
			String tmp = dis.readByte()+" : "+dis.readShort()+" : "+
			dis.readInt()+" : "+dis.readLong()+" : "+
			dis.readFloat()+" : "+dis.readDouble()+" : "+
			dis.readBoolean()+" : "+dis.readChar()+" : "+
			dis.readUTF();
			System.out.println(tmp);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
				dis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}


```

```java
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * VO : Value Object
 * DTO : Data Transfer Object
 */
class OOTestVO implements Serializable {
	private String name;
	private String telNo;
	OOTestVO(String name, String tel){
		this.name = name;
		this.telNo = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	@Override
		public String toString() {
			return name+" : "+telNo;
		}
}
public class IO7ObjectInOut {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			File outFile = new File((new File(".").getCanonicalPath())
														+"\\src\\objectout.dat");
			fos = new FileOutputStream(outFile);
			oos = new ObjectOutputStream(fos);
			fis = new FileInputStream(outFile);
			ois = new ObjectInputStream(fis);
			OOTestVO vo = new OOTestVO("유재석","010");
			oos.writeObject(vo);
			OOTestVO vo2 = new OOTestVO("강호동","011");
			oos.writeObject(vo2);
			oos.flush();
			//===================
			OOTestVO tmpVO = null;
			while((tmpVO=(OOTestVO)ois.readObject()) != null) {
				System.out.println(tmpVO);
			}
		} catch (EOFException e) {
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

```

```java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IO8BufferedPrint {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			File inFile = new File((new File(".").getCanonicalPath())
													+"\\src\\filetest2.txt");
			File outFile = new File((new File(".").getCanonicalPath())
													+"\\src\\filetestcopy2.txt");
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);
			pw = new PrintWriter(outFile);
			String str = null;
			while((str=br.readLine()) != null) {
				System.out.println(str);
				pw.println(str);
			}
			pw.println("PrintWriter 사용...");
			pw.flush();//data가 출력이 안되는 상황에서 강제 밀어내기.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//main

}

```

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class TelNote implements Serializable {
	private String name;
	private String telNo;
	TelNote(String name, String tel){
		this.name = name;
		this.telNo = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	@Override
		public String toString() {
			return name+" : "+telNo;
		}
}//class
public class IO9TelBookTest {
	File outFile = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	Scanner scan = null;
	IO9TelBookTest(){
		try {
			outFile = new File((new File(".").getCanonicalPath())+"\\src\\telbook.dat");
			scan = new Scanner(System.in);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("전화번호부 생성에 실패 하였습니다.");
		}
	}//constructor
	public static void main(String[] args) {
		//전화번호부 입력기를 만들자.
		//ObjectOutputStream을 사용하여, 파일에 전화번호부 입력, 출력.
		//검색, 수정, 삭제 없음.
		IO9TelBookTest telBook = new IO9TelBookTest();
		System.out.println("========전화번호부========");
		int menuNo=0;
		while(true) {
			System.out.print("0:종료, 1:입력, 2:출력, 선택 : ");
			menuNo = telBook.scan.nextInt();
			if(menuNo == 0){
				telBook.scan.close();
				break;
			} else if(menuNo == 1){
				telBook.insertData();
			} else if(menuNo == 2){
				telBook.printData();
			}
		}//while
	}//main
	private void insertData() {
		System.out.print("이름 : ");
		String tmpName = scan.next();
		System.out.print("전화번호 : ");
		String tmpTel = scan.next();
		try {
			fos = new FileOutputStream(outFile, true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new TelNote(tmpName, tmpTel));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//insertData
	private void printData() {
		try {
			fis = new FileInputStream(outFile);
			ois = new ObjectInputStream(fis);
			TelNote tmpVO = null;
			while((tmpVO=(TelNote)ois.readObject()) != null) {
				System.out.println(tmpVO);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//printData

}//class

```

```java
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReadTest {

	public static void main(String[] args) throws IOException {
//		InputStream in = Test.class.getResourceAsStream("aaa.txt");
//		BufferedReader br = new BufferedReader(new InputStreamReader(in));
//		String line = null;
//		while((line=br.readLine())!=null){
//			System.out.println(line);
//		}
		System.out.println(new File(".").getCanonicalPath());
		System.out.println((new File(".").getCanonicalPath())+"\\src\\aaa.txt");
//		FileInputStream fis = new FileInputStream((new File(".").getCanonicalPath())+"\\src\\aaa.txt");
//		int i=0;
//		while((i=fis.read())!=-1) {
//			System.out.print((char)i);
//		}
//		FileReader fr = new FileReader((new File(".").getCanonicalPath())+"\\src\\aaa.txt");
//		int i=0;
//		while((i=fr.read())!=-1) {
//			System.out.print((char)i);
//		}
	}

}

```

## InnerClass

```java
import java.net.InterfaceAddress;

/*
 * inner class : class 내부의 class
 * - instance inner class : 멤버 자리에 위치.
 * - static inner class : static으로 선언된 inner class. non-static 접근 불가.
 * - local inner class : 메소드 내부에 있음. 이너 클래스를 감싼 메소드가 호출 받았을 때만 메모리에 존재.
 * - anonymous inner class : 참조 변수가 없음. 일회용.
 */
public class InnerClass1OverView {
	//instance inner class
	public class InnerA {}
	protected class InnerB{}
	class InnerC{}
	private class InnerD{}
	abstract class InnerE {}
	interface InnerF {}
	interface InnerG {}
	public class InnerH extends InnerE implements InnerF, InnerG {}
	//static inner class
	static class InnerI {}
	//local inner class
	public void localMethod() {
		class InnerK {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//protected class AAA{}//error

```

```java
/*
 * instance inner class
 * - static 선언이 불가.
 */
public class InnerClass2Instance {//outer class
	private int number = 777;
	private static int number2 = 999;

	public class InstanceInner {//inner class
		//static int innerNumber2 = 111;//error
		int innerNumber = 555;
		public void innerM() {
			System.out.println("outer 변수 : "+number);
			System.out.println("outer 변수 : "+number2);
		}
		//public static void name() {}//error
	}

	public static void main(String[] args) {
		InnerClass2Instance ic2 = new InnerClass2Instance();
		InnerClass2Instance.InstanceInner ic2inner
			= ic2.new InstanceInner();
		ic2inner.innerM();
		System.out.println(ic2inner.innerNumber);
	}

}


```

```java
public class InnerClass3Static {//outer class
	private int number = 777;
	private static int number2 = 999;

	public static class InstanceInner {//inner class
		static int innerNumber2 = 111;
		int innerNumber = 555;
		public void innerM() {
			//System.out.println("outer 변수 : "+number);//error
			System.out.println("outer 변수 : "+number2);
		}
		public static void name() {System.out.println("inner static method...");}
	}

	public static void main(String[] args) {
		InnerClass3Static.InstanceInner.name();
		System.out.println(InnerClass3Static.InstanceInner.innerNumber2);
		InnerClass3Static.InstanceInner inner = new InnerClass3Static.InstanceInner();
		inner.innerM();
	}

}

```

```java

public class InnerClass4Local {
	private int number = 777;
	private static int number2 = 999;

	public void outerM(int aaa) {
		int bbb=111;
		class LocalInner {
			//bbb = 222;//error - LocalInner를 감싼 메소드의 변수는 상수로 인식.
			public void name() {
				System.out.println(aaa);
				System.out.println(bbb);
				System.out.println(number);
				System.out.println(number2);
			}
		}//class
		new LocalInner().name();
	}

	public static void main(String[] args) {
		InnerClass4Local out = new InnerClass4Local();
		out.outerM(789);

	}

}

```

## Collections

```java
import java.util.Arrays;
import java.util.Comparator;

class ComTest implements Comparable<ComTest> {
	Integer test;
	ComTest(int i){ test = i; }
	@Override
	public int compareTo(ComTest o) {
		// TODO Auto-generated method stub
		return this.test.compareTo(o.test);
	}
	@Override
	public String toString() {
		return ""+test;
	}
}
public class Inner5Anonym {

	public static void main(String[] args) {
		ComTest [] test = {new ComTest(555), new ComTest(111), new ComTest(333)};
		Arrays.sort(test);
		System.out.println(Arrays.toString(test));
		Arrays.sort(test, new Comparator<ComTest>() {
			@Override
			public int compare(ComTest o1, ComTest o2) {
				return o2.test.compareTo(o1.test);
			}
		});
		System.out.println(Arrays.toString(test));
	}

}

```

```java
import java.util.TreeMap;
class TreeMapKeyObj implements Comparable<TreeMapKeyObj> {
	Integer no;
	TreeMapKeyObj(int i){ no = i; }
	@Override
	public int compareTo(TreeMapKeyObj o) {
		return this.no.compareTo(o.no);
	}
	@Override
	public String toString() {
		return ""+no;
	}
}
class TreeMapValueObj {
	String str;
	TreeMapValueObj(String s){ str = s; }
	@Override
	public String toString() {
		return str;
	}
}
public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<TreeMapKeyObj, TreeMapValueObj> map3
									= new TreeMap<TreeMapKeyObj, TreeMapValueObj>();
		map3.put(new TreeMapKeyObj(5), new TreeMapValueObj("gogo"));
		map3.put(new TreeMapKeyObj(4), new TreeMapValueObj("hi"));
		map3.put(new TreeMapKeyObj(9), new TreeMapValueObj("bye"));
		map3.put(new TreeMapKeyObj(7), new TreeMapValueObj("hello"));
		System.out.println(map3);

		TreeMap<Integer, String> map1 = new TreeMap<Integer, String>();
		map1.put(5,"gogo");map1.put(4,"hi");map1.put(9,"bye");map1.put(7,"hello");
		System.out.println(map1);//key 중심 정렬.

		TreeMap<String, Integer> map2 = new TreeMap<String, Integer>();
		map2.put("gogo",5);map2.put("hi",4);map2.put("bye",9);map2.put("hello",7);
		System.out.println(map2);//key 중심 정렬.
	}

}

```

```java
import java.util.TreeSet;
class TreeSetTestObject implements Comparable<TreeSetTestObject> {
	Integer testNum;
	TreeSetTestObject(int i){ testNum = i; }
	@Override
	public int compareTo(TreeSetTestObject o) {
		return this.testNum.compareTo(o.testNum);
	}
	@Override
	public String toString() {
		return ""+testNum;
	}
}
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<TreeSetTestObject> ts3 = new TreeSet<TreeSetTestObject>();
		ts3.add(new TreeSetTestObject(555));ts3.add(new TreeSetTestObject(999));
		ts3.add(new TreeSetTestObject(111));ts3.add(new TreeSetTestObject(888));
		System.out.println(ts3);
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
		ts1.add(555);ts1.add(999);ts1.add(111);ts1.add(222);ts1.add(888);
//		Integer tmp = 444;//참고
		System.out.println(ts1);
		TreeSet<String> ts2 = new TreeSet<String>();
		ts2.add("hi");ts2.add("hello");ts2.add("bye");ts2.add("go");
		System.out.println(ts2);
	}

}

```

```java
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(3,3);
		v.add("hi");
		System.out.println("size : "+v.size());
		System.out.println("capacity : "+v.capacity());
		v.add("hello");
		v.add("how are you");
		v.add("i am fine");
		System.out.println("size : "+v.size());
		System.out.println("capacity : "+v.capacity());
		v.add("thanks");//add
	}

}

```

