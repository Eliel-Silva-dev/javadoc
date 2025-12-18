package parametros;

public class Soma {

	public static void main(String[] args) {
		
		System.out.println(soma(1,2,3,4,5,6,7));
	}
	
	public static int soma(int... numeros) {
		int res = 0;
		
		for(int n:numeros) {
			res += n;
		}
		return res;
	}
}
