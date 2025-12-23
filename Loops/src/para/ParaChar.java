package para;

public class ParaChar {

	public static void main(String[] args) {
		String nome = "Bruno";
		
		for(char c:nome.toCharArray()) {
			
			System.out.printf("%c ", c);
		}
	}
}
