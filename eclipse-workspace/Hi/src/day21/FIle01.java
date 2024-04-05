package day21;

public class FIle01 {

	public static void main(String[] args) {
		
		/*
		 * java.io.* 에서 제공하는 클래스들은 try~catch / throws를 해줘야함
		 * IOStream: 단방향으로 데이터가 흘러들어가는 형태
		 * 자바는 입력스트림, 출력스트림을 통해 데이터를 입출력한다.
		 * 다양한 장치에 독립적이고, 일관성있는 입출력을 유지하기 위해
		 * 입출력 스트림을 통해 일관성을 제공
		 * 
		 * 두가지 형태의 스트림
		 * - 바이트 형태의 스트림 : 기본(문자, 그림, 동영상(멀티미디어))
		 * - 문자 형태의 스트림 : 문자만 입출력할 때 사용
		 * 
		 * 바이트 스트림
		 * - 입력(InputStream) : fileInputStream, BufferedInputStream, DataInputStream...
		 * - 출력(OutputStream) : fileOutputStream, BufferedOutputStream, DataOutStream, PrintWriter...
		 * 
		 * 문자 스트림
		 * - 입력(Reader) : FileReader, BufferedReader, InputStreamReader...
		 * - 출력(Writer) : FileWriter, BufferedWriter, PrintWriter...
		 * 
		 * 
		 * 기반스트림 / 보조스트림
		 * 기반스트림: 직접 자료를 읽고 쓰는 기능이 있는 스트림
		 * - FileInputStream, FileOutStream, FileReader, FileWriter
		 * 보조스트림: 직접 읽고 쓰는 기능은 없지만 추가적인 기능을 더해주는 스트림
		 * - Buffered
		 * 
		 * 표준 출력(모니터 = 콘솔) 스트림
		 * System.out.println();
		 * 
		 * 표준 입력(키보드) 스트림
		 * 
		 * System.in.read(); // 한번에 한 바이트 읽기, try~catch문으로만 사용 가능
		 * 
		 * 표준 에러 출력 스트림
		 * System.error.println("error");
		 */
	}

}
