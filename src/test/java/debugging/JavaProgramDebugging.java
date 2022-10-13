package debugging;

public class JavaProgramDebugging {

	public static void main(String[] args) {
		System.out.println("From Main");
		int result = add(10,20);
		System.out.println(result);
	}
	
	public static int add(int a, int b) {
		return a+b;
	}

}
